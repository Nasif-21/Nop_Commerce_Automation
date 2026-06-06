package pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShippingMethodPage {
    WebDriver driver;
    WebDriverWait wait;


//Find locators and do rest of work
    @FindBy(id = "PickupInStore")
    WebElement checkboxpickStore;

    @FindBy(id="shippingoption_0")
    WebElement radioshippingGround;

    @FindBy(id="shippingoption_1")
    WebElement radioshippingAir;

    @FindBy(id="shippingoption_2")
    WebElement radioshippingAir2;

    @FindBy(className = "shipping-method-next-step-button")
    WebElement btnNext;



    public ShippingMethodPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void storeShipping()
    {
        Utils.scrollTo(driver, btnNext);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkboxpickStore));
        checkboxpickStore.click();
        //btnNext.click();


    }

    public void groundShipping()
    {
        Utils.scrollTo(driver, btnNext);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(radioshippingGround));
        radioshippingGround.click();
        //btnNext.click();

    }

    public void airShipping()
    {
        Utils.scrollTo(driver, btnNext);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(radioshippingAir));
        radioshippingAir.click();
        //btnNext.click();

    }

    public void airShipping2()
    {
        Utils.scrollTo(driver, btnNext);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(radioshippingAir2));
        radioshippingAir2.click();
        //btnNext.click();

    }



}
