# Reglas de R8 para la versión optimizada de Relevo (2.28).
# Compose, OkHttp y las corrutinas traen sus propias reglas. Los nombres de los enum se guardan como texto
# (SignalRoute, ReminderStatus, StudyPlan…), así que se conservan sus valores.
-keepclassmembers enum com.example.relevo.** { *; }
