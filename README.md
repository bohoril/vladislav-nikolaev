Project contains:
* Exploratory testing report for Monefy mobile application
* API test automation framework for Swagger PetStore sample

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

To run tests use the command:

`./gradlew clean test`

To download Allure report use the command:

`./gradlew allureReport`

To generate Allure report use the command:

`./gradlew allureServe`

To open existing Allure report `allure-report/allureReport` please install Allure on your PC and use the command:

`allure open allure-report/allureReport`

For Intellij IDEA, it is required to install the `Lombok` plugin:

https://plugins.jetbrains.com/plugin/6317-lombok

**Approach**

The framework is designed to cover the main functionality of the /store endpoints of PetStore service.

I am using `RestAssured` library to send requests and validate responses. `Lombok` library is used to reduce boilerplate code. `Allure` library is used to generate test reports.`JUnit` to run tests.

I have created `StoreController` to simplify interaction with API and increase readability. I am using DTO design patter to create models for store and use them for serializing/deserializing to/from JSON.

I have added `Allure` steps to improve report readability and easy debugging.