@login
Feature: test #1, login popup

  Scenario: login to SEMrush

    Given open semrush home page
    When I press button Log in
    And type to email input "d.dfgddf@bk.ru"
    And type to pass input "123456"
    And press button Login in login popup
    Then authorization is completed