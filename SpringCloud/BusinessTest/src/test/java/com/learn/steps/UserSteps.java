package com.learn.steps;

import com.learn.entity.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.web.client.RestTemplate;

public class UserSteps {

    RestTemplate restTemplate = new RestTemplate();

    User user = null;

    @Given("user is login")
    public void init(){

    }

    @When("get user by {int}")
    public void requestUser(int userId){
        user = restTemplate.getForObject("http://localhost:8082/user/"+userId, User.class);
    }

    @Then("return success")
    public void checkSuccess(){
        Assert.assertEquals(String.valueOf(1), String.valueOf(user.getId()));
    }
}
