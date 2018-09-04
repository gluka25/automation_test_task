@createNewobjects
Feature: test #3, projects

  Scenario: create new project

    Given I enter domain "domain.com" in domain field
    When I click create button on dashboard page
    Then project should be created
    Then project should be deleted