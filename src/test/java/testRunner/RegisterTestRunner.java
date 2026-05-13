package testRunner;

import Utils.Utils;
import com.github.javafaker.Faker;
import config.Setup;
import config.UserModel;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import java.sql.SQLOutput;

public class RegisterTestRunner extends Setup {

    @Test
    public void RegisterTest() throws InterruptedException {
        HomePage homepage=new HomePage(driver);
        homepage.clickLinkRegister();
        RegisterPage registerpage=new RegisterPage(driver);
        Faker faker=new Faker();
        UserModel userModel=new UserModel();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email="skfamily0304+"+Utils.randomNum(10,50)+"@gmail.com";
        String password="123456";
        String confirmPassword=password;


        userModel.setFirstName(firstName);
        userModel.setLastName(lastName);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setConfirmPassword(confirmPassword);

        registerpage.doRrgister(userModel);
        //Assert.

        //Saving information to JSON File

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("firstName",firstName);
        jsonObject.put("lastName",lastName);
        jsonObject.put("email",email);
        jsonObject.put("password",password);
        String filePath="./src/test/resources/user.json";


        try {
            Thread.sleep(2000);
            Utils.saveJsonData(jsonObject,filePath);
            System.out.println("Data Successfully Saved in JSON");

        }
        catch (Exception e) {
            System.out.println("Data save faliure, check error "+e.getMessage());
        }

        Utils.elementWaiter(driver, registerpage.wordResult);
        String successMessage=registerpage.wordResult.getText();
        Assert.assertEquals(successMessage,"Your registration completed");




        //homepage.clickLinkLogout();





    }


}
