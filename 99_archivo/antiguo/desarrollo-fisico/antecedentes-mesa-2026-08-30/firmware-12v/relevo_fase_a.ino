#include <Arduino.h>

// Montaje de fase A. Estos pines deben comprobarse antes de cablear.
constexpr uint8_t LED_PWM_PIN = 9;
constexpr uint8_t ACTIVATE_PIN = 2;
constexpr uint8_t SILENCE_PIN = 3;

// Tres niveles reproducibles para calibración previa. No representan porcentajes
// perceptivos ni fijan la intensidad que se utilizará con participantes.
constexpr uint8_t PWM_LEVELS[] = {48, 96, 160};
constexpr uint8_t ACTIVE_LEVEL_INDEX = 1;

static_assert(ACTIVE_LEVEL_INDEX <
                  (sizeof(PWM_LEVELS) / sizeof(PWM_LEVELS[0])),
              "El nivel PWM seleccionado debe existir");

constexpr uint8_t PULSE_COUNT = 3;
constexpr uint32_t PULSE_ON_MS = 500;
constexpr uint32_t INTER_PULSE_OFF_MS = 750;
constexpr uint32_t ACTIVATION_DEBOUNCE_MS = 30;
constexpr uint32_t SILENCE_DEBOUNCE_MS = 30;
constexpr uint32_t SEQUENCE_TOTAL_MS =
    (PULSE_COUNT * PULSE_ON_MS) +
    ((PULSE_COUNT - 1) * INTER_PULSE_OFF_MS);
constexpr uint32_t PULSE_1_END_MS = PULSE_ON_MS;
constexpr uint32_t GAP_1_END_MS = PULSE_1_END_MS + INTER_PULSE_OFF_MS;
constexpr uint32_t PULSE_2_END_MS = GAP_1_END_MS + PULSE_ON_MS;
constexpr uint32_t GAP_2_END_MS = PULSE_2_END_MS + INTER_PULSE_OFF_MS;

static_assert(SEQUENCE_TOTAL_MS == 3000,
              "La secuencia nominal debe sumar 3000 ms");
static_assert(PULSE_COUNT == 3,
              "Los límites absolutos implementan tres pulsos");

enum class SignalState : uint8_t {
  Idle,
  Running,
};

SignalState signalState = SignalState::Idle;
uint32_t sequenceStartedAt = 0;

bool activationRaw = HIGH;
bool activationStable = HIGH;
uint32_t activationLastChangedAt = 0;

bool silenceRaw = HIGH;
bool silenceStable = HIGH;
uint32_t silenceLastChangedAt = 0;

void setLight(bool enabled) {
  analogWrite(LED_PWM_PIN,
              enabled ? PWM_LEVELS[ACTIVE_LEVEL_INDEX] : 0);
}

void returnToIdle() {
  setLight(false);
  signalState = SignalState::Idle;
}

bool silenceAllowsSignal(uint32_t now) {
  const bool reading = digitalRead(SILENCE_PIN);

  if (reading != silenceRaw) {
    silenceRaw = reading;
    silenceLastChangedAt = now;
  }

  if (silenceStable != silenceRaw &&
      now - silenceLastChangedAt >= SILENCE_DEBOUNCE_MS) {
    silenceStable = silenceRaw;
  }

  // Un LOW bloquea la señal de inmediato. Al volver a HIGH se exige una
  // posición estable antes de aceptar otra activación.
  return silenceRaw == HIGH && silenceStable == HIGH &&
         now - silenceLastChangedAt >= SILENCE_DEBOUNCE_MS;
}

bool activationPressed(uint32_t now) {
  const bool reading = digitalRead(ACTIVATE_PIN);

  if (reading != activationRaw) {
    activationRaw = reading;
    activationLastChangedAt = now;
  }

  if (reading != activationStable &&
      now - activationLastChangedAt >= ACTIVATION_DEBOUNCE_MS) {
    const bool previousStable = activationStable;
    activationStable = reading;
    return previousStable == HIGH && activationStable == LOW;
  }

  return false;
}

void startSignal(uint32_t now) {
  sequenceStartedAt = now;
  signalState = SignalState::Running;
  setLight(true);
}

bool lightShouldBeOn(uint32_t elapsed) {
  if (elapsed < PULSE_1_END_MS) return true;
  if (elapsed < GAP_1_END_MS) return false;
  if (elapsed < PULSE_2_END_MS) return true;
  if (elapsed < GAP_2_END_MS) return false;
  return elapsed < SEQUENCE_TOTAL_MS;
}

void updateSignal(uint32_t now) {
  if (!silenceAllowsSignal(now)) {
    // Leer el pulsador durante el silencio impide que una pulsación sostenida
    // se convierta en una orden al rehabilitar el montaje.
    activationPressed(now);
    returnToIdle();
    return;
  }

  if (signalState == SignalState::Idle) {
    if (activationPressed(now)) {
      startSignal(now);
    }
    return;
  }

  // Las órdenes recibidas durante la secuencia se leen, pero no se almacenan.
  activationPressed(now);

  const uint32_t elapsed = now - sequenceStartedAt;
  if (elapsed >= SEQUENCE_TOTAL_MS) {
    returnToIdle();
    return;
  }

  // Todos los límites se calculan desde un único inicio. Así, un retraso breve
  // del ciclo no se acumula en cada transición.
  setLight(lightShouldBeOn(elapsed));
}

void setup() {
  pinMode(LED_PWM_PIN, OUTPUT);
  pinMode(ACTIVATE_PIN, INPUT_PULLUP);
  pinMode(SILENCE_PIN, INPUT_PULLUP);

  // El programa parte apagado. La condición eléctrica del módulo MOSFET antes
  // de ejecutar setup() debe verificarse en el montaje real.
  returnToIdle();

  const uint32_t now = millis();
  activationRaw = digitalRead(ACTIVATE_PIN);
  activationStable = activationRaw;
  activationLastChangedAt = now;
  silenceRaw = digitalRead(SILENCE_PIN);
  silenceStable = silenceRaw;
  silenceLastChangedAt = now;
}

void loop() {
  updateSignal(millis());
}
