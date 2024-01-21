# API Automation Framework to test [Swagger Pet Store API](https://petstore.swagger.io/).
Rest Assured Automation Framework with **Java 8**, **TestNG** and **Cucumber** integration, along with reporting tool - **Allure Reports** and **SLF4J Logger**, **CI/CD - Github Actions** and relevant dependencies.

## Tech Stack
1. [Java 8](https://www.oracle.com/java/technologies/java8.html)
2. [Rest Assured](https://rest-assured.io/)
3. [TestNG](https://testng.org/)
4. [Cucumber](https://cucumber.io/)
5. [Allure Reports](https://allurereport.org/)
6. [SLF4J Logger](https://www.slf4j.org/)
7. [CI/CD - Github Actions](https://docs.github.com/en/actions)

## Getting Started Instructions
### Run Locally and view Allure report
#### Clone to local
* Run `git clone https://github.com/srthorat/petstore.git` 

#### Set up Dependencies 
* Assuming that local setups for Maven and Java are already in place
* If not refer [Java 8 Setup](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html), [Maven Setup](https://www.baeldung.com/install-maven-on-windows-linux-mac)
* Goto to Project repo `cd <BasePath>/petstore`
* Run `mvn clean install`

#### Run Tests
* Run `mvn clean test`

#### Generate Allure Report
* Run `mvn allure:serve` or `mvn allure:report`
* Report will be generated into temp folder. Web server with results will start.

### Run Test using Github Action CI/CD and view Allure report
* Go to Actions tab - [Actions](https://github.com/srthorat/petstore/actions)
* From the left, below All workflows select the workflow - [Java CI with Maven](https://github.com/srthorat/petstore/actions/workflows/petstore-ci.yml)
* A `Run workflow` dropdown will appear on the right, Select it, then choose `branch - main`, and click `Run Workflow`.
* Refresh Page
* You can now see - `Java CI with Maven` job is running, While completes, open Java CI with Maven to monitor the test 
running status and view logs.
* Once the `Java CI with Maven` job complete, the `pages build and deployment with artifacts-next` job will start 
running automatically, wait for it to complete.
* Once the `pages build and deployment with artifacts-next` gets completes, double-click on job name.
* You can now see job details, You can see stages like `build ===> report-build-status` and `build ===> deploy`
* On the deploy stage, find the link - https://srthorat.github.io/petstore. Open this link to view the Allure report 
summary for the last run.

## Adding new Test cases
### Create a New Feature File
1. Navigate to the src/test/resources/features directory.
2. Create a new file named NewTestCase.feature.
   `Example NewTestCase.feature:
     Feature: New Test Case 
       Scenario: Description of the new scenario 
       Given some initial conditions
       When an action is performed
       Then the expected outcome is verified`