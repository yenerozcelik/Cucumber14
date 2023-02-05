@regression
Feature:Validation of product with table

  Scenario:Validation of New Product Creation

    Given User navigates to product homepage and click order Button
    When User enters the product information Product and Quantity
    |product|MyMoney|
    |quantity|4     |
    And User enters the address information name,street,city ,zip
    |name|Ahmet|
    |street|Mount Prospect|
    |city  |Chicago       |
    |zip   |60133         |
    And User enters the payment information cardType ,cardnumber,expireDate and click process button
    |cardType|Visa|
    |cardnumber|554566|
    |expireDate|12/23 |
    Then User validates the message message
    |New order has been successfully added.|

