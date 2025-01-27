plugins {
    id("io.qameta.allure") version "2.12.0"
}

val junitVersion = "5.11.4"
val restAssuredVersion = "5.5.0"
val allureVersion = "2.29.0"
val jacksonVersion = "2.18.2"
val lombokVersion = "1.18.36"

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:${jacksonVersion}")

    compileOnly("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")

    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
    testImplementation("io.rest-assured:rest-assured:${restAssuredVersion}")
    testImplementation("io.qameta.allure:allure-junit5:${allureVersion}")

    testCompileOnly("org.projectlombok:lombok:${lombokVersion}")
    testAnnotationProcessor("org.projectlombok:lombok:${lombokVersion}")
}

allure {
    version = allureVersion
    adapter.aspectjWeaver = true
}

tasks.test {
    useJUnitPlatform()
}