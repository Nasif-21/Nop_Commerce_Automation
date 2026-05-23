package testRunner;

import Utils.Utils;
import config.Setup;
import config.UserModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;



public class LoginTestRunner extends Setup {

    LoginPage loginPage;
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeTest
    public void goLoginPage()
    {
        HomePage homePage = new HomePage(driver);
        homePage.clickLinkLogin();

    }

    @BeforeMethod
    public void clearTxtBox(Method method) throws InterruptedException {
        loginPage = new LoginPage(driver);
        if(!method.getName().equals("doLogin"))
        {
            loginPage.clearTxtBox();
            Thread.sleep(2000);
        }
        Utils.scroller(driver,200);

    }


    @Test(priority = 1,description = "Login without credencials")
    public void emptylogin() throws InterruptedException {
        //loginPage = new LoginPage(driver);
        String email="";
        String password="";
        loginPage.doLogin(email,password);

        wait.until(ExpectedConditions.visibilityOf(loginPage.errormsg));
        String emailError=loginPage.errormsg.getText();

        Assert.assertEquals(emailError,"Please enter your email");

    }

    @Test(priority = 2, description = "Login with invalid email type")
    public void invCredLogin()
    {
    //loginPage = new LoginPage(driver);
    String email="test123";

    wait.until(ExpectedConditions.visibilityOf(loginPage.errormsg));
    String emailError=loginPage.errormsg.getText();

    loginPage.sendinvalidEmail(email);
    Assert.assertEquals(emailError,"Please enter your email");
    }

    @Test(priority = 3, description = "Login with unregister credencials ")
    public void unregLLog() throws InterruptedException {
        String email="random@gmail.com";
        String password="123";

        //loginPage = new LoginPage(driver);
        loginPage.doLogin(email,password);


        wait.until(ExpectedConditions.visibilityOf(loginPage.errorValid));

        String validationError=loginPage.errorValid.getText();
        Assert.assertEquals(validationError,"No customer account found");

    }

    @Test(priority = 4, description = "Doing login with proper credencials")
    public void doLogin() throws IOException, ParseException, InterruptedException {
        String filepath="./src/test/resources/user.json";

        JSONObject jsonObj=Utils.readJsonData(filepath);
        String email=jsonObj.get("email").toString();
        String password=jsonObj.get("password").toString();


        loginPage.doLogin(email,password);
        Thread.sleep(2000);
        Utils.getAuth(driver);


        String url=driver.getCurrentUrl();
        Assert.assertTrue(url.equals(driver.getCurrentUrl()),"login unsuccessful");

    }
}
