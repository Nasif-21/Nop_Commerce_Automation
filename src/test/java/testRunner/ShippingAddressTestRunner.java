package testRunner;

import Utils.Utils;
import config.Setup;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ShippingAddressPage;

import java.io.IOException;
import java.time.Duration;

public class ShippingAddressTestRunner extends Setup {

    WebDriverWait wait;
    ShippingAddressPage shippingAddressPage;

    @BeforeTest
    public void doLogin() throws IOException, ParseException, InterruptedException {
        Utils.setAuth(driver);
        driver.get("https://test470.nop-station.com/checkout/shippingaddress");
    }
    @Test(priority = 1,description = "Provide similar shipping address as billing address")
    public void shippingAddressTest(){
        shippingAddressPage = new ShippingAddressPage(driver);
        shippingAddressPage.clickBtnShippingAddress();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        Assert.assertEquals(driver.getCurrentUrl(),"https://test470.nop-station.com/checkout/shippingmethod");
    }
}
