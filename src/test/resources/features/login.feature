
Feature: Login functionality

  Scenario Outline: Login with different types of users
    Given I open the login page
    When I login with "<usernameKey>" data from Excel
    Then I should see "<expectedResult>"

    Examples:
      | usernameKey | expectedResult   |
      | validUser   | Dashboard Page   |
      | invalidUser | Login Failed     |
