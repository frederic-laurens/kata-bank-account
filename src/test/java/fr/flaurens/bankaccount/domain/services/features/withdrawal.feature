Feature: Withdrawal

Scenario: I want to withdraw €100 when my balance is above €100
Given I am a bank client
And my account balance is at €200.00
When I withdraw €100.00 from my account
Then the new balance of my account is €100.00
