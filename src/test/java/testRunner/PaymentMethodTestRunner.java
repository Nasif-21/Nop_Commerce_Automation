package testRunner;

import Utils.Utils;
import config.Setup;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.PaymentMethodPage;

import java.io.IOException;
import java.time.Duration;

public class PaymentMethodTestRunner extends Setup {

    PaymentMethodPage paymentMethodPage;
    WebDriverWait wait;

    @BeforeTest
    public void doLogin() throws IOException, ParseException, InterruptedException {
        Utils.setAuth(driver);
        driver.get("https://test470.nop-station.com/checkout/paymentmethod");
    }

    // I have used payment using check or money order, if you want to check others, just make the enabled=true
    @Test(description = "Payment using Nets Easy",enabled = false)
    public void paymentNetsEasy()
    {
        paymentMethodPage = new PaymentMethodPage(driver);
        paymentMethodPage.NetsEasyPayment();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://test470.nop-station.com/checkout/paymentinfo"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://test470.nop-station.com/checkout/paymentinfo");
    }

    @Test(description = "Payment using Get Net",enabled = false)
    public void paymentGetNet()
    {
        paymentMethodPage = new PaymentMethodPage(driver);
        paymentMethodPage.GetNetPayment();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://test470.nop-station.com/checkout/paymentinfo"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://test470.nop-station.com/checkout/paymentinfo");
    }

    @Test(description = "Payment using Converge Payment",enabled = false)
    public void paymentConverge()
    {
        paymentMethodPage = new PaymentMethodPage(driver);
        paymentMethodPage.ConvergePayment();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://test470.nop-station.com/checkout/paymentinfo"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://test470.nop-station.com/checkout/paymentinfo");
    }

    @Test(description = "Payment using Check or Money order",enabled = true)
    public void paymentCheckorMoney() throws IOException, InterruptedException {
        paymentMethodPage = new PaymentMethodPage(driver);
        paymentMethodPage.CheckOrMoneyOrderPayment();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://test470.nop-station.com/checkout/paymentinfo"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://test470.nop-station.com/checkout/paymentinfo");
    }

    @Test(description = "Payment using PayFast",enabled = false)
    public void paymentPayFast()
    {
        paymentMethodPage = new PaymentMethodPage(driver);
        paymentMethodPage.PayFastPayment();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://test470.nop-station.com/checkout/paymentinfo"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://test470.nop-station.com/checkout/paymentinfo");
    }


}
