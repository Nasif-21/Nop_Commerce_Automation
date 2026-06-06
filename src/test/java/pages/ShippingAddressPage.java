package pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAddressPage {
    WebDriver driver;

    @FindBy(className = "select-shipping-address-button")
    WebElement btnShippingAddress;



    public ShippingAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickBtnShippingAddress(){
        Utils.scrollTo(driver,btnShippingAddress);
        btnShippingAddress.click();
    }



}
