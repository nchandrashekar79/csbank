Feature: User API

  Scenario: Retrieve all users
    Given the REST API is running
    When I send a GET request to "/api/users"
    Then the response status code should be 200
    And the response should contain a list of users