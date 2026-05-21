package pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;

    //Locators
    @FindBy(className = "ico-register")
    WebElement linkRegister;

    @FindBy(className = "ico-login")
    WebElement linkLogin;

    @FindBy(className = "ico-wishlist")
    WebElement linkWishList;

    @FindBy(className = "ico-logout")
    WebElement linkLogout;

    @FindBy(xpath="//a[@href='/electronics']")
    WebElement linkElectronics;

    @FindBy(xpath = "//a[@href='/cell-phones']")
    WebElement linkCellPhone;





    //Initializer
    public HomePage(WebDriver driver) {
        this.driver = driver;
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

    public void doPurchase()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(linkElectronics).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(linkCellPhone));
        linkCellPhone.click();
        /*String pagelink = driver.getCurrentUrl();
        System.out.println(pagelink);*/
    }

   /* public String getUrlCart()
    {
        doPurchase();
        return driver.getCurrentUrl();
    }*/

}
