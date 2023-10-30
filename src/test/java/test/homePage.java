package test;

import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class homePage extends baseTest{

    private final Faker faker = new Faker();


    @Test(priority = 1)
    public void failedSignUp(){

        homePage.openSignUpForm();
        homePage.setUserName(name);
        homePage.setPassword(password);
        homePage.signUp();
        homePage.assertFailedSignUp();

    }



    @Test(priority = 2)
    public void successfulSignUp(){

        homePage.setUserName(faker.name().username());
        homePage.setPassword(faker.internet().password());
        homePage.signUp();
        homePage.assertSuccessfulSignUp();
        homePage.closeAlert();

    }

    @Test(priority = 3)
    public void successfulLogin(){
        homePage.openLoginForm();
        homePage.login(name,password);
        homePage.assertSuccessfulLogin(name);
    }


    @Test(priority = 4)
    public void checkPhonesCategoryHasItems(){
        homePage.selectPhonesCategory();
        homePage.assertCategoryHasItems();
    }

    @Test(priority = 5)
    public void checkLaptopsCategoryHasItems(){
        homePage.selectLaptopsCategory();
        homePage.assertCategoryHasItems();
    }

    @Test(priority = 6)
    public void checkMonitorsCategoryHasItems(){
        homePage.selectMonitorsCategory();
        homePage.assertCategoryHasItems();
    }

}
