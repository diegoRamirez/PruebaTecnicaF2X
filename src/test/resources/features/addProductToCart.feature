Feature: shopping

  Scenario: add product to cart

    Given I am located at Falabella's home
    When I choose a product from the search engine
    And I add the product to the shopping cart
    Then the product must appear in the shopping bag
