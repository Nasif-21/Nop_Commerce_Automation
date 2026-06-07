package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentMethodPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "payment-method-next-step-button")
    WebElement btnNext;

    @FindBy(id="paymentmethod_0")
    WebElement radioNetsEasy;

    @FindBy(id="paymentmethod_1")
    WebElement radioGetNet;

    @FindBy(id="paymentmethod_2")
    WebElement radioConvergePayment;

    @FindBy(id="paymentmethod_3")
    WebElement radioCheckorMoneyOrder;

    @FindBy(id="paymentmethod_4")
    WebElement radioPayFast;



    public PaymentMethodPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void NetsEasyPayment()
    {
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        radioNetsEasy.click();
        btnNext.click();
    }

    public void GetNetPayment()
    {
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(radioGetNet));
        radioGetNet.click();
        btnNext.click();
    }

    public void ConvergePayment()
    {
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(radioConvergePayment));
        radioConvergePayment.click();
        btnNext.click();
    }

    public void CheckOrMoneyOrderPayment()
    {
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(radioCheckorMoneyOrder));
        radioCheckorMoneyOrder.click();
        btnNext.click();
    }

    public void PayFastPayment()
    {
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(radioPayFast));
        radioPayFast.click();
        btnNext.click();
    }






}
