package testRunner;

import Utils.Utils;
import config.Setup;
import config.UserModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;


public class LoginTestRunner extends Setup {

    @Test
    public void doLogin() throws IOException, ParseException, InterruptedException {
        String filepath="./src/test/resources/user.json";

        HomePage homePage = new HomePage(driver);
        homePage.clickLinkLogin();

        JSONObject jsonObj=Utils.readJsonData(filepath);
        String email=jsonObj.get("email").toString();
        String password=jsonObj.get("password").toString();

        LoginPage loginPage=new  LoginPage(driver);
        loginPage.doLogin(email,password);
        Thread.sleep(2000);
        Utils.getAuth(driver);







    }
}
