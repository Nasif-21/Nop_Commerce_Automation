package testRunner;

import config.Setup;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class LoginTestRunner extends Setup {

    @Test
    public void doLogin()
    {
        HomePage homePage = new HomePage(driver);
        homePage.clickLinkLogin();


    }
}
