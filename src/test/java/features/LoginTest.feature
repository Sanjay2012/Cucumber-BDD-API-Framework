#Author: Sanjay Waware
#Designation: Sr. SDET
#Email: sanjaywaware04@gmail.com

@login
Feature: Investment Banking app login functionality

  @sanity
  Scenario: login with valid credentials
    Given user on applications login page
    When user entered valid username and password
    And click on login button
    Then user should be land on user dashboard page
    And user can see his card status as "Enabled"

  @sanity
  Scenario Outline: Validate user credit card status
    Given user on applications login page
    When user entered valid username as "<username>" and password as "<password>"
    And click on login button
    Then user should be land on user dashboard page
    And user can see his card status as "<status>"
    
    Examples:
    |username|password|status  |
    |KW0610  |Shiv@123|active  |
    |ST5012  |Test@123|deactive|
    |XW7856  |Pass@123|deactive|
    |BY4236  |Mass@123|active  |
    
    

  