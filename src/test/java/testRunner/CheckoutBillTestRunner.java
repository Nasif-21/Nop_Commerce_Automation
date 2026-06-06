package testRunner;

import Utils.Utils;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import config.AddressModel;
import config.Setup;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CheckOutBillPage;

import java.io.IOException;
import java.time.Duration;

public class CheckoutBillTestRunner extends Setup {

    CheckOutBillPage checkOutBillPage;
    WebDriverWait wait;

    @BeforeTest
    public void doLogin() throws IOException, ParseException, InterruptedException {
        Utils.setAuth(driver);
        driver.get("https://test470.nop-station.com/checkout/billingaddress");
    }
    @Test(priority = 1,description = "No next page for keep empty the mandatory fields")
    public void emptyMandatoryFields()
    {
        checkOutBillPage=new CheckOutBillPage(driver);
        checkOutBillPage.noMandatoryFieldsEntry();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(checkOutBillPage.txtCityError));
        wait.until(ExpectedConditions.visibilityOf(checkOutBillPage.txtAddress1Error));
        wait.until(ExpectedConditions.visibilityOf(checkOutBillPage.txtPhoneNumberError));


        String errorMessageCity=checkOutBillPage.txtCityError.getText();
        String errorMessageStreet=checkOutBillPage.txtAddress1Error.getText();
        String errorMessagePhone=checkOutBillPage.txtPhoneNumberError.getText();

        Assert.assertEquals(errorMessageCity,"City is required","City Message Error");
        Assert.assertEquals(errorMessageStreet,"Street address is required","Street Message Error");
        Assert.assertEquals(errorMessagePhone,"Phone is required","Phone Number Message Error");

    }

    @Test(priority = 2, description = "Setting new address")
    public void giveAddress() throws InterruptedException {
        checkOutBillPage = new CheckOutBillPage(driver);
        Faker faker = new Faker();
        String cityName = faker.country().capital();
        String address1=faker.address().fullAddress();
        checkOutBillPage.enterAddress(cityName,address1);

        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        Assert.assertEquals(driver.getCurrentUrl(),"https://test470.nop-station.com/checkout/shippingaddress");
    }

}
