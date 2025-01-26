plugins {
    id("java")
    id("io.qameta.allure") version "2.12.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

val junitVersion = "5.11.4"
val restAssuredVersion = "5.5.0"
val allureVersion = "2.29.0"
val jacksonVersion = "2.18.2"
val configVersion = "1.4.3"
val lombokVersion = "1.18.36"
val slf4jVersion = "2.0.16"

dependencies {
    implementation("com.typesafe:config:${configVersion}")
    implementation("com.fasterxml.jackson.core:jackson-databind:${jacksonVersion}")

    compileOnly("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")

    testImplementation("io.rest-assured:rest-assured:${restAssuredVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
    testImplementation("org.slf4j:slf4j-simple:${slf4jVersion}")
    testImplementation("io.qameta.allure:allure-junit5:${allureVersion}")

    testCompileOnly("org.projectlombok:lombok:${lombokVersion}")
    testAnnotationProcessor("org.projectlombok:lombok:${lombokVersion}")
}

allure {
    version = allureVersion
    adapter.aspectjWeaver = true
}

tasks.test {
    testLogging {
        events("passed", "skipped", "failed")
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
    useJUnitPlatform()
}