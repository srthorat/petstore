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
### Run Locally and view Allure report
#### Clone to local
* Run `git clone https://github.com/srthorat/petstore.git` 

#### Set up Dependencies 
* Assuming that local setups for Maven and Java are already in place
* If not refer [Java 8 Setup](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html), [Maven Setup](https://www.baeldung.com/install-maven-on-windows-linux-mac)
* Run `mvn clean install`

#### Run Tests
* Run `mvn clean test`

#### See Allure Report
* Assuming that local setup for Allure report is in place - If not refer [Allure Report installation](https://allurereport.org/docs/gettingstarted-installation/) 
* Run `allure serve`

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

