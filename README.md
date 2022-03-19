# Test automation demo for https://demo.realworld.io

## Project stack
- **Gradle project**
- **Selenide as Web automation framework**
- **Rest Assured as API automation framework**
- **JUnit5 as test runner xUnit framework**
- **Allure as test reporting**
- **JavaOwner for config**
- **Faker for generating random sequences**


#### Required environment

- Java 11

#### Import project (is optional)
- should be imported as Gradle project with using Gradle wrapper
- should be renamed and filled property files (see resources) 

## Run tests from cli
commands syntax:
- **local run (UI + API) example (Chrome browser as default and without parallelism)**
```
 ./gradlew clean test
```
- **remote run (UI + API) example with specific browser**
```
 ./gradlew clean -Dlaunch=chrome.remote test
```
- **local run of UI tests with specific browser and parallelism**
```
 ./gradlew clean -Dthreads=2 -Dlaunch=chrome.local ui
```
```
 ./gradlew clean -Pthread=2 -Dlaunch=firefox.local ui
```
- **remote run of UI test with specific browser and parallelism**
```
 ./gradlew clean -Pthread=2 -Dlaunch=chrome.remote ui
```
```
 ./gradlew clean -Pthread=2 -Dlaunch=firefox.remote ui
```
- **run of API test**
```
 ./gradlew clean api
```

## Generate Allure report
- **generate report after full test run**
```
 ./gradlew allureReport
```
- **then run Allure web service**
```
 ./gradlew allureServe
```