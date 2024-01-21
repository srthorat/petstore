package io.swagger.petstore.stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.swagger.petstore.base.BaseTest;
import io.swagger.petstore.data.CommonData;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.Random;
import static io.restassured.RestAssured.given;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.swagger.petstore.utils.Utils.createPetJsonBody;
import static org.slf4j.LoggerFactory.getLogger;

public class PetStoreStepDefinitions extends BaseTest {
    private static final Logger log = getLogger(PetStoreStepDefinitions.class);
    private Response response;
    private String savedPetId;
    private String updatePetPayload;

    @Given("the PetStore API is accessible")
    public void givenThePetStoreAPIIsAccessible() {
        log.info("Step: Validating the accessibility of the Pet Store API by making a GET request to '{}/swagger.json'", baseUrl);
        response = given()
                .spec(requestSpec)
                .when()
                .get("/swagger.json");
        log.info("Step: Received response with status code '{}'", response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @When("^the user makes a GET request to the endpoint (.+) with the query parameter 'status=available'")
    public void whenTheUserMakesGetRequestForAvailablePets(String path) {
        log.info("Step: User makes a GET request to the endpoint" + path + "with the query parameter 'status=available'");
        response = given()
                .spec(requestSpec)
                .queryParam("status", "available")
                .when()
                .get(path);
        log.info("Step: Received response with status code '{}'", response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @When("the user saves a random PET ID from the response")
    public void whenTheUserSavesRandomPetId() {
        log.info("Step: the user saves a random PET ID from the response");
        List<Map<String, Object>> pets = response.jsonPath().getList("");
        int arrayLength = pets.size();
        Random random = new Random();
        int randomIndex = random.nextInt(arrayLength);
        Map<String, Object> randomPet = pets.get(randomIndex);
        String petId = String.valueOf(randomPet.get("id"));
        CommonData.setSavedPetId(petId);
        log.info("Step: Random PET ID '{}' saved successfully.", petId);

    }

    @Then("the response should adhere to the expected JSON schema")
    public void thenTheResponseShouldAdhereToExpectedSchema() {
        log.info("Step: Validating response against the expected JSON schema...");
        String schemaPath = "json-schemas/expected-schema.json";
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));
        log.info("Step: JSON schema validation passed successfully.");
    }

    @Given("a random PET ID is available")
    public void givenARandomPetIdIsAvailable() {
        log.info("Step: Checking if a random PET ID is available for updating...");
        savedPetId = CommonData.getSavedPetId();
        Assert.assertNotNull(savedPetId);
        log.info("Random PET ID for updating: {}", savedPetId);
    }

    @When("^the user makes a PUT request to the endpoint (.+) with updated details")
    public void whenTheUserMakesPutRequestWithUpdatedDetails(String path) {
        long petID = Long.parseLong(savedPetId);
        int randomNumber = new Random().nextInt(9999) + 1;
        String name = "Oskar_" + randomNumber;
        String[] statuses = {"Available", "Sold", "Pending"};
        String randomStatus = statuses[new Random().nextInt(statuses.length)];
        String tagName = "IN_" + randomNumber;
        updatePetPayload = createPetJsonBody(petID, name, randomStatus, randomNumber, tagName);
        // Make PUT request
        response = given()
                .spec(requestSpec)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(updatePetPayload)
                .when()
                .put(path);
        log.info("PUT request to update pet details. PET ID: {}, Response Code: {}", petID, response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("the response should be {int} and adhere to the expected JSON schema for updated pets")
    public void thenTheResponseShouldAdhereToExpectedJsonSchemaForUpdatedPets(int statusCode) {
        log.info("Step: Validating response code and body against the expected JSON schema...");
        Assert.assertEquals(response.getStatusCode(), statusCode);
        String schemaPath = "json-schemas/update-expected-schema.json";
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));
        log.info("Step: JSON schema validation passed successfully.");
    }

    @And("the updated details are saved for future use")
    public void theUpdatedDetailsAreSavedForFutureUse() {
        log.info("Step: Saving the updated details for future use...");
        CommonData.setCreatePetJsonBody(updatePetPayload);
        log.info("Step: Updated details saved successfully.");
    }

    @When("^When the user makes a GET request to the endpoint (.+)")
    public void whenTheUserMakesGetRequestToPetEndpoint(String path) {
        long petID = Long.parseLong(savedPetId);
        log.info("Step: Preparing to make a GET request to retrieve details for PET ID: {}", petID);
        response = given()
                .spec(requestSpec)
                .when()
                .get(path,petID);
        log.info("Step: GET request completed. PET ID: {}, Response Code: {}", petID, response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @And("the response should contain the correct details for the pet")
    public void andTheResponseShouldContainCorrectDetails() {
        log.info("Step: Validating details in the response for PET ID: {}", savedPetId);
        String updatePetPayload = CommonData.getCreatePetJsonBody();
        JSONObject updatePayload = new JSONObject(updatePetPayload);
        JSONObject responsePayload = new JSONObject(response.body().asString());

        // Compare name
        String expectedName = updatePayload.getString("name").trim();;
        String actualName = responsePayload.getString("name").trim();;
        log.info("Expected Name: {}, Actual Name: {}", expectedName, actualName);
        Assert.assertEquals(expectedName, actualName);

        // Compare status
        String expectedStatus = updatePayload.getString("status");
        String actualStatus = responsePayload.getString("status");
        log.info("Expected Status: {}, Actual Status: {}", expectedStatus, actualStatus);
        Assert.assertEquals(expectedStatus, actualStatus);

        // Compare tags (assuming only one tag is used)
        JSONObject expectedTag = updatePayload.getJSONArray("tags").getJSONObject(0);
        JSONObject actualTag = responsePayload.getJSONArray("tags").getJSONObject(0);

        // Compare tag id
        int expectedTagId = expectedTag.getInt("id");
        int actualTagId = actualTag.getInt("id");
        log.info("Expected Tag Id: {}, Actual Tag Id: {}", expectedTagId, actualTagId);
        Assert.assertEquals(String.valueOf(expectedTagId), String.valueOf(actualTagId));

        // Compare tag name
        String expectedTagName = expectedTag.getString("name");
        String actualTagName = actualTag.getString("name");
        log.info("Expected Tag Name: {}, Actual Tag Name: {}", expectedTagName, actualTagName);
        Assert.assertEquals(expectedTagName, actualTagName);

        log.info("Step: Details validation passed successfully.");
    }

}
