package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPage {
    WebDriver driver;

    @FindBy(className = "confirm-order-next-step-button")
    WebElement btnConfirm;

    @FindBy(css = ".order-completed .title strong")
    public WebElement txtConfirmTitle;

    @FindBy (css = ".order-number")
    public WebElement txtOrderNumber;

    @FindBy(className = "order-completed-continue-button")
    WebElement btnContinue;

    public ConfirmPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickNextStepButton(){
        btnConfirm.click();
    }

    public String getOrderNumber(){
        return txtOrderNumber.getText();
    }

    public void clickContinueButton(){
        btnContinue.click();
    }



}
