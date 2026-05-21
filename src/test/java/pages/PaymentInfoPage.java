package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaymentInfoPage {
    WebDriver driver;



    public PaymentInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



}
