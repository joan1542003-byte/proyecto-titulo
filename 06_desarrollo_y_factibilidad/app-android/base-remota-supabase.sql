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
  target_apps jsonb not null default '[]'::jsonb,
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
  event_type text not null check (event_type in ('armed', 'target_entered', 'target_left', 'signal_emitted', 'signal_failed', 'signal_ended', 'signal_interrupted', 'disarmed', 'silenced', 'responded', 'closed', 'monitor_paused', 'monitor_resumed')),
  target_package text not null,
  value_seconds integer check (value_seconds is null or value_seconds >= 0),
  consent_version text not null,
  created_at timestamptz not null default now()
);

-- Compatibilidad si el esquema anterior ya fue ejecutado.
alter table public.relevo_sessions add column if not exists target_apps jsonb not null default '[]'::jsonb;
alter table public.relevo_events add column if not exists client_event_id text;
update public.relevo_events set client_event_id = 'legacy-' || id::text where client_event_id is null;
alter table public.relevo_events alter column client_event_id set not null;
alter table public.relevo_events drop constraint if exists relevo_events_event_type_check;
alter table public.relevo_events add constraint relevo_events_event_type_check check (event_type in ('armed', 'target_entered', 'target_left', 'signal_emitted', 'signal_failed', 'signal_ended', 'signal_interrupted', 'disarmed', 'silenced', 'responded', 'closed', 'monitor_paused', 'monitor_resumed'));
drop index if exists public.relevo_events_client_event_idx;

create index if not exists relevo_sessions_user_started_idx on public.relevo_sessions (user_id, started_at desc);
create index if not exists relevo_sessions_activity_idx on public.relevo_sessions (activity, started_at desc);
create index if not exists relevo_events_user_created_idx on public.relevo_events (user_id, created_at desc);
create index if not exists relevo_events_session_idx on public.relevo_events (session_id, created_at);

alter table public.relevo_sessions enable row level security;
alter table public.relevo_events enable row level security;

revoke all on table public.relevo_sessions from anon, authenticated;
revoke all on table public.relevo_events from anon, authenticated;
grant select, insert, update, delete on table public.relevo_sessions to authenticated;
grant select, insert, delete on table public.relevo_events to authenticated;
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

drop policy if exists "participants read own events" on public.relevo_events;
create policy "participants read own events" on public.relevo_events for select to authenticated
using ((select auth.uid()) = user_id);

drop policy if exists "participants delete own events" on public.relevo_events;
create policy "participants delete own events" on public.relevo_events for delete to authenticated
using ((select auth.uid()) = user_id);

drop policy if exists "participants delete own sessions" on public.relevo_sessions;
create policy "participants delete own sessions" on public.relevo_sessions for delete to authenticated
using ((select auth.uid()) = user_id);

-- Prueba de 21 días (protocolo 02, Android 2.7): condición de la semana, preguntas tras la señal,
-- fin del sonido, tiempo de respuesta y uso de las apps elegidas 10 minutos antes y después.
alter table public.relevo_sessions
  add column if not exists study_condition text check (study_condition is null or study_condition in ('A', 'B', 'C')),
  add column if not exists study_day integer check (study_day is null or study_day between 0 and 60),
  add column if not exists knew_intention text check (knew_intention is null or knew_intention in ('yes', 'partly', 'no')),
  add column if not exists recalled_first_step text check (recalled_first_step is null or recalled_first_step in ('yes', 'no')),
  add column if not exists signal_end text check (signal_end is null or signal_end in ('silenced', 'auto', 'interrupted')),
  add column if not exists response_seconds integer check (response_seconds is null or response_seconds >= 0),
  add column if not exists usage_before_seconds integer check (usage_before_seconds is null or usage_before_seconds between 0 and 660),
  add column if not exists usage_after_seconds integer check (usage_after_seconds is null or usage_after_seconds between 0 and 660);

-- Respuestas de las tarjetas semanales, del cierre del día 21 y de la configuración de la prueba.
create table if not exists public.relevo_answers (
  id bigint generated always as identity primary key,
  user_id uuid not null default auth.uid() references auth.users(id) on delete cascade,
  client_answer_id text not null unique,
  participant_code text not null check (char_length(participant_code) between 3 and 24),
  session_id uuid,
  question text not null check (char_length(question) between 1 and 40),
  answer text not null check (char_length(answer) <= 600),
  consent_version text not null,
  created_at timestamptz not null default now()
);
create index if not exists relevo_answers_user_created_idx on public.relevo_answers (user_id, created_at desc);

alter table public.relevo_answers enable row level security;
revoke all on table public.relevo_answers from anon, authenticated;
-- La lectura es necesaria para que PostgreSQL resuelva on_conflict (sin ella, la inserción falla con 42501).
grant select, insert, delete on table public.relevo_answers to authenticated;
grant usage, select on sequence public.relevo_answers_id_seq to authenticated;

drop policy if exists "participants insert own answers" on public.relevo_answers;
create policy "participants insert own answers" on public.relevo_answers for insert to authenticated
with check ((select auth.uid()) = user_id);
drop policy if exists "participants read own answers" on public.relevo_answers;
create policy "participants read own answers" on public.relevo_answers for select to authenticated
using ((select auth.uid()) = user_id);
drop policy if exists "participants delete own answers" on public.relevo_answers;
create policy "participants delete own answers" on public.relevo_answers for delete to authenticated
using ((select auth.uid()) = user_id);

-- La aplicación puede leer, registrar y eliminar únicamente sus propias filas.
-- Los eventos se insertan una vez y se pueden borrar a solicitud de la persona.
-- La revisión académica se realiza desde un entorno administrativo protegido.

-- Android 2.11 (28 de septiembre de 2026): salida real del sonido y versión de la app en cada relevo.
alter table public.relevo_sessions
  add column if not exists signal_route text check (signal_route is null or signal_route in ('bluetooth', 'phone')),
  add column if not exists app_version text check (app_version is null or char_length(app_version) <= 20);

-- Vistas de análisis para el investigador (panel de Supabase). El esquema no se expone por la API
-- y las vistas usan los permisos de quien consulta.
create schema if not exists analisis;
revoke all on schema analisis from public, anon, authenticated;

create or replace view analisis.relevos with (security_invoker = true) as
select
  s.participant_code, s.session_id, s.study_day, s.study_condition, s.signal_route, s.app_version,
  s.activity, s.first_step, s.place, s.target_app_label, jsonb_array_length(s.target_apps) as apps_elegidas,
  round(s.threshold_seconds / 60.0, 1) as minutos_configurados,
  (s.started_at at time zone 'America/Santiago') as activado,
  (s.signal_at at time zone 'America/Santiago') as sono,
  (s.closed_at at time zone 'America/Santiago') as respondido,
  s.signal_at is not null as hubo_senal, s.signal_end, s.response_seconds, s.outcome,
  s.knew_intention, s.recalled_first_step, s.usage_before_seconds, s.usage_after_seconds
from public.relevo_sessions s;

create or replace view analisis.resumen_por_condicion with (security_invoker = true) as
select
  participant_code,
  coalesce(study_condition, 'fuera de la prueba') as condicion,
  count(*) as relevos,
  count(*) filter (where signal_at is not null) as con_senal,
  count(*) filter (where outcome = 'started') as comenzo,
  count(*) filter (where outcome = 'later') as despues,
  count(*) filter (where outcome = 'changed') as cambio_de_idea,
  count(*) filter (where knew_intention = 'yes') as supo_que_hacer,
  count(*) filter (where knew_intention = 'partly') as supo_a_medias,
  count(*) filter (where knew_intention = 'no') as no_supo,
  count(*) filter (where recalled_first_step = 'yes') as recordo_primer_paso,
  percentile_cont(0.5) within group (order by response_seconds) as mediana_segundos_respuesta,
  round(avg(usage_before_seconds)) as uso_10_min_antes_promedio,
  round(avg(usage_after_seconds)) as uso_10_min_despues_promedio
from public.relevo_sessions
group by participant_code, coalesce(study_condition, 'fuera de la prueba');

create or replace view analisis.respuestas with (security_invoker = true) as
select participant_code, question as pregunta, answer as respuesta,
  (created_at at time zone 'America/Santiago') as respondida, session_id
from public.relevo_answers;

revoke all on all tables in schema analisis from public, anon, authenticated;

-- Android 2.12 (29 de septiembre de 2026): cómo le cayó el aviso a la persona y registro del uso de la app.
alter table public.relevo_sessions
  add column if not exists signal_feeling text check (signal_feeling is null or signal_feeling in ('good', 'neutral', 'bad'));

create table if not exists public.relevo_app_events (
  id bigint generated always as identity primary key,
  user_id uuid not null default auth.uid() references auth.users(id) on delete cascade,
  client_event_id text not null unique,
  participant_code text not null check (char_length(participant_code) between 3 and 24),
  event text not null check (char_length(event) between 1 and 40),
  detail text check (detail is null or char_length(detail) <= 600),
  app_version text check (app_version is null or char_length(app_version) <= 20),
  consent_version text not null,
  created_at timestamptz not null default now()
);
create index if not exists relevo_app_events_user_created_idx on public.relevo_app_events (user_id, created_at desc);
create index if not exists relevo_app_events_code_created_idx on public.relevo_app_events (participant_code, created_at);

alter table public.relevo_app_events enable row level security;
revoke all on table public.relevo_app_events from anon, authenticated;
grant select, insert, delete on table public.relevo_app_events to authenticated;
grant usage, select on sequence public.relevo_app_events_id_seq to authenticated;

drop policy if exists "participants insert own app events" on public.relevo_app_events;
create policy "participants insert own app events" on public.relevo_app_events for insert to authenticated
with check ((select auth.uid()) = user_id);
drop policy if exists "participants read own app events" on public.relevo_app_events;
create policy "participants read own app events" on public.relevo_app_events for select to authenticated
using ((select auth.uid()) = user_id);
drop policy if exists "participants delete own app events" on public.relevo_app_events;
create policy "participants delete own app events" on public.relevo_app_events for delete to authenticated
using ((select auth.uid()) = user_id);

-- analisis.relevos suma signal_feeling al final (se recrea con la misma definición de 2.11 más esa columna).
create or replace view analisis.relevos with (security_invoker = true) as
select
  s.participant_code, s.session_id, s.study_day, s.study_condition, s.signal_route, s.app_version,
  s.activity, s.first_step, s.place, s.target_app_label, jsonb_array_length(s.target_apps) as apps_elegidas,
  round(s.threshold_seconds / 60.0, 1) as minutos_configurados,
  (s.started_at at time zone 'America/Santiago') as activado,
  (s.signal_at at time zone 'America/Santiago') as sono,
  (s.closed_at at time zone 'America/Santiago') as respondido,
  s.signal_at is not null as hubo_senal, s.signal_end, s.response_seconds, s.outcome,
  s.knew_intention, s.recalled_first_step, s.usage_before_seconds, s.usage_after_seconds,
  s.signal_feeling
from public.relevo_sessions s;

create or replace view analisis.uso with (security_invoker = true) as
select participant_code, event as evento, detail as detalle, app_version,
  (created_at at time zone 'America/Santiago') as momento
from public.relevo_app_events;

create or replace view analisis.resumen_de_uso with (security_invoker = true) as
select
  participant_code,
  min(created_at at time zone 'America/Santiago') as primer_uso,
  max(created_at at time zone 'America/Santiago') as ultimo_uso,
  count(distinct (created_at at time zone 'America/Santiago')::date) as dias_con_uso,
  count(*) filter (where event = 'app_abierta') as aperturas,
  round(coalesce(sum(case when event = 'app_cerrada' and detail ~ '^segundos=[0-9]+$' then substring(detail from 10)::int end), 0) / 60.0, 1) as minutos_en_la_app,
  count(*) filter (where event = 'pantalla') as pantallas_vistas,
  count(*) filter (where event = 'preparar_abierto') as preparaciones_abiertas,
  count(*) filter (where event = 'preparar_cerrado') as preparaciones_sin_activar
from public.relevo_app_events
group by participant_code;

revoke all on all tables in schema analisis from public, anon, authenticated;
