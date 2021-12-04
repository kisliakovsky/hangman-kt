import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlin = "1.5.10"
    val detekt = "1.19.0"
    val shadowJar = "7.1.0"
    val dependencyCheck = "6.5.0.1"

    kotlin("jvm") version kotlin
    id("io.gitlab.arturbosch.detekt") version detekt
    id("com.github.johnrengelman.shadow") version shadowJar
    id("org.owasp.dependencycheck") version dependencyCheck
}

group = "org.kislyi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val hamcrest = "2.2"
    val kotest = "5.0.1"
    val mockk = "1.12.1"

    testImplementation(kotlin("test"))
    testImplementation("org.hamcrest:hamcrest:$hamcrest")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotest")
    testImplementation("io.mockk:mockk:$mockk")
    runtimeOnly("io.kotest:kotest-assertions-core-jvm:$kotest")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.shadowJar {
    manifest {
        attributes("Main-Class" to "org.kislyi.hangman.HangmanGameAppKt")
    }
}
