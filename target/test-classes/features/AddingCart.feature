Feature: Adding cart

  Scenario Outline: Adding cart with one item
    When Open Amazon.com
    When User Search for "<item>"
    And Select <numberOfItem> item and add into cart
    And Open cart from Left Up
    Then Verify that the price is identical to the product page
    Then Verify that the sub total is identical to the product page

    Examples: 
      | item    | numberOfItem |
      | Monitor |            1 |
      | Laptop  |            2 |
