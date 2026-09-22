-- Requiere autenticación anónima habilitada en Supabase Auth.
create table if not exists public.relevo_sessions (
  session_id uuid primary key,
  user_id uuid not null default auth.uid() references auth.users(id) on delete cascade,
  participant_code text not null check (char_length(participant_code) between 3 and 24),
  activity text not null check (char_length(activity) between 1 and 120),
  first_step text not null check (char_length(first_step) between 1 and 160),
  place text not null check (char_length(place) between 1 and 160),
  target_package text not null,
  target_app_label text not null,
  threshold_seconds integer not null check (threshold_seconds between 1 and 21600),
  started_at timestamptz not null,
  signal_at timestamptz,
  closed_at timestamptz,
  observed_seconds integer not null default 0 check (observed_seconds >= 0),
  outcome text check (outcome is null or outcome in ('started', 'later', 'changed', 'not_answered')),
  consent_version text not null
);

create table if not exists public.relevo_events (
  id bigint generated always as identity primary key,
  user_id uuid not null default auth.uid() references auth.users(id) on delete cascade,
  client_event_id text not null unique,
  session_id uuid not null,
  participant_code text not null check (char_length(participant_code) between 3 and 24),
  event_type text not null check (event_type in ('armed', 'target_entered', 'target_left', 'signal_emitted', 'disarmed', 'silenced', 'closed')),
  target_package text not null,
  value_seconds integer check (value_seconds is null or value_seconds >= 0),
  consent_version text not null,
  created_at timestamptz not null default now()
);

-- Compatibilidad si el esquema anterior ya fue ejecutado.
alter table public.relevo_events add column if not exists client_event_id text;
update public.relevo_events set client_event_id = 'legacy-' || id::text where client_event_id is null;
alter table public.relevo_events alter column client_event_id set not null;
drop index if exists public.relevo_events_client_event_idx;

create index if not exists relevo_sessions_user_started_idx on public.relevo_sessions (user_id, started_at desc);
create index if not exists relevo_sessions_activity_idx on public.relevo_sessions (activity, started_at desc);
create index if not exists relevo_events_user_created_idx on public.relevo_events (user_id, created_at desc);
create index if not exists relevo_events_session_idx on public.relevo_events (session_id, created_at);

alter table public.relevo_sessions enable row level security;
alter table public.relevo_events enable row level security;

revoke all on table public.relevo_sessions from anon, authenticated;
revoke all on table public.relevo_events from anon, authenticated;
grant select, insert, update on table public.relevo_sessions to authenticated;
grant insert on table public.relevo_events to authenticated;
grant usage, select on sequence public.relevo_events_id_seq to authenticated;

drop policy if exists "participants insert own sessions" on public.relevo_sessions;
create policy "participants insert own sessions" on public.relevo_sessions for insert to authenticated
with check ((select auth.uid()) = user_id);

drop policy if exists "participants read own sessions" on public.relevo_sessions;
create policy "participants read own sessions" on public.relevo_sessions for select to authenticated
using ((select auth.uid()) = user_id);

drop policy if exists "participants update own sessions" on public.relevo_sessions;
create policy "participants update own sessions" on public.relevo_sessions for update to authenticated
using ((select auth.uid()) = user_id)
with check ((select auth.uid()) = user_id);

drop policy if exists "participants insert own events" on public.relevo_events;
create policy "participants insert own events"
on public.relevo_events
for insert
to authenticated
with check ((select auth.uid()) = user_id);

-- La aplicación solo puede leer y actualizar sus propias sesiones para permitir
-- reintentos idempotentes. Los eventos son de solo inserción. La revisión
-- académica se realiza desde un entorno administrativo protegido.
