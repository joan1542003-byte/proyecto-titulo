-- Requiere autenticación anónima habilitada en Supabase Auth.
create table if not exists public.relevo_events (
  id bigint generated always as identity primary key,
  user_id uuid not null default auth.uid() references auth.users(id) on delete cascade,
  session_id uuid not null,
  participant_code text not null check (char_length(participant_code) between 3 and 24),
  event_type text not null check (event_type in ('armed', 'target_entered', 'target_left', 'signal_emitted', 'disarmed', 'silenced', 'closed')),
  target_package text not null,
  value_seconds integer check (value_seconds is null or value_seconds >= 0),
  consent_version text not null,
  created_at timestamptz not null default now()
);

create index if not exists relevo_events_session_idx on public.relevo_events (session_id);
create index if not exists relevo_events_created_at_idx on public.relevo_events (created_at desc);

alter table public.relevo_events enable row level security;

revoke all on table public.relevo_events from anon, authenticated;
grant insert on table public.relevo_events to authenticated;
grant usage, select on sequence public.relevo_events_id_seq to authenticated;

drop policy if exists "participants insert own events" on public.relevo_events;
create policy "participants insert own events"
on public.relevo_events
for insert
to authenticated
with check ((select auth.uid()) = user_id);

-- No política SELECT, UPDATE o DELETE para clientes. La revisión académica se
-- realiza desde un entorno administrativo protegido, nunca desde la aplicación.
