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

  Scenario: User add several items in loop and mark some of them as done
    Given I open todos application
    And   I add new item with the name "Pay for electricity"
    And   I add new item with the name "Change the oil in my Tesla"
    And   I add new item with the name "Clean black mirror"
    And   I add new item with the name "Clean black mirror"
    Then  I mark all items with the name "Clean black mirror" done
    And   I mark all items with the name "Pay for electricity" done
    Then  Items should be checked
    |Clean black mirror |
    |Pay for electricity|

  Scenario: User add 2 items, check one and verify counter
    Given I open todos application
    And   I add new item with the name "Pay for electricity"
    And   I add new item with the name "Change the oil in my Tesla"
    When  I mark single item with the name "Pay for electricity"
    Then  Counter should show "1 item left"