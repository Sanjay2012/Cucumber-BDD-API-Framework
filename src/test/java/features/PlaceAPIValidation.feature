#Author: Sanjay Waware
#Designation: Sr. SDET
#Email: sanjaywaware04@gmail.com


@End2End
Feature: Validating google place API

	@addAPIPlace @regression @sanity 
  Scenario: Verify add palce API for single data
    Given add place paylod
    When user calls "addPlaceAPI" with "POST" http request
    Then verify the status code as 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And validate place_Id created in get request response

	@addAPIPlace @regression
  Scenario Outline: Verify add palce API for multiple data
    Given add place paylod with "<name>" "<phone>" "<address>" "<site>" "<language>" "<type1>" "<type2>" <latitude> <longitude>
    When user calls "addPlaceAPI" with "POST" http request
    Then verify the status code as 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And validate place_Id created maps to "<name>" using "getPlaceAPI"

    Examples: 
      | name        | phone              | address  | site               | language   | type1        | type2       | latitude  | longitude  |
      | Shivtirth   | (+91) 902 356 2396 | Mumbai   | www.shitirth.com   | English-IN | Family House | Banglow     | 72.452635 | -94.568923 |
      | Govind Bagh | (+91) 986 523 5896 | Baramati | www.govindbagh.com | French-IN  | Family House | Guest House | 75.568935 | -89.235648 |
      | Varsha BGL  | (+91) 856 246 8965 | Mumbai   | www.mhgovt.com     | English-IN | CM House     | Govt. House | 88.782698 | -85.784596 |


@updatePlaceAPI @regression @sanity
  Scenario: Verify update place API request
    Given updatePlace payload
    When user calls "updatePlaceAPI" with "PUT" http request
    Then verify the status code as 200
    And "msg" in response body is "Address successfully updated"


@deletePlaceAPI @regression
  Scenario: Verify delete place API request
    Given deletePlace payload
    When user calls "deletePlaceAPI" with "POST" http request
    Then verify the status code as 200
    And "status" in response body is "OK"
