Feature: Smart Bear Software Functionality
    @Smoke
  Scenario: Validate invalid login attempt
    Given user is on "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx"
    When user enters username as "abcd"
    And user enters password as "abcd1234"
    And user clicks on Login button
    Then user should see "Invalid Login or Password." Message

    @Smoke
  Scenario: Validate valid login attempt
    Given user is on "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx"
    When user enters username as "Tester"
    And user enters password as "test"
    And user clicks on Login button
    Then user should be routed to "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/"

  @Regression
  Scenario: Validate "Web Orders" menu items
    Given user is on "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx"
    When user enters username as "Tester"
    And user enters password as "test"
    And user clicks on Login button
    Then user should be routed to "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/"
    And validate below menu items are displayed
      | View all orders | View all products | Order

    @Regression
  Scenario: Validate "Check All" and "Uncheck All" links
    Given user is on "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx"
    When user enters username as "Tester"
    And user enters password as "test"
    And user clicks on Login button
    Then user should be routed to "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/"
    When user clicks on "Check All" button
    Then all rows should be checked
    When user clicks on "Uncheck All" button
    Then all rows should be unchecked

  @Regression
  Scenario: Validate adding new order
    Given user is on "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx"
    When user enters username as "Tester"
    And user enters password as "test"
    And user clicks on Login button
    Then user should be routed to "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/"
    When user clicks on "Order" menu item
    And user selects "FamilyAlbum" as product
    And user enters 2 as quantity
    And user enters all address information
    And user enters all payment information
    And user clicks on "Process" button
    And user clicks on "View all orders" menu item
    Then user should see their order displayed in the "List of All Orders" table
    And validate all information entered displayed correct with the order
      |  | John Doe | FamilyAlbum | 2 | 07/11/2022 | 123 Address St | Chicago | IL | 60665 | Visa | 123456789 | 03/23 | |

    @Regression
  Scenario: Validate "Delete Selected" button
    Given user is on "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx"
    When user enters username as "Tester"
    And user enters password as "test"
    And user clicks on Login button
    Then user should be routed to "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/"
    When user clicks on "Check All" button
    And user clicks on "Delete Selected" button
    Then validate all orders are deleted from the "List of All Orders"
    And validate user sees "List of orders is empty. In order to add new order use this link." Message