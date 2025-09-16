package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement sauceDemoTitle;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productNames;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean sauceDemoTitleIsDisplayed() {
        if(sauceDemoTitle.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean productIsDisplayed(String expectedProductName){
        String actualProductName = "";
        for (WebElement element: productNames){
            actualProductName = element.getText();
            if(actualProductName.equalsIgnoreCase(expectedProductName)){
                return true;
            }
        }
        return false;
    }

    public void addProductToCart(String productName){
        //add-to-cart-Sauce-Labs-Backpack
        // add-to-cart-sauce-labs-backpack
        String productId = "add-to-cart-"+productName.replace(" ", "-").toLowerCase();
        WebElement addToCartButton = driver.findElement(By.id(productId));
        addToCartButton.click();
    }

    public void clickOnCartIcon(){
        cartIcon.click();
    }
}
