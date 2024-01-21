Feature: Test various Pet Store Swagger API

  @Sanity
  Scenario: User makes a GET request to fetch a list of all available pets
    Given the PetStore API is accessible
    When the user makes a GET request to the endpoint /pet/findByStatus with the query parameter 'status=available'
    And the user saves a random PET ID from the response
    Then the response should adhere to the expected JSON schema

  @Sanity
  Scenario: User makes a PUT request to Update Pet Details using Random PET ID Saved in first test.
    Given the PetStore API is accessible
    And a random PET ID is available
    When the user makes a PUT request to the endpoint /pet with updated details
    Then the response should be 200 and adhere to the expected JSON schema for updated pets
    And the updated details are saved for future use

  @Sanity
  Scenario: User makes a GET request to fetch PET Details using Random PET ID Saved in first test, compares PET Details
    received with PET Details updated in last test.
    Given a random PET ID is available
    When When the user makes a GET request to the endpoint /pet/{petID}
    Then the response should be 200 and adhere to the expected JSON schema for updated pets
    And the response should contain the correct details for the pet
