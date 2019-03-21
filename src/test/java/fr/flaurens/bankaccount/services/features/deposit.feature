Feature: Deposit

Scenario: I want to make a deposit of €100 when my balance is positive
Given I am a bank client
And my account balance is at €100.00
When I make a deposit of €100.00 to my account
Then the new balance of my account is €200.00
