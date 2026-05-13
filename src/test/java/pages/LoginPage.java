package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //Locators



    //Initializer
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Methods

}
