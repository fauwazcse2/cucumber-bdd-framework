Feature: Google search engine page-1

  Scenario: Verify the google page title
    Given user launch google search engine
    When user redirected to google page
    Then verify the title of google page

  Scenario: Verify the search feature of google
    Given user launch google search engine
    When user type "wikipedia" in search field
    Then user can see the "Wikipedia" result in list

  Scenario: Verify the footer menu list of google page
    Given user launch google search engine
    When user redirected to google page
    Then verify the menu list in footer