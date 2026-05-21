package pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

import java.util.List;

public class ItemPage {

    WebDriver driver;

    @FindBy(css = "button.product-box-add-to-cart-button")
    WebElement btnaddToCart;

    @FindBy(className = "content")
    public WebElement txtContent;



    public ItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCart() throws InterruptedException {
        Utils.scrollTo(driver,btnaddToCart);
        Utils.elementWaiter(driver,btnaddToCart);
        btnaddToCart.click();
        Thread.sleep(2000);
        btnaddToCart.click();
    }

    
}
