package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPage {
    WebDriver driver;



    public ConfirmPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



}
