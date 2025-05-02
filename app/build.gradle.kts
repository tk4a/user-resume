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
}

dependencies {
    implementation(project(":api"))
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")

    implementation("io.github.microutils:kotlin-logging-jvm:2.1.21")
    implementation("org.postgresql:postgresql")
    implementation("io.r2dbc:r2dbc-postgresql:${Version.R2DBC_POSTGRESQL}")
    implementation("org.liquibase:liquibase-core")
    implementation("com.zaxxer:HikariCP")
}