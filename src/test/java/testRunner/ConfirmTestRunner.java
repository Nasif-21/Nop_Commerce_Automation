package testRunner;

import Utils.Utils;
import config.Setup;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ConfirmPage;
import pages.HomePage;
import pages.PaymentInfoPage;
import pages.ShippingAddressPage;
import services.GmailService;

import java.io.IOException;
import java.time.Duration;

public class ConfirmTestRunner extends Setup {

    ConfirmPage confirmPage;
    HomePage homePage;
    WebDriverWait wait;


    @BeforeTest
    public void doLogin() throws IOException, ParseException, InterruptedException {
        Utils.setAuth(driver);
        driver.get("https://test470.nop-station.com/checkout/confirm");
        Thread.sleep(2000);
        Utils.setCustomerAuth(driver);
    }

    @Test(priority = 1, description = "Doing final confirmation")
    public void confirmTest() throws InterruptedException {
        confirmPage = new ConfirmPage(driver);
        confirmPage.clickNextStepButton();
        Thread.sleep(2000);
        PaymentInfoPage paymentInfoPage = new PaymentInfoPage(driver);
        paymentInfoPage.clicknextStepButton();
        Thread.sleep(2000);
        confirmPage.clickNextStepButton();



    }

    //@Test(priority = 2,description = "Get proper page link after confirmation")
    public void pageLinkCheck()
    {
        confirmPage = new ConfirmPage(driver);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotNull(currentUrl);
    }

    //@Test(priority = 3, description = "Order accepted and got proper message with order number")
    public void orderNumber() throws InterruptedException {
        confirmPage = new ConfirmPage(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(4000);
        String confirmTite=confirmPage.txtConfirmTitle.getText();
        String orderNumber=confirmPage.txtOrderNumber.getText();

        Assert.assertEquals(confirmTite,"Your order has been successfully processed!");
        Assert.assertNotNull(orderNumber,"Order number is null");

    }

    //@Test(priority = 4,description = "Got gmail on order confirmation",enabled = true)
    public void gmailConfirmation() throws IOException {

        GmailService gmailService=new GmailService();
        String myEmail=gmailService.readGmail();
        String normalizedEmail = myEmail.substring(myEmail.indexOf("Thanks"));
        Assert.assertTrue(normalizedEmail.contains("Thanks for buying from Store 2. Below is the summary of the order."));


    }

    //@Test(priority = 5, description = "Go back to homepage")
    public void backToHomePage()
    {
        confirmPage = new ConfirmPage(driver);
        confirmPage.clickContinueButton();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://test470.nop-station.com/");
    }

    //@Test(priority =6,description = "Do logout")
    public void logout(){
        homePage = new HomePage(driver);
        homePage.clickLinkLogout();
    }

}
