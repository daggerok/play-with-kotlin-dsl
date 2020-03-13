pluginManagement {
  repositories {
    gradlePluginPortal()
  }
  val kotlinVersion: String by extra
  plugins {
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
  }
}
rootProject.name = "play-with-kotlin-dsl"
