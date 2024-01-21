# API Automation Framework to test [Swagger Pet Store API](https://petstore.swagger.io/).
Rest Assured Automation Framework with **Java 8**, **TestNG** and **Cucumber** integration, along with reporting tool - **Allure Reports** and **SLF4J Logger**, **CI/CD - Github Actions** and relevant dependencies.

## Tech Stack
1. Java 8
2. Rest Assured
3. TestNG
4. Cucumber
5. Allure Reports
6. SLF4J Logger
7. CI/CD - Github Actions

## Getting Started Instructions
### Clone to local
* Run `git clone https://github.com/srthorat/petstore.git` 

### Set up Dependencies 
* Assuming that local setups for Maven and Java are already in place
* If not refer [Java 8 Setup](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html), [Maven Setup](https://www.baeldung.com/install-maven-on-windows-linux-mac)
* Run `mvn clean install`

### Run Tests
* Run `mvn clean test`

### See Allure Report
* Assuming that local setup for Allure report is in place - If not refer [Allure Report installation](https://allurereport.org/docs/gettingstarted-installation/) 
* Run `allure serve`
