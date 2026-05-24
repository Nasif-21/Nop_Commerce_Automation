package pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;


    @FindBy(className = "no-data")
    public WebElement txtEmptyCart;

    @FindBy(id="terms-of-service-warning-box")
    public WebElement txtMsgTermsOfService;

    @FindBy(xpath = "//button[@title='Close' and contains(@class,'ui-dialog-titlebar-close')]")
    WebElement btnPopupClose;

    @FindBy(id="termsofservice")
    WebElement checkboxTermsofService;

    @FindBy(id = "checkout")
    WebElement btnCheckout;



    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void doCheckoutWithoutTermsofService() throws InterruptedException {
        Utils.scrollTo(driver,checkboxTermsofService);
        btnCheckout.click();
        Thread.sleep(2000);
    }

    public void closePopup() throws InterruptedException {
        btnPopupClose.click();
    }

    public void doCheckout()
    {
        Utils.scrollTo(driver,checkboxTermsofService);
        checkboxTermsofService.click();
        btnCheckout.click();
    }




}
