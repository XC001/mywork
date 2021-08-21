Feature: User
  Background: get user info

    Scenario Outline: get user info
      Given user is login
      When get user by <userId>
      Then return success

      Examples:
      |userId|
      |1     |
      |2     |