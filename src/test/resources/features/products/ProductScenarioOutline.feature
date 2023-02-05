@regression
Feature:

  Scenario Outline: Validation of New Product Creation

    Given User navigates to product homepage and click order Button
    When User enters the product information '<Product>' and '<Quantity>'
    And User enters the address information '<name>','<street>','<city>' ,'<zip>'
    And User enters the payment information '<cardType>' ,'<cardnumber>','<expireDate>' and click process button
    Then User validates the message '<message>'
   # And User validate new order
    And User validates all the information '<name>','<Product>','<Quantity>','<street>','<city>','<zip>','<cardType>','<cardnumber>','<expireDate>'


    Examples:
      | Product     | Quantity | name  | street         | city    | zip   | cardType | cardnumber | expireDate | message                                |
      | MyMoney     | 4        | Ahmet | Mount Prospect | Chicago | 60123 | Visa     | 1265889    | 12/21      | New order has been successfully added. |
      | FamilyAlbum | 4        | Ahmet | Mount Prospect | Chicago | 60123 | Visa     | 1265889    | 12/21      | New order has been successfully added. |
      | ScreenSaver | 4        | Ahmet | Mount Prospect | Chicago | 60123 | Visa     | 1265889    | 12/21      | New order has been successfully added. |

