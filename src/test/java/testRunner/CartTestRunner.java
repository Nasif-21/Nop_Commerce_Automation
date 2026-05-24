package testRunner;

import Utils.Utils;
import config.Setup;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;

import java.io.IOException;
import java.time.Duration;

public class CartTestRunner extends Setup {

    CartPage cartPage;
    WebDriverWait wait;

    @BeforeTest
    public void doLogin() throws IOException, ParseException, InterruptedException {
        // Check the cart is empty before login
        driver.get("https://test470.nop-station.com/cart");
        cartPage = new CartPage(driver);

        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(cartPage.txtEmptyCart));

        String msg=cartPage.txtEmptyCart.getText();
        Assert.assertEquals(msg,"Your Shopping Cart is empty!");

        Thread.sleep(2000);
        Utils.setAuth(driver);
        driver.navigate().refresh();


    }

    @Test(priority = 1,description = "Check if the product added successfully")
    public void checkCart()
    {


    }

    @Test(description = "Click the product checkout without accepting terms and services")
    public void checkTermsAndServices() throws InterruptedException {
        cartPage.doCheckoutWithoutTermsofService();
        String msg=cartPage.txtMsgTermsOfService.getText();

        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(cartPage.txtMsgTermsOfService));
        Assert.assertEquals(msg,"Please accept the terms of service before the next step.");
        cartPage.closePopup();

    }

    @Test(description ="Check product name" )
    public void  checkProductName()
    {

    }

    @Test(priority = 3, description = "Calculate Price")
    public void calcPrice()
    {

    }


}
