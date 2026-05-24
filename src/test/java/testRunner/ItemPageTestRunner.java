package testRunner;

import Utils.Utils;
import config.Setup;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ItemPage;

import java.io.IOException;

public class ItemPageTestRunner extends Setup {

    ItemPage itemPage;
    @BeforeTest
    public void doPurchase() throws InterruptedException, IOException, ParseException {

        Utils.setAuth(driver);
        driver.get("https://test470.nop-station.com/cell-phones");
        itemPage = new ItemPage(driver);
    }

    @Test(priority = 1, description = "Navigated to Exact page link")
    public void linkredirect()
    {
        Assert.assertEquals(driver.getTitle(), ". Cell phones");
    }

    @Test(priority =2, description = "Select an Item successfully")
    public void selectItem() throws InterruptedException {

        itemPage.clickAddToCart();

        String successMessage=itemPage.txtContent.getText();

        Assert.assertEquals(successMessage, "The product has been added to your shopping cart");
    }

    @Test(priority = 3, description = "Check the mobile name and price")
    public void checkNameAndPrice()
    {
       String productName=itemPage.productTitles.getText();
       String productPrice=itemPage.prices.getText();

       Assert.assertEquals(productName,"HTC One Mini Blue");
       Assert.assertEquals(productPrice,"$100.00");
    }
}
