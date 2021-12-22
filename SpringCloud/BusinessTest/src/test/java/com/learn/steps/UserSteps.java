package com.learn.steps;

import com.learn.ConsumerServerApplication;
import com.learn.entity.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

//@RunWith(SpringJUnit4ClassRunner.class)
@CucumberContextConfiguration
@SpringBootTest(classes = {ConsumerServerApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserSteps {
    @LocalServerPort
    private Integer port;

    RestTemplate restTemplate = new RestTemplate();

    User user = null;

    @Test
    public void test(){
        System.out.println("======finished");
    }

    @Given("user is login")
    public void init(){

    }

    @When("get user by {int}")
    public void requestUser(int userId){
        user = restTemplate.getForObject("http://localhost:"+port+"/user/"+userId, User.class);
    }

    @Then("return success")
    public void checkSuccess(){
        Assert.assertEquals(String.valueOf(1), String.valueOf(user.getId()));
    }
}
