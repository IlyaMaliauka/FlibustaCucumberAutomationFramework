Feature: User can login Flibusta.is

  Scenario: Successfully Login to Flibusta
    Given I am on the http://flibusta.is/ Home Page
    When I fill Login field with "maliauka" and fill Password field with "wPtQd4Ka.nWZ3-6"
    Then I should see "maliuka" on the Website