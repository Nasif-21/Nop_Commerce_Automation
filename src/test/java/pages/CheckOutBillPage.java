package pages;

import Utils.Utils;
import com.github.javafaker.Faker;
import config.AddressModel;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

public class CheckOutBillPage {
    WebDriver driver;
    WebDriverWait  wait;


    @FindBy(id="BillingNewAddress_CountryId")
    WebElement dropDowncountry;

    @FindBy(id="BillingNewAddress_StateProvinceId")
    WebElement dropDownstate;

    @FindBy(id="BillingNewAddress_City")
    WebElement txtCity;

    @FindBy(id="BillingNewAddress_Address1")
    WebElement txtAddress1;

    @FindBy(id="BillingNewAddress_PhoneNumber")
    WebElement txtPhoneNumber;

    @FindBy(id="billingaddress-next-button")
    WebElement btnNext;

    @FindBy(id="BillingNewAddress_City-error")
    public WebElement txtCityError;

    @FindBy(id="BillingNewAddress_Address1-error")
    public WebElement txtAddress1Error;

    @FindBy(id="BillingNewAddress_PhoneNumber-error")
    public WebElement txtPhoneNumberError;


    public CheckOutBillPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    /*
    First, it will provide select any random country , if the random country has a state, it will check if its has a state, if yes
    it will select a random state

     */
    private void selectRandomCountry() throws InterruptedException {

        Utils.scrollTo(driver,dropDowncountry);
        Select country = new Select(dropDowncountry);


        List<WebElement> options = country.getOptions()
                .stream()
                .filter(opt->!opt.getAttribute("value").equals("0"))
                .collect(Collectors.toList());

        Random rand = new Random();
        WebElement size=options.get(rand.nextInt(options.size()));
        String countryValue=size.getAttribute("value");
        country.selectByValue(countryValue);

        stateLoaderWaiter();
        selectRandomState();

    }

    //Added a waiter for loading the state dropdown to be loaded
    private void stateLoaderWaiter()
    {
        try {
            wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(dropDownstate));
            wait.until(ExpectedConditions.elementToBeClickable(dropDownstate));

        }
        catch (TimeoutException e)
        {
            System.out.println("Exception in stateLoaderWaiter");
        }
    }

    private boolean hasState()
    {
      try {
          Select state = new Select(dropDownstate);

          long optionsCount = state.getOptions()
                  .stream()
                  .filter(opt->!opt.getAttribute("value").equals("0"))
                  .count();

          return optionsCount > 0;

      }
      catch (NoSuchElementException e) {
          return  false;
      }
    }


    private void selectRandomState()
    {
        Select state=new Select(dropDownstate);
        List<WebElement> options = state.getOptions();

        if(hasState())
        {
            int randomIndex = new Random().nextInt(options.size()-1)+1;
            state.selectByIndex(randomIndex);
        }
        else
        {
            state.selectByIndex(0);
        }


    }

    public void noMandatoryFieldsEntry()
    {
        Utils.scrollTo(driver,btnNext);
        btnNext.click();
    }


    public void enterAddress(String cityName, String fullAddress) throws InterruptedException {
        selectRandomCountry();
        txtCity.sendKeys(cityName);
        txtAddress1.sendKeys(fullAddress);
        Utils.scrollTo(driver,btnNext);
        txtPhoneNumber.sendKeys("01"+ Utils.randomNum(100000000,999999999));
        Utils.scrollTo(driver,btnNext);
        btnNext.click();



    }

}
