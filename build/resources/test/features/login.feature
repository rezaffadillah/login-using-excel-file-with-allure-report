
Feature: Login functionality

  Scenario Outline: Login with different types of users
    Given I open the login page
    When I login with "<usernameKey>" data from Excel
    Then I should see "<expectedResult>"

    Examples:
      | usernameKey | expectedResult                                                             |
      | validUser   | Swag Labs                                                                  |
      | invalidUser | Epic sadface: Username and password do not match any user in this service  |
