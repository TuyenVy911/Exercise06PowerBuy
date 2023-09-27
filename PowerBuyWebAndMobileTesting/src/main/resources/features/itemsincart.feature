Feature: Order
  Order many items on ecommerce website

  Scenario: Add many items to cart
    Given I on the power buy home page
    And I change language of the page to English
    When I enter <inputValue> into search textbox
      | inputValue |
      |     TV     |
    And I filter all item to 45 to 54 inches
    And I choose first item to add to cart
    And I change filter item to 56 to 65 inches
    And I choose second item to add to cart
    And I navigate to cart page
    Then I should be to show list of item contain two items were just picked up