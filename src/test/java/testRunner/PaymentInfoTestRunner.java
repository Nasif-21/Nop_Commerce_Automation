package testRunner;

import Utils.Utils;
import config.Setup;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.PaymentInfoPage;

import java.io.IOException;
import java.time.Duration;

public class PaymentInfoTestRunner extends Setup {

    PaymentInfoPage paymentInfoPage;
    WebDriverWait wait;

    @BeforeTest
    public void doLogin() throws IOException, ParseException, InterruptedException {
        Utils.setAuth(driver);
        driver.get("https://test470.nop-station.com/checkout/paymentinfo");
    }

    @Test(priority = 1, description = "Completing payment using payment gateway and check the address is correct")
    public void finishPayment() throws InterruptedException, IOException, ParseException {
        paymentInfoPage = new PaymentInfoPage(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(paymentInfoPage.txtInformation));

        Utils.scrollTo(driver, paymentInfoPage.txtInformation);

        String companyName = paymentInfoPage.txtCompanyName.getText();
        String cityAddress = paymentInfoPage.txtCityAddress.getText();
        String countryName = paymentInfoPage.txtCountryName.getText();


        //Address verification
        Assert.assertEquals(companyName, "NOP SOLUTIONS");
        Assert.assertEquals(cityAddress,"New York, NY 10001");
        Assert.assertEquals(countryName,"USA");
        Thread.sleep(2000);

        paymentInfoPage.clicknextStepButton();
        Thread.sleep(3000);
        Utils.getCustomerAuth(driver);

        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        Assert.assertEquals(driver.getCurrentUrl(),"https://test470.nop-station.com/checkout/confirm");



    }
}
