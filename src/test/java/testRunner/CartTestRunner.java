package testRunner;

import Utils.Utils;
import config.Setup;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class CartTestRunner extends Setup {

    @BeforeTest
    public void doLogin() throws IOException, ParseException, InterruptedException {
        Utils.setAuth(driver);
        driver.get("https://test470.nop-station.com/cart");
    }

    @Test(priority = 1,description = "Check if the product added successfully")
    public void checkCart()
    {

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
