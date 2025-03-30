import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.spring") version Version.KOTLIN_SPRING
    id("org.springframework.boot") version Version.SPRING
    id("io.spring.dependency-management") version Version.DEPENDENCY_MANAGEMENT
}

java { toolchain { languageVersion.set(JavaLanguageVersion.of(17)) } }

tasks {
    withType<KotlinCompile> { kotlinOptions.jvmTarget = "17" }

    bootJar { archiveFileName.set("app.jar") }

    jar { enabled = false }
}

dependencies {
    implementation(project(":api"))
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("io.jsonwebtoken:jjwt-api:0.12.6")
    implementation("io.jsonwebtoken:jjwt-impl:0.12.6")
    implementation("io.jsonwebtoken:jjwt-gson:0.12.6")
    implementation("io.github.microutils:kotlin-logging-jvm:2.1.21")
    implementation("org.springframework.boot:spring-boot-starter-logging")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.postgresql:postgresql")
    implementation("org.liquibase:liquibase-core")
}