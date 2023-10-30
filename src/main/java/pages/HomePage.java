package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage{

    private WebDriver driver;
    private WebDriverWait wait;
    private final By signUpForm = By.id("signin2");
    private final  By userName = By.id("sign-username");
    private final By password = By.id("sign-password");
    private final By signUp = By.cssSelector("[onclick = 'register()']");
    public static Alert alert ;

    public HomePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public void openSignUpForm(){
        driver.findElement(signUpForm).click();
    }

    public void setUserName(String userName){
        wait.until(ExpectedConditions.elementToBeClickable(this.userName)).sendKeys(userName);
    }

    public void setPassword(String password){
        driver.findElement(this.password).sendKeys(password);

    }

    public void clearUserNameAndPassword(){
        driver.findElement(userName).clear();
        driver.findElement(password).clear();
    }


    public void signUp(){
        driver.findElement(signUp).click();
        alert = wait.until(ExpectedConditions.alertIsPresent());

    }

    public void closeAlert(){
        alert.accept();
    }

    public void login(){
        
    }

    public void assertFailedSignUp(){
        String actualSignUpMessage = alert.getText();
        String expectedSignUpMessage = "This user already exist.";
        Assert.assertEquals(actualSignUpMessage, expectedSignUpMessage);

    }

    public void assertSuccessfulSignUp(){
        String actualSignUpMessage = alert.getText();
        String expectedSignUpMessage = "Sign up successful.";
        Assert.assertEquals(actualSignUpMessage, expectedSignUpMessage);

    }
}
