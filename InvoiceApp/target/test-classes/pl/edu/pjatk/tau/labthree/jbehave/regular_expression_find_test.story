Meta:

Narrative:
As a user
I want to have method
Which help me find invoice number in the database

Scenario: Regular expression find invoice
Given List of invoices
When set the invoice number to <number> as the searched phrase
Then find method should return <result>
Examples:
      | number       | result                            |
      | 10000/FVT/19 | 10000/FVT/19                      |
      | 10001/FVT/19 | 10001/FVT/19                      |
      | 10002/FVT/19 | No invoice with this number found |