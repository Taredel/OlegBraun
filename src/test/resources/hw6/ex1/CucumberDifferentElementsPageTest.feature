Feature: Cucumber Different Elements Page Test

  Scenario: Home Page and Different Elements Page test
    Given I open EPAM JDI site
    Then Title should be 'HOME_PAGE_TITLE'
    When I login as user 'PITER_CHAILOVSKII'
    Then User name should be 'PITER_CHAILOVSKII'
    And Home page should have 4 pictures, 4 texts under them and 2 text above
    When I click on Service subcategory in the Header
    Then Dropdown section should contains all options
      | SUPPORT            |
      | DATES              |
      | COMPLEX_TABLE      |
      | SIMPLE_TABLE       |
      | USER_TABLE         |
      | TABLE_WITH_PAGES   |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |
    When I click on Service subcategory in the LeftSection
    Then Left Sections should contains all options
      | SUPPORT            |
      | DATES              |
      | COMPLEX_TABLE      |
      | SIMPLE_TABLE       |
      | USER_TABLE         |
      | TABLE_WITH_PAGES   |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |
    When I open Service -> 'DIFFERENT_ELEMENTS' page
    Then Different Elements Page contains all needed elements
    And Different Elements Page contains Right Section
    And Different Elements Page contains Left Section
    # TODO, skype discussion
    When I select checkboxes
      |WATER |
      |WIND  |
    Then For each checkbox there is a log row corresponding their status 'true'
      |WATER |
      |WIND  |
    When I select radiobutton
      |SELEN |
    Then There is a log for selected radiobutton
      |SELEN |
    When I select colors
      |YELLOW |
    Then There is a log for selected color
      |YELLOW |
    When I unselect checkboxes
      |WATER |
      |WIND  |
    Then For each checkbox there is a log row corresponding their status 'false'
      |WATER |
      |WIND  |
