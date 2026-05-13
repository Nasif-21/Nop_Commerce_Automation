package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    //Locators
    @FindBy(className = "ico-register")
    WebElement linkRegister;

    @FindBy(className = "ico-login")
    WebElement linkLogin;

    @FindBy(className = "ico-wishlist")
    WebElement linkWishList;

    @FindBy(className = "ico-logout")
    WebElement linkLogout;

    //Initializer
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }



    //Methods
    public void clickLinkRegister() {
        linkRegister.click();
    }

    public void clickLinkLogin() {
        linkLogin.click();
    }

    public void clickLinkLogout()
    {
        linkLogout.click();
    }

}
