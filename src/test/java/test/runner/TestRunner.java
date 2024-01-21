package test.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features= {"classpath:features"},
        glue="io.swagger.petstore.stepdefinitions",
        tags = "@Sanity"

)

public class TestRunner extends AbstractTestNGCucumberTests { }