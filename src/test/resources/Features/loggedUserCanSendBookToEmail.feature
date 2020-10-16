Feature: Logged in User Can Send a Book to Email

  Scenario: Successfully Send a Book to Email
    Given I am on the http://flibusta.is/ Home Page
    When I fill Login field with "maliauka" and fill Password field with "wPtQd4Ka.nWZ3-6"
    Then I should see "maliuka" on the Website
    When I type "Преступление и наказание" into Search Field
    Then I should see Search Results
    When I navigate to Book Page
    Then I should be able to Send A Book To Email