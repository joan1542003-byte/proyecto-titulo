-- Repaso Relevo: el avance de estudio del autor, guardado en Supabase (26 de noviembre de 2026).
-- Va en un proyecto propio, repaso-relevo (vogqmiuhlgcajhhzvrws), aparte del de la app y sin relación con la prueba ni
-- con sus participantes. Son dos tablas que nadie lee ni escribe directo:
-- solo las dos funciones de abajo, y solo con una clave registrada en repaso_claves. De cada clave se guarda su
-- huella SHA-256, nunca la clave. La clave está solo en el computador del autor (Documentos).
-- Se corre una vez en el editor SQL de Supabase. Al final, reemplazar <HUELLA> por la huella de la clave.

create table if not exists public.repaso_claves (
  huella text primary key check (huella ~ '^[0-9a-f]{64}$'),
  vence timestamptz,                                  -- solo para claves de prueba; las del autor no vencen
  creada timestamptz not null default now()
);

create table if not exists public.repaso_avance (
  huella text primary key references public.repaso_claves (huella) on delete cascade,
  datos jsonb not null,
  actualizado timestamptz not null default now()
);

alter table public.repaso_claves enable row level security;
alter table public.repaso_avance enable row level security;
revoke all on table public.repaso_claves from anon, authenticated;
revoke all on table public.repaso_avance from anon, authenticated;

-- Lee el avance guardado con una clave. Devuelve null si todavía no hay nada.
create or replace function public.repaso_leer(clave text)
returns jsonb
language plpgsql
security definer
set search_path = ''
as $$
declare
  h text := encode(sha256(convert_to(coalesce(clave, ''), 'UTF8')), 'hex');
  d jsonb;
begin
  if not exists (select 1 from public.repaso_claves k where k.huella = h and (k.vence is null or k.vence > now())) then
    raise exception 'Clave no registrada' using errcode = '28000';
  end if;
  select a.datos into d from public.repaso_avance a where a.huella = h;
  return d;
end;
$$;

-- Guarda el avance de una clave, en un solo registro que se reemplaza. Borra antes las claves de prueba vencidas.
create or replace function public.repaso_guardar(clave text, datos jsonb)
returns timestamptz
language plpgsql
security definer
set search_path = ''
as $$
declare
  h text := encode(sha256(convert_to(coalesce(clave, ''), 'UTF8')), 'hex');
  t timestamptz;
begin
  delete from public.repaso_claves k where k.vence is not null and k.vence < now();
  if not exists (select 1 from public.repaso_claves k where k.huella = h) then
    raise exception 'Clave no registrada' using errcode = '28000';
  end if;
  if datos is null or jsonb_typeof(datos) <> 'object' or pg_column_size(datos) > 300000 then
    raise exception 'Avance no válido' using errcode = '22023';
  end if;
  insert into public.repaso_avance (huella, datos, actualizado) values (h, datos, now())
  on conflict (huella) do update set datos = excluded.datos, actualizado = now()
  returning actualizado into t;
  return t;
end;
$$;

revoke all on function public.repaso_leer(text) from public;
revoke all on function public.repaso_guardar(text, jsonb) from public;
grant execute on function public.repaso_leer(text) to anon, authenticated;
grant execute on function public.repaso_guardar(text, jsonb) to anon, authenticated;

-- La clave del autor. Para cambiarla: borrar su fila y registrar la huella de la nueva.
insert into public.repaso_claves (huella) values ('<HUELLA>') on conflict (huella) do nothing;

-- Para borrar todo el avance del servidor:
--   delete from public.repaso_claves;
-- Para quitar Repaso Relevo del servidor:
--   drop function public.repaso_guardar(text, jsonb); drop function public.repaso_leer(text);
--   drop table public.repaso_avance; drop table public.repaso_claves;
