# API Automation Framework to test [Swagger Pet Store API](https://petstore.swagger.io/).
This framework is designed to automate API testing for the PetStore application. It integrates popular tools and libraries like **RestAssured**, **TestNG**, **Cucumber**, **Allure Reports**, **SLF4J Logger**, and **CI/CD - Github Actions**  to provide a robust and maintainable testing solution.
## Framework Structure
* The framework follows a standard Maven project structure:
  1. `src/test/java/io/swagger/petstore/base`: Contains BaseTest.java, the base class for test setup. 
  2. `src/test/java/io/swagger/petstore/data`: Includes CommonData.java for managing common test data. 
  3. `src/test/java/io/swagger/petstore/stepdefinitions`: Holds Cucumber step definitions, including Hooks.java for setup and teardown. 
  4. `src/test/java/io/swagger/petstore/utils`: Contains utility methods in Utils.java. 
  5. `src/test/resources`: Includes Cucumber feature files, JSON schemas, and configuration properties.
  
## Tech Stack
1. [Java 8](https://www.oracle.com/java/technologies/java8.html)
2. [Rest Assured](https://rest-assured.io/)
3. [TestNG](https://testng.org/)
4. [Cucumber](https://cucumber.io/)
5. [Allure Reports](https://allurereport.org/)
6. [SLF4J Logger](https://www.slf4j.org/)
7. [CI/CD - Github Actions](https://docs.github.com/en/actions)
8. [Git](https://git-scm.com/)

## Getting Started Instructions
### Run Locally and view Allure report
#### Step 1: Clone to local
* Run `git clone https://github.com/srthorat/petstore.git` 

#### Step 2: Set up Dependencies 
* Assuming that local setups for Maven and Java are already in place
* If not refer [Java 8 Setup](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html), [Maven Setup](https://www.baeldung.com/install-maven-on-windows-linux-mac)
* Goto to Project repo `cd <BasePath>/petstore`
* Run `mvn clean install`

#### Step 3: Run Tests
* Run `mvn clean test`
* To execute specific tags from command line we can use `mvn test -Dcucumber.filter.tags="@Sanity"`.
* We support two tags - `@Sanity` `@All_E2E`

#### Step 4: Generate Allure Report
* Run `mvn allure:serve` or `mvn allure:report`
* Report will be generated into temp folder. Web server with results will start.

### Run Test using Github Action CI/CD and view Allure report
1. Go to Actions tab - [Actions](https://github.com/srthorat/petstore/actions)
2. From the left, below All workflows select the workflow - [Java CI with Maven](https://github.com/srthorat/petstore/actions/workflows/petstore-ci.yml)
3. A `Run workflow` dropdown will appear on the right, Select it, then choose `branch - main`, and click `Run Workflow`. 
4. Refresh Page 
5. You can now see - `Java CI with Maven` job is running, While completes, open Java CI with Maven to monitor the test 
running status and view logs. 
6. Once the `Java CI with Maven` job complete, the `pages build and deployment with artifacts-next` job will start 
running automatically, wait for it to complete. 
7. Once the `pages build and deployment with artifacts-next` gets completes, double-click on job name. 
8. You can now see job details, You can see stages like `build ===> report-build-status` and `build ===> deploy`
9. On the deploy stage, find the link - https://srthorat.github.io/petstore. Open this link to view the Allure report 
summary for the last run.

## Adding new Test cases
### Step 1: Create a New Feature File
1. Navigate to the src/test/resources/features directory.
2. Create a new file named NewTestCase.feature.
3. Add meaningful BDD steps for the new test case scenario.

   ```Example NewTestCase.feature:
     Feature: New Test Case 
       Scenario: Description of the new scenario 
       Given some initial conditions
       When an action is performed
       Then the expected outcome is verified```
   
### Step 2: Implement Step Definitions
1. Open `PetStoreStepDefinitions.java` or create new file located in `src/test/java/com/example/petstore/stepdefinitions.`
2. Add step definitions for the new steps in the NewTestCase.feature file.

### Step 3: Run the Test
1. Run your test suite to execute the new test case.
2. Verify that the test case runs successfully and produces the expected outcomes.

## Troubleshooting Guide
### 1. General Issues
* Issue: Unable to run tests successfully.
* Solution:
  1. Ensure that the necessary dependencies are installed.
  2. Verify that the API is accessible.
  3. Check the correctness of test data and configurations.
### 2. Dependency Issues
* Issue: Maven build fails due to dependency issues.
* Solution:
  1. Check your `pom.xml `file for correct dependencies and versions.
  2. Run `mvn clean install` to download and install dependencies.
### 3. API Connection Issues
* Issue: Tests fail due to inability to connect to the API. 
* Solution:
  1. Check the API base URL in the `BaseTest.java` class.
  2. Verify network connectivity.
  3. Ensure the API is running and accessible.
### 4. Failed API Requests
* Issue: Tests fail due to API request issues.
* Solution:
  1. Inspect the request details in the test logs. 
  2. Check the request headers, body, and parameters. 
  3. Ensure that the request format and data are correct.
### 5. JSON Schema Validation Failures
* Issue: JSON schema validation fails. 
* Solution:
  1. Verify that the expected JSON schema file exists. 
  2. Check for any discrepancies between the response and the schema. 
  3. Update the schema file if necessary.
### 6. Step Definition Ambiguities
* Issue: Cucumber reports duplicate step definitions. 
* Solution:
  1. Ensure each step definition has a unique signature. 
  2. Check for duplicate step definitions with similar patterns. 
  3. Adjust step definitions to avoid conflicts.
### 7. Updating Test Data
* Issue: Need to update test data for new scenarios. 
* Solution:
  1. Update the feature file with new scenarios and steps.
  2. Implement corresponding step definitions in PetStoreStepDefinitions.java. 
  3. Ensure any necessary data (e.g., API endpoints, expected responses) is updated.
