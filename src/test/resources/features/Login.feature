@login
Feature: Sauce demo login

  @login1
  Scenario: Valid login
    When User enters valid username
    And User enters valid password
    And Click on login button
    Then I validate that user is logged in

  @login2
  Scenario: Empty password
    When User enters valid username
    And User leaves password empty
    And Click on login button
    Then I validate that "Epic sadface: Password is required" message is displayed

  @login3
  Scenario: Invalid login
    When User enters invalid username as "random_username"
    And User enters valid password as "random_password"
    And Click on login button
    Then I validate that "Epic sadface: Username and password do not match any user in this service" message is displayed