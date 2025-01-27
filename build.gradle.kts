plugins {
    id("java")
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    group = "org.example"
    version = "1.0-SNAPSHOT"

    val configVersion = "1.4.3"
    val slf4jVersion = "2.0.16"

    dependencies {
        implementation("com.typesafe:config:${configVersion}")

        testImplementation("org.slf4j:slf4j-simple:${slf4jVersion}")
    }

    tasks.test {
        testLogging {
            events("passed", "skipped", "failed")
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }
}