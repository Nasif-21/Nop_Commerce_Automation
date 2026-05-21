package testRunner;

import Utils.Utils;
import config.Setup;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class ShippingMethodTestRunner extends Setup {
    @BeforeTest
    public void doLogin() throws IOException, ParseException, InterruptedException {
        Utils.setAuth(driver);
        driver.get("https://test470.nop-station.com/checkout/shippingmethod");
    }
}
