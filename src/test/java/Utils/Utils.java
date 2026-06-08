package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class Utils {

    //Random Number Generator
    public static int randomNum(int min,int max)
    {
        double randomnum=Math.random()*(max-min+1)+min;
        return (int) randomnum;
    }

    //Browser Scroller
    public static void scroller(WebDriver driver, int px)
    {
        JavascriptExecutor jsx= (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollTo(0,"+px+")");
    }

    //Experimental Scroller

    public static void scrollTo(WebDriver driver, WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",
                element
        );
    }

    //Make an element waiter to be loaded

    public static void elementWaiter(WebDriver driver, WebElement element)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));

    }



    //Saving JSON Data
    public static void saveJsonData(JSONObject jsonObject,String filepath) throws IOException, ParseException {
        JSONParser jsonParser=new JSONParser();
        JSONArray jsonArray=(JSONArray) jsonParser.parse(new FileReader(filepath));
        jsonArray.add(jsonObject);

        FileWriter fw=new FileWriter(filepath);
        fw.write(jsonArray.toJSONString());
        fw.flush();
        fw.close();
    }

    //Reading Json Data
    public static JSONObject readJsonData(String filepath) throws IOException, ParseException {
     JSONParser parser=new JSONParser();
     JSONArray jsonArray= (JSONArray) parser.parse(new FileReader(filepath));
     JSONObject jsonObj=(JSONObject) jsonArray.get(jsonArray.size()-1);
     return jsonObj;

    }

    // Saving an auth token into the js file

    public static void getAuth(WebDriver driver) throws IOException {

        // As the auth token saved in cookies, we need to get cookies using sellenium cookies method

        Cookie authCookie = driver.manage().getCookieNamed(".Nop.Authentication");

        if (authCookie != null) {
            String authToken=authCookie.getValue();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put(".Nop.Authentication",authToken);
            FileWriter writer=new FileWriter("./src/test/resources/localstorage.json");
            writer.write(jsonObject.toJSONString());
            writer.flush();
            writer.close();

        }
        else  {
            System.out.println("No auth token found, check code");
        }



    }


    // Inject auth token into browser
    public static void setAuth(WebDriver driver) throws IOException, ParseException, InterruptedException {
        JSONParser jsonParser=new JSONParser();
        JSONObject authObj= (JSONObject) jsonParser.parse(new FileReader("./src/test/resources/localstorage.json"));
        String authToken=authObj.get(".Nop.Authentication").toString();
        String currentUrl= driver.getCurrentUrl();
        String domain=new URL(currentUrl).getHost();

        Cookie authCookie = new Cookie.Builder(".Nop.Authentication",authToken)
                .domain(domain)
                .path("/")
                .isSecure(true)
                .isHttpOnly(true)
                .build();

        driver.manage().addCookie(authCookie);



        Thread.sleep(2000);

    }

    public static double NumConverter(String pricetxt)
    {
        return Double.parseDouble(pricetxt.replace("$","").replace(",","").trim());
    }

   /* public static void getCustomerAuth(WebDriver driver) throws IOException, ParseException {

        Cookie customerCookie = driver.manage().getCookieNamed("Nop.customer");

        if (customerCookie != null) {
            String customerToken = customerCookie.getValue();

            // ✅ Read existing JSON file first
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject;

            try {
                jsonObject = (JSONObject) jsonParser.parse(new FileReader("./src/test/resources/localstorage.json"));
            } catch (Exception e) {
                jsonObject = new JSONObject();
            }


            jsonObject.put("Nop.customer", customerToken);


            FileWriter writer = new FileWriter("./src/test/resources/localstorage2.json");
            writer.write(jsonObject.toJSONString());
            writer.flush();
            writer.close();

        } else {
            System.out.println("No customer session found, check code");
        }
    }


    // Inject auth token into browser
    public static void setCustomerAuth(WebDriver driver) throws IOException, ParseException, InterruptedException {
        JSONParser jsonParser = new JSONParser();
        JSONObject authObj = (JSONObject) jsonParser.parse(new FileReader("./src/test/resources/localstorage2.json"));

        // ✅ Use same key name used in getCustomerAuth()
        String customerToken = authObj.get("Nop.customer").toString();

        String currentUrl = driver.getCurrentUrl();
        String domain = new URL(currentUrl).getHost();

        Cookie customerCookie = new Cookie.Builder("Nop.customer", customerToken)
                .domain(domain)
                .path("/")
                .isSecure(true)
                .isHttpOnly(true)
                .build();

        driver.manage().addCookie(customerCookie);

        Thread.sleep(2000);
    }*/

    public static void getCustomerAuth(WebDriver driver) throws IOException {

        // As the auth token saved in cookies, we need to get cookies using sellenium cookies method

        Cookie authCookie = driver.manage().getCookieNamed(".Nop.Customer");

        if (authCookie != null) {
            String authToken=authCookie.getValue();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put(".Nop.Customer",authToken);
            FileWriter writer=new FileWriter("./src/test/resources/localstorage2.json");
            writer.write(jsonObject.toJSONString());
            writer.flush();
            writer.close();

        }
        else  {
            System.out.println("No customer session found, check code");
        }



    }


    // Inject auth token into browser
    public static void setCustomerAuth(WebDriver driver) throws IOException, ParseException, InterruptedException {
        JSONParser jsonParser=new JSONParser();
        JSONObject authObj= (JSONObject) jsonParser.parse(new FileReader("./src/test/resources/localstorage2.json"));
        String authToken=authObj.get(".Nop.Customer").toString();
        String currentUrl= driver.getCurrentUrl();
        String domain=new URL(currentUrl).getHost();

        Cookie authCookie = new Cookie.Builder(".Nop.Customer",authToken)
                .domain(domain)
                .path("/")
                .isSecure(true)
                .isHttpOnly(true)
                .build();

        driver.manage().addCookie(authCookie);



        Thread.sleep(2000);

    }


}
