plugins {
  application
  kotlin("jvm")
}

group = "daggerok"
version = "1.0.0-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("reflect"))
  implementation(kotlin("stdlib-jdk8"))

  implementation(platform("org.springframework.boot:spring-boot-dependencies:2.2.5.RELEASE"))
  // implementation("org.springframework:spring-context-support")
  // implementation("org.springframework:spring-test")

  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")

  testImplementation(platform("org.junit:junit-bom:5.6.0"))
  testImplementation("org.junit.jupiter:junit-jupiter")
  testImplementation("org.junit.vintage:junit-vintage-engine")
  testImplementation("org.assertj:assertj-core:3.15.0")
}

tasks.withType<Test> {
  useJUnitPlatform()
  testLogging {
    showCauses = true
    showExceptions = true
    showStackTraces = true
    showStandardStreams = true
    events(
        org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED,
        org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
        org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED
    )
  }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf(
        // "-Xcoroutines=enable", // no effect on kotlin >= 1.3, already enabled
        "-Xjsr305=strict"
    )
    jvmTarget = "1.8"
  }
}
