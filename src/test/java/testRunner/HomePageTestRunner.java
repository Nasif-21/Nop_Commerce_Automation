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
    }

    @Test
    public void doPurchase()
    {
        HomePage homePage = new HomePage(driver);
        homePage.doPurchase();
    }
}
