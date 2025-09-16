package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CheckoutInformationPage;

import java.util.List;

public class CheckoutInformationSteps {
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(DriverManager.getDriver());

    @And("I fill the checkout information with")
    public void fillCheckoutInformation(DataTable checkoutInformation){
        List<String> data = checkoutInformation.transpose().asList(String.class);
        //['Jorge', 'Perez', '12345']
        checkoutInformationPage.setFirstNameTextBox(data.get(0));
        checkoutInformationPage.setLastNameTextBox(data.get(1));
        checkoutInformationPage.setZipCodeTextBox(data.get(2));
    }

    @And("I click on the continue button")
    public void clickOnContinue(){
        checkoutInformationPage.clickOnContinueButton();
    }

    @And("I leave the {string} field empty")
    public void leaveFieldEmpty(String fieldName){
        checkoutInformationPage.clearAllFields();
        switch(fieldName.toLowerCase()){
            case "first name":
                checkoutInformationPage.setLastNameTextBox("Test");
                checkoutInformationPage.setZipCodeTextBox("12345");
                break;
            case "last name":
                checkoutInformationPage.setFirstNameTextBox("Test");
                checkoutInformationPage.setZipCodeTextBox("12345");
                break;
            case "zip code":
                checkoutInformationPage.setFirstNameTextBox("Test");
                checkoutInformationPage.setLastNameTextBox("Test");
                break;
        }
    }

    @Then("I should see the error message {string}")
    public void verifyErrorMessage(String expectedMessage){
        Assert.assertEquals(expectedMessage, checkoutInformationPage.getErrorMessage());
    }

    @When("I click on cancel button")
    public void clickOnCancelButton(){
        checkoutInformationPage.clickOnCancelButton();
    }

}
