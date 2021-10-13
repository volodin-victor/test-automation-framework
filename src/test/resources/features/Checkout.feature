#Author: Victor Volodin, 2021
@checkout
Feature: Checkout

  Background:
    Given User is actually successfully logged in

  Scenario Outline: Order checkout
    When I click on the item with name "<Item>"
    And I click on the add to card button
    And I click on the shopping cart button
    And I click on the checkout button
    And I enter the the order information as "<FirstName>", "<LastName>">, "<ZipCode>"
    And I click on the continue
    Then I verify the item name matches that of "<Item>"

    Examples:
      | Item                    | FirstName           | LastName           | ZipCode |
      | Sauce Labs Backpack     | TestFirstNameFirst  | TestLastnameFirst  | 90210   |
      | Sauce Labs Bolt T-Shirt | TestFirstNameSecond | TestLastnameSecond | 92011   |
      | Sauce Labs Onesie       | TestFirstNameThird  | TestLastnameThird  | 95821   |