Feature: Test various Pet Store Swagger API

  @Sanity
  Scenario: User makes a GET request to fetch a list of all available pets
    Given the PetStore API is accessible
    When the user makes a GET request to the endpoint /pet/findByStatus with the query parameter 'status=available'
    And the user saves a random PET ID from the response
    Then the response should adhere to the expected JSON schema

  @Sanity
  Scenario: Update Pet Details
    Given the PetStore API is accessible
    And a random PET ID is available
    When the user makes a PUT request to the endpoint /pet with updated details
    Then the response should be 200 and adhere to the expected JSON schema for updated pets
    And the updated details are saved for future use

  @Sanity
  Scenario: Get details of a pet by ID
    Given a random PET ID is available
    When When the user makes a GET request to the endpoint /pet/{petID}
    Then the response should be 200 and adhere to the expected JSON schema for updated pets
    And the response should contain the correct details for the pet
