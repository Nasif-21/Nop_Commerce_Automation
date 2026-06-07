package pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentInfoPage {
    WebDriver driver;
    WebDriverWait wait;


    @FindBy(className="payment-info-next-step-button")
    WebElement nextStepButton;

    @FindBy(css = "div.info")
    public WebElement txtInformation;

    @FindBy(xpath = "//div[@class='info']//b[contains(text(),'NOP SOLUTIONS')]")
    public WebElement txtCompanyName;

    @FindBy(xpath = "//div[@class='info']//b[contains(text(),'New York')]")
    public WebElement txtCityAddress;

    @FindBy(xpath="//div[@class='info']//b[contains(text(),'USA')]")
    public WebElement txtCountryName;


    public PaymentInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clicknextStepButton(){
        nextStepButton.click();
    }



}
