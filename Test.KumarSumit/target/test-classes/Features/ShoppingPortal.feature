Feature: Test the Shopping portal

  Scenario: The user should be able to update the personal information
    Given user is already logged into the user account
    When user clicks on the Personal Information and saves the changes
    Then user should be able to see the Updated personal information

  Scenario: The user should be able to purchase and verify T Shirt in Orders
    Given user is logged into the user account
    When user clicks on the T shirt link & completes the purchase steps
    Then user should be able to see the T shirt in Orders
