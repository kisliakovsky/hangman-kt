import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.hamcrest:hamcrest:2.2")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.0.1")
    testImplementation("io.mockk:mockk:1.12.1")
    runtimeOnly("io.kotest:kotest-assertions-core-jvm:5.0.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}