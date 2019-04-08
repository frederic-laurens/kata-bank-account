Feature: Account history

US 3:
In order to check my operations
As a bank client
I want to see the history (operation, date, amount, balance)  of my operations

Scenario: History of 1 deposit then 1 withdrawal today
Given I am a bank client
And my account balance is at €200.00
When I make a deposit of €100.00 to my account
And I withdraw €55.50 from my account
And I ask to see the history (operation, date, amount, balance) of my operations
Then I get a listing of 1 deposit of €100.00 then 1 withdrawal €55.50 of today
And the new balance of my account is €244.50