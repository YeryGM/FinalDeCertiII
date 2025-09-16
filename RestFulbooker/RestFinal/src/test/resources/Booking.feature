Feature: Employees endpoint

  Background: Employees endpoints should allow to get, put, post and delete



  Scenario: /booking/{id} should return a booking with the id given
    Given I perform a GET call to the employees endpoint with id "100"
    Then I verify that the status code is 200
    And I verify that the following fields are present in the root
      | firstname | lastname | totalprice | depositpaid | bookingdates | additionalneeds |
    And I verify that the following fields are present inside "bookingdates"
      | checkin | checkout |


  Scenario: /booking/{id} must not return an specific booking with an id that does not exist
    Given I perform a GET call to the employees endpoint with id "99999"
    Then I verify that the status code is 404
    And verify that it displays the message "Not Found"


  Scenario Outline: /create should create a new booking
    Given I perform a POST call to the create endpoint with the following data
      | <firstname> | <lasttname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |
    Then I verify that the status code is 200
    And I verify that the field "booking.firstname" contains "<firstname>"
    And I verify that the field "booking.lastname" contains "<lasttname>"
    And I verify that the field "booking.totalprice" contains "<totalprice>"
    And I verify that the field "booking.depositpaid" contains "<depositpaid>"
    And I verify that the field "booking.bookingdates.checkin" contains "<checkin>"
    And I verify that the field "booking.bookingdates.checkout" contains "<checkout>"
    And I verify that the field "additionalneeds" contains "<additionalneeds>"
    Examples:
      | firstname | lasttname   | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Yery      | Gallardo    | 500        | true        | 2004-12-14 | 2004-12-16 | breakfast       |



  Scenario Outline: /create must not create a new Booking
    Given I perform a POST call to the create endpoint with the following data
      | <firstname> | <lasttname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |
    Then I verify that the status code is 400
    Examples:
      | firstname | lasttname   | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | 123       | Gallardo    | 500        | true        | 2004-12-14 | 2004-12-16 | breakfast       |
      | Nao       |Arcienega    | 346        | 23          | 2018-01-01 | 2018-01-01 | breakfast       |
      | Naty      | Gallardo    | Hola       | true        | 2004-12-14 | 2004-12-16 | breakfast       |

