package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckOutBillPage {
    WebDriver driver;



    public CheckOutBillPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



}
