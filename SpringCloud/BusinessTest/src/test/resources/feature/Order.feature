@trade
Feature: Order
  Background: get Order info

    @trade @user
    Scenario: get Order info
      Given user is login
      When get Order by userid
      Then return Order success

    Scenario: add order info
      Given user is login
      When add order by userid
      Then return add order success