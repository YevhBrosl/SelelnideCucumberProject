Feature: Login

  @loginPositive
  Scenario: Successful login
    Given User is on HomePage
    When User clicks on User icon
    Then User verifies Login form
    When User enters valid credentials
    And User clicks on Anmelden button
    Then User verifies user name status
    When User clicks on User icon
    Then User verifies user name

  @invalidEmail
  Scenario Outline: Login with invalid email and valid password
    Given User is on HomePage
    When User clicks on User icon
    Then User verifies Login form
    When User enters invalid email and valid password
      | email   | password   |
      | <email> | <password> |
    And User clicks on Anmelden button
    Then User verifies Error message is displayed
    Examples:
      | email           | password |
      | wooster@.com  | Qwerty1! |
      | wooster.gm.com  | Qwerty1! |
      | wooster@gm.co.m | Qwerty1! |
      | wooster@gm.1    | Qwerty1! |