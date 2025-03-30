import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
}

apply("../repositories.gradle.kts")

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))  // Указываем совместимую версию JDK (например, 17)
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}