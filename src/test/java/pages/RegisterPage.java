package pages;

import Utils.Utils;
import config.Setup;
import config.UserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class RegisterPage{

    WebDriver driver;

    //Locators
    @FindBy(className="gender")
    List<WebElement> genderRadio;
    @FindBy(id="FirstName")
    WebElement txtFirstName;
    @FindBy(id="LastName")
    WebElement txtLastName;
    @FindBy(name="DateOfBirthDay")
    WebElement dateOfBirth;
    @FindBy(name="DateOfBirthMonth")
    WebElement dateOfBirthMonth;
    @FindBy(name="DateOfBirthYear")
    WebElement dateOfBirthYear;
    @FindBy(id="Email")
    WebElement txtEmail;
    @FindBy(id="Company")
    WebElement txtCompany;
    @FindBy(id="VatNumber")
    WebElement txtVatNumber;
    @FindBy(id="Newsletter")
    WebElement checkBoxNews;
    @FindBy(id="customer_attribute_1")
    WebElement txtCustomerAttibute;
    @FindBy(id="Password")
    WebElement txtPassword;
    @FindBy(id="ConfirmPassword")
    WebElement txtConfirmPassword;
    @FindBy(id="accept-consent")
    WebElement checkBoxConsent;
    @FindBy(id="register-button")
    WebElement btnRegister;
    @FindBy(className="register-continue-button")
    WebElement btnContinue;
    @FindBy(className ="result")
    public WebElement wordResult;



    //Initializer
    public RegisterPage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //Methods

    private void randomGender()
    {
        Random random = new Random();
        int index=random.nextInt(genderRadio.size());
        genderRadio.get(index).click();

    }

    private void randomBirthDay()
    {
        //Marking the dropdown
        Random random=new Random();
        Select day=new Select(dateOfBirth);
        Select month=new Select(dateOfBirthMonth);
        Select year=new Select(dateOfBirthYear);

        //Getting the index of the element
        int birthday=random.nextInt(day.getOptions().size());
        int birthMonth=random.nextInt(month.getOptions().size());
        int birthYear=random.nextInt(year.getOptions().size());

        //Randomized date and moth from the range of option
        day.selectByIndex(birthday);
        month.selectByIndex(birthMonth);
        year.selectByIndex(birthYear);

    }

    public void doRrgister(UserModel userModel) throws InterruptedException {
    Utils.scrollTo(driver,dateOfBirth);
    randomGender();
    txtFirstName.sendKeys(userModel.getFirstName());
    txtLastName.sendKeys(userModel.getLastName());
    Utils.elementWaiter(driver,dateOfBirth); //Add a simple waiter
    randomBirthDay();
    txtEmail.sendKeys(userModel.getEmail());
    Utils.scrollTo(driver,txtCompany);
    txtCompany.sendKeys(userModel.getCompanyName()!=null?userModel.getCompanyName():"" );
    txtVatNumber.sendKeys(userModel.getVatNo()!=null?userModel.getVatNo():"");
    Utils.elementWaiter(driver,checkBoxNews);
    Utils.scrollTo(driver,checkBoxNews);
    checkBoxNews.click();
    txtCustomerAttibute.sendKeys(userModel.getCPF()!=null? userModel.getCPF() : "");
    Utils.scrollTo(driver,txtConfirmPassword);
    txtPassword.sendKeys(userModel.getPassword());
    txtConfirmPassword.sendKeys(userModel.getPassword());
    checkBoxConsent.click();
    Utils.scrollTo(driver,checkBoxConsent);
    btnRegister.click();
    Utils.elementWaiter(driver,btnContinue);
    //btnContinue.click();



    }
}
