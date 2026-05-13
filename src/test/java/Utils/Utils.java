package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

}
