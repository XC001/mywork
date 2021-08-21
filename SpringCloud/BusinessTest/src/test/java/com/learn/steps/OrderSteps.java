package com.learn.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class OrderSteps {
    @Given("get Order by userid")
    public void get_order_by_userid() {

    }

    @Then("return Order success")
    public void return_Order_success() throws Exception {
        throw new Exception("123");
    }
}
