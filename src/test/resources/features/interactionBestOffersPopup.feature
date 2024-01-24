Feature: interaction with best offers popup

  Scenario: I confirm interest in the offers

    Given I am the home of falabella
    When The best offers popup appears and I confirm that I am interested
    Then A confirmation popup should appear
    And Close the popup