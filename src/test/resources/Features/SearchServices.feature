Feature: NSW Search Services

  Scenario: I want to using feature search on NSW Website
    Given I Open browser
    And Open website NSW
    When I search "Apply for a number plate"
    Then Click on Find locations button
    And I search suburb "Sydney 2000"
    And I close browser
