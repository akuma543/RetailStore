                         #Retails store discount##

#Assumtion
I am assuming two diferent kinds of discount 
a.Percentage based discount for deferent type of users.
b.Discount on final bill amount will be applicable for all  which will be for every $100.


There are following classes are used in app

1.UserFactory (This factory class to create diferent type of users for like customer ,Employee ,affliated etc..)
2.Product(This class use for product with other details like productId ,Priceetc..)
3.ProductRepository(This class used to hold the Product.)
3.BillingLineItem and LineItems(This class used for input payload for billing ).
4.Billing(This class is used for calculate the bill amount with discount and without discount)

#Test cases


I have created 7 test case for all different scenario.
BillingStoreTest (this class contains all testcases with hard code values).

Note: I have included the grocery item also so please  keep in mind the discounted value becouse no discount applied on grocery items. 
I have attached UML class diagram.
I have also attached codeCovrage report.


For run code 

get the code from git repository.

import the code in any IDE.

then run the test cases with code coverage.
