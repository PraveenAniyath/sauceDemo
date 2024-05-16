Feature: Test sauce Demo

  @SauceLabE2E
  Scenario Outline: Verify if customer is able to add product to cart and checkout

    Given launch the sauce demo url for Test "<Testname>"
    And verify if login page is displayed successfully
    When Login in to the application for user "<User>"
    And verify if products page is displayed successfully
    And add product to the cart
      | Sauce Labs Backpack      |
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Fleece Jacket |
    And Click cart icon
    Then verify if cart page is displayed successfully
    Then verify if cart is loaded with added items
      | Sauce Labs Backpack      |
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Fleece Jacket |
    And remove products from the cart
      | Sauce Labs Backpack |
    And click on continue shopping button
    And verify if products page is displayed successfully
    And add product to the cart
      | Sauce Labs Onesie |
    And Click cart icon
    Then verify if cart page is displayed successfully
    Then verify if cart is loaded with added items
      | Sauce Labs Onesie        |
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Fleece Jacket |
    And click on checkout button
    Then verify if checkout page is displayed successfully
    And user inputs firstname as "<Firstname>" , lastname as "<Lastname>" and zipcode as "<zipcode>"
    Then verify if checkout overview page is displayed successfully
    And click on Finish button

    Examples:
      | Testname                    | User                    | Firstname | Lastname | zipcode |
      | TC001_StandardUser          | standard_user           | Praveen   | Raju     | 600118  |
      | TC002_PerformanceGlitchUser | performance_glitch_user | Aniyath   | Raju     | 600118  |