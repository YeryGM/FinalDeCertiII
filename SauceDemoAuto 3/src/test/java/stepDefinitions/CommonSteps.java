package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;

import java.util.Objects;

public class CommonSteps {


    @Then("I should be on the cart page")
    public void verifyCartPage(){
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertNotNull("URL should not be null", currentUrl);
        Assert.assertTrue("Should be on cart page. Current URL: " + currentUrl,
                currentUrl.contains("cart.html"));
    }



}
