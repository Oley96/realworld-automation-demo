
# demo.realworld.io
#### Project stack :
- **Gradle project**
- **Selenide as Web automation framework**
- **JUnit5 as test runner xUnit framework**
- **Allure as test reporting**
- **JavaOwner for config**


#### Required environment

- Java 11

#### Import project (is optional)
- should be imported as Gradle project with using Gradle wrapper
- should be renamed and filled property files (see resources) 

#### Run tests from cli

commands syntax:
- **local run example (Chrome browser as default and without parallelism)**
```
 ./gradlew clean test
```
- **local run with specific browser and parallelism**
```
 ./gradlew clean -Dthreads=2 -Dlaunch=chrome.local
```
```
 ./gradlew clean -Pthread=2 -Dlaunch=firefox.local
```
- **remote run with specific browser and parallelism**
```
 ./gradlew clean -Pthread=2 -Dlaunch=chrome.remote
```
```
 ./gradlew clean -Pthread=2 -Dlaunch=firefox.local
```
#### Generate Allure report
- **generate report after full test run**
```
 ./gradlew allureReport
```
- **then run Allure web service**
```
 ./gradlew allureServe
```