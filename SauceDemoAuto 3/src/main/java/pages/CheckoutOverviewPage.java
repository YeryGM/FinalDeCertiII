package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutOverviewPage {

    WebDriver driver;

    @FindBy(id="finish")
    WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnFinishButton(){
        finishButton.click();
    }
    @FindBy(className = "cart_item")
    List<WebElement> cartItems;

    @FindBy(className = "summary_subtotal_label")
    WebElement subtotalLabel;

    @FindBy(className = "summary_tax_label")
    WebElement taxLabel;

    @FindBy(className = "summary_total_label")
    WebElement totalLabel;

    @FindBy(id = "cancel")
    WebElement cancelButton;

    public int getNumberOfItems(){
        return cartItems.size();
    }

    public double getSubtotal(){
        String text = subtotalLabel.getText();
        return Double.parseDouble(text.replace("Item total: $", ""));
    }

    public double getTax(){
        String text = taxLabel.getText();
        return Double.parseDouble(text.replace("Tax: $", ""));
    }

    public double getTotal(){
        String text = totalLabel.getText();
        return Double.parseDouble(text.replace("Total: $", ""));
    }

    public void clickOnCancelButton(){
        cancelButton.click();
    }

}
