#Author: Victor Volodin, 2021
@checkout
Feature: Title of your feature

  Background:
    Given User is successfully logged in

  Scenario Outline: Order checkout
    When I click on item "<Item>"
    And I click on add to card button
    And I click on shopping cart button
    And I click on checkout button
    And I enter the order information as "<FirstName>", "<LastName>">, "<ZipCode>"
    And I click on continue
    Then I verify that the item name matches "<Item>"

    Examples:
      | Item                     | FirstName           | LastName           | ZipCode |
      | Sauce Labs Backpack      | TestFirstNameFirst  | TestLastnameFirst  | 90210   |
      | Sauce Labs Fleece Jacket | TestFirstNameSecond | TestLastnameSecond | 92011   |
      | Sauce Labs Onesie        | TestFirstNameThird  | TestLastnameThird  | 95821   |