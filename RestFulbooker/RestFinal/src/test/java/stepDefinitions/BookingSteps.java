package stepDefinitions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.BookingEndPoints;
import entities.Booking;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import utils.Request;

import java.util.List;

import static org.hamcrest.Matchers.hasKey;
public class BookingSteps {
    Response response;


    @And("I verify that the status code is {int}")
    public void verifyStatusCode(int statusCode){
        response.then().assertThat().statusCode(statusCode);
    }

    @And("I verify that the following fields are present inside {string}")
    public void verifyFieldsInsideKey(String key, DataTable fields){
        List<String> data = fields.transpose().asList(String.class);

        response.then().assertThat().body(key, hasKey(data.get(0)));
        response.then().assertThat().body(key, hasKey(data.get(1)));


    }

    @When("I perform a GET call to the employees endpoint with id {string}")
    public void getBookingById(String id) throws InterruptedException {
        Thread.sleep(5000);
        response = Request.getById(BookingEndPoints.GET_EMPLOYEE, id);
    }

    @And("I verify that the following fields are present in the root")
    public void verifyRootFields(DataTable fields){
        List<String> data = fields.transpose().asList(String.class);
        response.then().assertThat().body("$", hasKey(data.get(0)));
        response.then().assertThat().body("$", hasKey(data.get(1)));
        response.then().assertThat().body("$", hasKey(data.get(2)));
        response.then().assertThat().body("$", hasKey(data.get(3)));
        response.then().assertThat().body("$", hasKey(data.get(4)));

    }

    @And("verify that it displays the message {string}")
    public void verifyErrorMessage(String message){
        response.then().assertThat().body(Matchers.equalTo(message));

    }


    @And("I perform a POST call to the create endpoint with the following data")
    public void postBooking(DataTable employeeData) throws JsonProcessingException, InterruptedException {
        Thread.sleep(5000);
        List<String> data = employeeData.transpose().asList(String.class);

        Booking booking = new Booking();
        booking.setFirstname(data.get(0));
        booking.setLastname(data.get(1));
        booking.setTotalprice(data.get(2));
        booking.setDepositpaid(data.get(3));
        Booking.BookingDates bookingDates = new Booking.BookingDates();
        bookingDates.setCheckin(data.get(4));
        bookingDates.setCheckout(data.get(5));
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds(data.get(6));


        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(booking);


        response = Request.post(BookingEndPoints.POST_EMPLOYEE, payload);
    }



    @Then("I verify that the field {string} contains {string}")
    public void verifyFieldsValues(String field, String value){
        response.then().assertThat().body(field, Matchers.equalTo(value));
    }


}
