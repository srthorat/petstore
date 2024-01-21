package io.swagger.petstore.base;
import static org.slf4j.LoggerFactory.getLogger;
import org.slf4j.Logger;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected static RequestSpecification requestSpec;
    private static final Logger log = getLogger(BaseTest.class);
    public  static String baseUrl;

    @BeforeSuite
    public void setUp() {
        try {
            // Set the base URL
            baseUrl = "https://petstore.swagger.io/v2";
            log.info("Base Rest API URL initialized to: " + baseUrl);

            // Set up REST-Assured
            requestSpec = RestAssured.given().baseUri(baseUrl);
        } catch (Exception e) {
            log.error("Error during test setup: " + e.getMessage());
        }
    }

    @AfterSuite
    public void tearDown() {
        // teardown
        log.info("Teardown activities completed.");
    }
}