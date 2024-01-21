package test.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features= {"classpath:features"},
        glue="io.swagger.petstore.stepdefinitions",
        tags = "@All_E2E"

)

public class TestRunner extends AbstractTestNGCucumberTests { }