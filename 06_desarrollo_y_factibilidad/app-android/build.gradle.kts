// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.compose.compiler) apply false
}

// OneDrive can lock transient test files on Windows. CI or local verification may
// point builds to a non-synchronised directory without changing project sources.
System.getenv("RELEVO_BUILD_DIR")?.let { externalRoot ->
  subprojects {
    layout.buildDirectory.set(file("$externalRoot/${rootProject.name}/${project.name}"))
  }
}
