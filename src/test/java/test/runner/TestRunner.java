package test.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

@CucumberOptions(
        features= {"classpath:features"},
        glue="io.swagger.petstore.stepdefinitions",
        tags = "@Sanity"

)

public class TestRunner extends AbstractTestNGCucumberTests {
    private static final Logger log = getLogger(TestRunner.class);
}