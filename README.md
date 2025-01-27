Project contains:
* Exploratory testing report for Monefy mobile application
* API test automation framework for Swagger PetStore sample
* Mobile test automation framework for Monefy application

### Exploratory testing report
To view the exploratory testing report, open the file `monefy_exploratory_testing.md` in the root of the project.

### API test automation framework for PetStore service
**Framework stack:**
* Java
* Gradle
* JUnit5
* REST Assured
* Lombok
* Allure

**How to run tests:**

Run the PetStore service locally using the following guide (I did it with Maven and jetty): https://github.com/swagger-api/swagger-petstore

To run tests use the command:

`./gradlew clean :api-tests:test`

To download Allure report use the command:

`./gradlew allureReport`

To generate Allure report use the command:

`./gradlew allureServe`

To open existing Allure report `allure-report/allureReport` please install Allure on your PC and use the command:

`allure open api-tests/allure-report/allureReport`

For Intellij IDEA, it is required to install the `Lombok` plugin:

https://plugins.jetbrains.com/plugin/6317-lombok

**Approach**

The framework is designed to cover the main functionality of the /store endpoints of PetStore service.

I am using `RestAssured` library to send requests and validate responses. `Lombok` library is used to reduce boilerplate code. `Allure` library is used to generate test reports.`JUnit` to run tests.

I have created `StoreController` to simplify interaction with API and increase readability. I am using DTO design patter to create models for store and use them for serializing/deserializing to/from JSON.

I have added `Allure` steps to improve report readability and easy debugging.

### Mobile test automation framework for Monefy application

**Framework stack:**
* Java
* Gradle
* TestNG
* Appium

**How to run tests:**

Install Node: https://nodejs.org/en/download

Install Appium using the command:

`npm install -g appium`

Install UiAutomator2 driver using the command:

`appium driver install uiautomator2`

Download Android Studio: https://developer.android.com/studio

Set up Android Emulator (Choose Pixel 4 API 31): https://developer.android.com/studio/run/emulator

Ensure that the environment variables `JAVA_HOME` and `ANDROID_HOME` are set up correctly.

Run android emulator `Pixel 4 API 31`

To run tests use the command:

`./gradlew clean :mobile-tests:test`

To open the existing TestNG report use the command:

`open mobile-tests/testng-report/test/index.html`

**Approach**
The framework is designed to cover the main functionality of the Monefy mobile application.

I am using `Appium` library to interact with the mobile application. `TestNG` to run tests.

I have created `BaseTest` to simplify interaction with Appium and increase readability. I am using Page Object design pattern to create models for mobile screens and use them for interaction with the application.
