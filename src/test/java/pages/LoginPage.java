package pages;

import Utils.Utils;
import config.UserModel;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //Locators
    @FindBy(id="Email")
    WebElement emailtxt;

    @FindBy(id="Password")
    WebElement passwordtxt;

    @FindBy(className ="login-button")
    WebElement loginbtn;

    @FindBy(xpath = "//span[@id='Email-error']")
    public WebElement errormsg;

    // Error text inside list
    @FindBy(xpath = "//div[contains(@class,'validation-summary-errors')]//ul/li")
    public WebElement errorValid;


    //Initializer
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Methods
    public void doLogin(String email, String password)
    {
        emailtxt.sendKeys(email);
        passwordtxt.sendKeys(password);
        loginbtn.click();
    }

    public void clearTxtBox()
    {
        emailtxt.sendKeys(Keys.CONTROL + "a",Keys.BACK_SPACE);
        passwordtxt.sendKeys(Keys.CONTROL + "a",Keys.BACK_SPACE);
    }
    public void sendinvalidEmail(String email)
    {
        emailtxt.sendKeys(email);
    }

}
