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
    @BeforeTest
    public void doPurchase() throws InterruptedException, IOException, ParseException {

        Utils.setAuth(driver);
        driver.get("https://test470.nop-station.com/cell-phones");
    }

    @Test(priority = 1, description = "Navigated to Exact page link")
    public void linkredirect()
    {
        Assert.assertEquals(driver.getTitle(), ". Cell phones");
    }

    @Test(priority =2, description = "Select an Item successfully")
    public void selectItem() throws InterruptedException {
        ItemPage itemPage = new ItemPage(driver);
        itemPage.clickAddToCart();

        String successMessage=itemPage.txtContent.getText();
        System.out.println(successMessage);
        Assert.assertEquals(successMessage, "The product has been added to your shopping cart");
    }
}
