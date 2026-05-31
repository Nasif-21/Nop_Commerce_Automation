package pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class CartPage {
    WebDriver driver;

    @FindBy(css = "a.product-name")
    public WebElement txtProductName;

    @FindBy(css = "span.product-unit-price")
    public WebElement txtUnitPrice;

    @FindBy(css = "input.qty-input")
    public WebElement txtQuantity;

    @FindBy(css = "span.product-subtotal")
    public WebElement txtTotalPrice;

    @FindBy(id="checkout_attribute_1")
    public WebElement giftWrapValue;

    @FindBy(id="checkout_attribute_2_3")
    public WebElement PackValue;

    @FindBy(css="tr.order-subtotal .value-summary")
    public WebElement txtSubTotal;

    @FindBy(css="tr.shipping-cost .value-summary")
    public  WebElement txtShippingCost;

    @FindBy(css="tr.tax-value .value-summary")
    public  WebElement txtTaxValue;

    @FindBy(css="tr.order-total .value-summary")
    public  WebElement txtTotal;

    @FindBy(className = "no-data")
    public WebElement txtEmptyCart;

    @FindBy(id="terms-of-service-warning-box")
    public WebElement txtMsgTermsOfService;

    @FindBy(xpath = "//button[@title='Close' and contains(@class,'ui-dialog-titlebar-close')]")
    WebElement btnPopupClose;

    @FindBy(id="termsofservice")
    WebElement checkboxTermsofService;

    @FindBy(id = "checkout")
    WebElement btnCheckout;



    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public Map<String,Double> cartDetails()
    {
        Map<String,Double> cart=new HashMap<>();
        cart.put("unitPrice",Utils.NumConverter(txtUnitPrice.getText()));
        cart.put("quantity",Utils.NumConverter(txtQuantity.getAttribute("value").trim()));
        cart.put("totalPrice",Utils.NumConverter(txtTotalPrice.getText()));

        return cart;

    }


    public void doCheckoutWithoutTermsofService() throws InterruptedException {
        Utils.scrollTo(driver,checkboxTermsofService);
        btnCheckout.click();
        Thread.sleep(2000);
    }

    public void closePopup() throws InterruptedException {
        btnPopupClose.click();
    }

    public void doCheckout()
    {
        Utils.scrollTo(driver,checkboxTermsofService);
        checkboxTermsofService.click();
        btnCheckout.click();
    }




}
