import java.util.Properties

plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.compose.compiler)
}

// D-161: relevo.properties, en el repositorio, trae la dirección de Supabase y su clave publicable;
// local.properties, de cada computador, puede reemplazarlas. Así cualquier computador compila una versión que envía datos.
val localProperties = Properties().apply {
  listOf("relevo.properties", "local.properties").forEach { name ->
    rootProject.file(name).takeIf { it.exists() }?.inputStream()?.use(::load)
  }
}

android {
    namespace = "cl.udp.relevo"
    compileSdk = 36
    defaultConfig {
        applicationId = "cl.udp.relevo"
        minSdk = 31
        targetSdk = 36
        versionCode = 63
        versionName = "4.7.2"
        manifestPlaceholders["appLabel"] = "@string/app_name"
        // 4.0: para revisar un rediseño en un teléfono que ya tiene Relevo, sin reemplazarlo ni tocar sus datos,
        // se instala aparte: ./gradlew assembleDebug -PrelevoSuffix=.revision
        providers.gradleProperty("relevoSuffix").orNull?.let { suffix ->
          applicationIdSuffix = suffix
          manifestPlaceholders["appLabel"] = "Relevo $versionName"
        }
        buildConfigField("String", "SUPABASE_URL", "\"${localProperties.getProperty("SUPABASE_URL", "")}\"")
        buildConfigField("String", "SUPABASE_PUBLISHABLE_KEY", "\"${localProperties.getProperty("SUPABASE_PUBLISHABLE_KEY", "")}\"")
    }

    // D-161: la clave de firma de siempre está en firma/, así que el Mac y este computador firman igual
    // y cada versión se instala encima de la anterior sin perder datos. Es la clave de depuración estándar.
    signingConfigs {
        getByName("debug") {
            val shared = rootProject.file("firma/relevo-debug.keystore")
            if (shared.exists()) {
                storeFile = shared
                storePassword = "android"
                keyAlias = "androiddebugkey"
                keyPassword = "android"
            }
        }
    }

    buildTypes {
        release {
            // 2.28: la versión para teléfonos va optimizada (sin depuración, con R8 y los perfiles de Compose)
            // para que se mueva a la frecuencia de la pantalla. Se firma con la clave de depuración de siempre
            // (firma/relevo-debug.keystore), la misma de las versiones anteriores, para instalarse encima sin perder datos.
            isMinifyEnabled = true
            isShrinkResources = true
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
      compose = true
      aidl = false
      buildConfig = true
      shaders = false
    }

    packaging {
      resources {
        excludes += "/META-INF/{AL2.0,LGPL2.1}"
      }
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
  val composeBom = platform(libs.androidx.compose.bom)
  implementation(composeBom)
  androidTestImplementation(composeBom)

  // Core Android dependencies
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.activity.compose)

  // Arch Components
  implementation(libs.androidx.lifecycle.runtime.compose)
  implementation(libs.androidx.lifecycle.viewmodel.compose)

  // Compose
  implementation(libs.androidx.compose.ui)
  implementation(libs.androidx.compose.ui.tooling.preview)
  implementation(libs.androidx.compose.material3)
  // Vidrio de la capa de navegación: desenfoque real con RenderEffect (Android 12+), D-083.
  implementation("dev.chrisbanes.haze:haze:1.6.10")
  // Mensajes del proyecto al instante: conexión Realtime de Supabase por WebSocket (D-096).
  implementation("com.squareup.okhttp3:okhttp:4.12.0")
  // Tooling
  debugImplementation(libs.androidx.compose.ui.tooling)
  // Instrumented tests
  androidTestImplementation(libs.androidx.compose.ui.test.junit4)
  debugImplementation(libs.androidx.compose.ui.test.manifest)

  // Local tests: jUnit, coroutines, Android runner
  testImplementation(libs.junit)
  testImplementation(libs.kotlinx.coroutines.test)

  // Instrumented tests: jUnit rules and runners
  androidTestImplementation(libs.androidx.test.core)
  androidTestImplementation(libs.androidx.test.ext.junit)
  androidTestImplementation(libs.androidx.test.runner)
  androidTestImplementation(libs.androidx.test.espresso.core)

}
