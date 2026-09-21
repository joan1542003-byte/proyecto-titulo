-- Ejecutar en un proyecto Supabase controlado por el responsable de la investigación.
create table public.relevo_events (
  id bigint generated always as identity primary key,
  session_id uuid not null,
  participant_code text not null check (char_length(participant_code) between 3 and 24),
  event_type text not null check (event_type in ('armed', 'target_entered', 'target_left', 'signal_emitted', 'disarmed', 'silenced', 'closed')),
  target_package text not null,
  value_seconds integer check (value_seconds is null or value_seconds >= 0),
  consent_version text not null,
  created_at timestamptz not null default now()
);

alter table public.relevo_events enable row level security;

-- No se crea una política pública de lectura. La aplicación solo podrá insertar
-- cuando se configure una política restringida y una función de ingreso validada.
