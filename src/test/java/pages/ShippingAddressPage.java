package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShippingAddressPage {
    WebDriver driver;



    public ShippingAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



}
