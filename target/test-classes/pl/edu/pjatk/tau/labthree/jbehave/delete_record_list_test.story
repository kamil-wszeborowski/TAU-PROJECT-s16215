Meta:

Narrative:
As a user
I want to have method to delete list of invoice
Which help me to delete list of invoice in the database

Scenario: Delete record list
Given Database with invoices
When set arguments to <listOfNumber> of record to delete
Then delete list method should return list of invoice <invoicesThatShouldBeRemoved> that was deleted

Examples:
      | listOfNumber                           | invoicesThatShouldBeRemoved             |
      | 10000/FVT/19,10001/FVT/19,10002/FVT/19 | 10000/FVT/19,10001/FVT/19,10002/FVT/19, |
      | 10005/FVT/19                           | No invoice number was found             |
      | 10000/FVT/19                           | 10000/FVT/19,                           |
