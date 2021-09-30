Feature: Git Hub sign in


  Scenario Outline: error message is displayed upon registration with invalid email pattern

    Given Github '<homePage>' is opened
    And user click on 'Sign up' button
    When user enters '<email>' into email field
    Then error message below email field should be displayed


    Examples:
      | homePage                | email   |
      | https://www.github.com/ | invalid123 |


#  Scenario: message under password field indicates a completeness of password requirements
#
#    Given Github home page is opened
#
#    When user enters “AAA” into password field
#    Then “at least 15 characters” message should be marked red
#
#    And “a lowercase letter” message should be marked red
#
#    When user enters “AAAaaa” into password field
#    Then “at least 15 characters” message should be marked red
#
#    And “a lowercase letter” message should be marked green
#
#
#
#  Scenario: error message is displayed upon registration with already existent username
#
#    Given Github home page is opened
#
#    And at least one username is already registered in application
#
#    When user enters already existent username into username field
#    Then red error sign inside username field should be displayed
#    And error message below username field should be displayed
#
#    And suggested usernames in error message contains the username entered