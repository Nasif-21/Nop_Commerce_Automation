package testRunner;

import Utils.Utils;
import config.Setup;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ShippingMethodPage;

import java.io.IOException;
import java.time.Duration;

public class ShippingMethodTestRunner extends Setup {
    WebDriverWait wait;
    ShippingMethodPage shippingMethodPage;

    @BeforeTest
    public void doLogin() throws IOException, ParseException, InterruptedException {
        Utils.setAuth(driver);
        driver.get("https://test470.nop-station.com/checkout/shippingmethod");
    }

    @Test(priority = 1,description = "Shipping using Store")
    public void StoreShipTest()
    {
        shippingMethodPage = new ShippingMethodPage(driver);
        shippingMethodPage.storeShipping();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        Assert.assertEquals(driver.getCurrentUrl(),"https://test470.nop-station.com/checkout/paymentmethod");

    }

    //If anyone wants to check other payment methods, just remove enable=false and in suite.xml, provide suite name to regression
    @Test(priority = 2,description = "Shipping using ground", suiteName = "regression", enabled = false)
    public void GroundShipTest()
    {
        shippingMethodPage = new ShippingMethodPage(driver);
        shippingMethodPage.groundShipping();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        Assert.assertEquals(driver.getCurrentUrl(),"https://test470.nop-station.com/checkout/paymentmethod");

    }

    @Test(priority = 3,description = "Shipping using Air",suiteName = "regression", enabled = false)
    public void AirShipTest()
    {
        shippingMethodPage = new ShippingMethodPage(driver);
        shippingMethodPage.airShipping();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        Assert.assertEquals(driver.getCurrentUrl(),"https://test470.nop-station.com/checkout/paymentmethod");

    }

    @Test(priority = 4,description = "Shipping using Air 2",suiteName = "regression", enabled = false)
    public void AirShipTest2()
    {
        shippingMethodPage = new ShippingMethodPage(driver);
        shippingMethodPage.airShipping2();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        Assert.assertEquals(driver.getCurrentUrl(),"https://test470.nop-station.com/checkout/paymentmethod");
    }


}
