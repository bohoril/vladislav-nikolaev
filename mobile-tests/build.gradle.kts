val appiumVersion = "9.3.0"
val testngVersion = "7.10.2"

dependencies {
    implementation("io.appium:java-client:${appiumVersion}")
    testImplementation("org.testng:testng:${testngVersion}")
}

tasks.test {
    useTestNG()
}