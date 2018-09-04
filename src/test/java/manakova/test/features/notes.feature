@createNewobjects
Feature: test #2, notes

  Scenario: create new note

    Given open Notes page
    When I click button Add note
    And fill in Title field with value "meet&greet"
    #And choose date "05.09.2018"
    #And select advanced settings: show in "Russia" and URL "hello.com"
    #And fill in description by "test note"
    And save note
    Then note should be saved
    And delete new note