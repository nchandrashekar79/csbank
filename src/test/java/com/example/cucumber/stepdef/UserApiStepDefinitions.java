package com.example.cucumber.stepdef;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserApiStepDefinitions{

    private ResponseEntity<String> response;

    @Autowired
    private RestTemplate restTemplate;

    @Given("the REST API is running")
    public void theRestApiIsRunning() {
    }

    @When("I send a GET request to {string}")
    public void iSendAGetRequestTo(String endpoint) {
        response = restTemplate.getForEntity("http://localhost:8080" + endpoint, String.class);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCodeValue());
    }

    @Then("the response should contain a list of users")
    public void theResponseShouldContainAListOfUsers() {
        assertNotNull(response.getBody());
        // Additional assertions can be added to validate the response body
    }
}