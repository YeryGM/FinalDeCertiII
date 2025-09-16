Feature: Home page

  Background: User login into Sauce demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

    Scenario Outline: Verify that all products are displayed in home page
      When The home page should be displayed
      Then The product "<product>" should be displayed
      Examples:
        | product                 |
        | Sauce Labs Backpack     |
        | Sauce Labs Bike Light   |
        | Sauce Labs Bolt T-Shirt |




