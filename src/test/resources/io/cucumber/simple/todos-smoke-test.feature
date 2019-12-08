Feature: User add item and marked them done
  Scenario: User add new item
    Given I open todos application
    And   I add new item with the name "Pay for electricity"
    And   I add new item with the name "Change the oil in my Tesla"
    Then  Item with name "Pay for electricity" was added
    And   Item with name "Change the oil in my Tesla" was added

  Scenario Outline: User add <item> in loop
    Given I open todos application
    And   I add new item with the name "<item>"
    Then  Item with name "<item>" was added
    Examples:
    |item             |
    |Buy some fruits  |
    |Drink some water |

