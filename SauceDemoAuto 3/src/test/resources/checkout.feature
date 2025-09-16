Feature: Checkout feature

  Background: User should be logged
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

  Scenario: User can checkout a purchase
    Given The home page should be displayed
    And I add the "Sauce Labs Backpack" to the cart
    And I click on the cart icon
    When I click on the checkout button
    And I fill the checkout information with
      | Jorge | Perez | 12345 |
    And I click on the continue button
    And I click on the finish button
    Then A message that says "Thank you for your order!" should be displayed

  Scenario Outline: Validation of required fields in checkout
    Given The home page should be displayed
    And I add the "Sauce Labs Backpack" to the cart
    And I click on the cart icon
    And I click on the checkout button
    Given I leave the "<field>" field empty
    And I click on the continue button
    Then I should see the error message "<error_message>"

    Examples:
      | field        | error_message                 |
      | First Name   | Error: First Name is required |
      | Last Name    | Error: Last Name is required  |
      | Zip Code     | Error: Postal Code is required|

  Scenario: Checkout with multiple products and verification of totals
    Given The home page should be displayed
    And I add the "Sauce Labs Backpack" to the cart
    And I add the "Sauce Labs Bike Light" to the cart
    And I click on the cart icon
    And I click on the checkout button
    And I fill the checkout information with
      | Test | User | 12345 |
    And I click on the continue button
    Then I should see 2 products in the summary
    And I should see the subtotal calculated correctly
    And I should see the tax calculated correctly
    And I should see the total calculated correctly
    When I click on the finish button
    Then A message that says "Thank you for your order!" should be displayed

  Scenario: Cancellation from information page
    Given The home page should be displayed
    And I add the "Sauce Labs Backpack" to the cart
    And I click on the cart icon
    And I click on the checkout button
    When I click on cancel button
    Then I should be on the cart page

  Scenario: Cancellation from overview page
    Given The home page should be displayed
    And I add the "Sauce Labs Backpack" to the cart
    And I click on the cart icon
    And I click on the checkout button
    And I fill the checkout information with
      | Test | User | 12345 |
    And I click on the continue button
    When I click on cancel button from overview
    Then I should be on the products page




