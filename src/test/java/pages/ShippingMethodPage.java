package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShippingMethodPage {
    WebDriver driver;



    public ShippingMethodPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



}
