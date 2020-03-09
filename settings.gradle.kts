pluginManagement {
  repositories {
    gradlePluginPortal()
  }
  plugins {
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.spring") version "1.3.61"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
  }
}
rootProject.name = "play-with-kotlin-dsl"
