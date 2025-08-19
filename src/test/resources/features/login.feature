Feature: Login Feature

  Scenario: Successful login
    Given User is on login page
    When User enters username "Admin" and password "admin123"
    Then clicks on login button

   
