package test;

import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class signUp extends baseTest{

    private final Faker faker = new Faker();


    @Test
    public void failedSignUp(){

        homePage.openSignUpForm();
        homePage.setUserName("sara");
        homePage.setPassword("sara");
        homePage.signUp();
        homePage.assertFailedSignUp();

    }



    @Test
    public void successfulSignUp(){

        homePage.setUserName(faker.name().username());
        homePage.setPassword(faker.internet().password());
        homePage.signUp();
        homePage.assertSuccessfulSignUp();
        homePage.closeAlert();

    }

}
