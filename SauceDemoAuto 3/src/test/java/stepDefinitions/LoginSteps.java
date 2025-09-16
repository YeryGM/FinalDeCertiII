package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(DriverManager.getDriver());

    @Given("I set the user name text box with {string}")
    public void setUserName(String userName){
        loginPage.setUserNameTextBox(userName);
    }

    @And("I set the password text box with {string}")
    public void setPassword(String password){
        loginPage.setPasswordTextBox(password);
    }

    @And("I click on the login button")
    public void clickOnLogin(){
        loginPage.clickOnLoginButton();
    }

    @And("A error message that says {string} should be displayed")
    public void verifyErrorMessage(String message){
        Assertions.assertTrue(loginPage.errorMessageIsDisplayed(message));
    }
    @Given("I am in sauce demo web page")
    public void goToSaucedemoPage(){
        DriverManager.getDriver().get("https://www.saucedemo.com");
        DriverManager.getDriver().manage().window().maximize();
    }


    @Then("I should be on the products page")
    public void verifyProductsPage(){
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("inventory.html"));
    }

    @Given("the user {string} is logged in Sauce Demo")
    public void userIsLoggedIn(String username){
        goToSaucedemoPage();
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.setUserNameTextBox(username);
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
    }


}
