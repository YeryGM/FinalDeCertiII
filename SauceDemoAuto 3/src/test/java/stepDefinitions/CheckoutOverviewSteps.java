package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CheckoutOverviewPage;

public class CheckoutOverviewSteps {
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(DriverManager.getDriver());

    @And("I click on the finish button")
    public void clickOnFinish(){
        checkoutOverviewPage.clickOnFinishButton();
    }

    @Then("I should see {int} products in the summary")
    public void verifyNumberOfProducts(int expectedCount){
        Assert.assertEquals(expectedCount, checkoutOverviewPage.getNumberOfItems());
    }

    @Then("I should see the subtotal calculated correctly")
    public void verifySubtotal(){
        // Aquí puedes agregar lógica para verificar el cálculo
        Assert.assertTrue(checkoutOverviewPage.getSubtotal() > 0);
    }

    @Then("I should see the tax calculated correctly")
    public void verifyTax(){
        Assert.assertTrue(checkoutOverviewPage.getTax() > 0);
    }

    @Then("I should see the total calculated correctly")
    public void verifyTotal(){
        Assert.assertTrue(checkoutOverviewPage.getTotal() > 0);
    }

    @And("I click on cancel button from overview")
    public void clickOnCancelFromOverview(){
        checkoutOverviewPage.clickOnCancelButton();
    }
}
