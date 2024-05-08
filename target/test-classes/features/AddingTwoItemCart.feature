Feature: Adding two Item in cart

  Scenario Outline: Adding cart with two item
    When Open Amazon.com
    When User Search for "<item1>"
    And Select <numberOfItem> item and add into cart
    When User Search for "<item2>"
    And Select <numberOfItem> item and add into cart
    And Open cart from Left Up
    Then Verify that the price is identical to the product page
    Then Verify that the sub total is identical to the product page

    Examples: 
      | item1      | item2    | numberOfItem |
      | Headphones | Keyboard |            1 |
