package testRunner;

import Utils.Utils;
import config.Setup;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;

public class HomePageTestRunner extends Setup {
    @BeforeTest
    public void doLogin() throws IOException, ParseException, InterruptedException {
        Utils.setAuth(driver);
        driver.get("https://test470.nop-station.com");
    }

    @Test
    public void doPurchase() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.doPurchase();
    }
}
