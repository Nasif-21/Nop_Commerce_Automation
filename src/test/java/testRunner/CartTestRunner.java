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
import java.util.HashMap;
import java.util.Map;

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
        String productName=cartPage.txtProductName.getText();
        Assert.assertEquals(productName,"HTC One Mini Blue");

    }

    @Test(priority = 2, description = "Calculate Price")
    public void calcPrice()
    {
    Utils.scrollTo(driver, cartPage.txtProductName);
        Map<String,Double> cart=cartPage.cartDetails();

        double expected=cart.get("totalPrice");
        double actual=cart.get("unitPrice")*cart.get("quantity");
        Assert.assertEquals(actual,expected);

    }

    @Test(priority = 3, description = "Subtotal value check")
    public void checkSubtotal() throws InterruptedException {


        boolean priceTrue=cartPage.PackValue.isSelected();
        Map <String,Double> cart=cartPage.cartDetails();

        //Price Calculation

        Thread.sleep(2000);
        double subtotal=Utils.NumConverter(cartPage.txtSubTotal.getText());
        double shippingCost=Utils.NumConverter(cartPage.txtShippingCost.getText());
        double tax=Utils.NumConverter(cartPage.txtTaxValue.getText());

        if(priceTrue)
        {
            double finalTotal=cart.get("totalPrice")+100;
            double total=subtotal+shippingCost+tax;

            Assert.assertEquals(finalTotal,total,"Mismatched cart value, please check");


        }
        else
        {
         double finalTotal=cart.get("totalPrice");
         double total=subtotal+shippingCost+tax;
         Assert.assertEquals(finalTotal,total,"Mismatched cart value, please check");

        }

    }

    @Test(priority = 4, description = "Click the product checkout without accepting terms and services")
    public void checkTermsAndServices() throws InterruptedException {

        cartPage.doCheckoutWithoutTermsofService();
        String msg=cartPage.txtMsgTermsOfService.getText();

        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(cartPage.txtMsgTermsOfService));
        Assert.assertEquals(msg,"Please accept the terms of service before the next step.");
        cartPage.closePopup();

    }

    @Test(priority = 5, description = "Doing checkout")
    public void properCheckout()
    {
        cartPage.doCheckout();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        Assert.assertEquals(driver.getCurrentUrl(),"https://test470.nop-station.com/checkout/billingaddress");
    }

//
//    @Test(description ="Check product name" )
//    public void  checkProductName()
//    {
//
//    }
//



}
