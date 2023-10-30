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
    private final By loginForm = By.id("login2");
    private final  By userName = By.id("sign-username");
    private final By password = By.id("sign-password");
    private final By loginUserName = By.id("loginusername");
    private final By loginPassword = By.id("loginpassword");
    private final By signUp = By.cssSelector("[onclick = 'register()']");
    private final By login = By.xpath("//button[@onclick='logIn()']");
    private final By nameOfUser = By.id("nameofuser");
    private  Alert alert ;

    public HomePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public void openSignUpForm(){
        driver.findElement(signUpForm).click();
    }

    public void openLoginForm(){
        driver.findElement(loginForm).click();
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

    public void setLoginUserName (String userName){
        wait.until(ExpectedConditions.elementToBeClickable(loginUserName)).sendKeys(userName);
    }

    public void setLoginPassword (String password){
        driver.findElement(loginPassword).sendKeys(password);
    }

    public void login(String userName, String password){
        setLoginUserName(userName);
        setLoginPassword(password);
        driver.findElement(login).click();
    }

    public void closeAlert(){
        alert.accept();
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

    public void assertSuccessfulLogin(String name){
        String actualNameOfUser = wait.until(ExpectedConditions.visibilityOfElementLocated(nameOfUser)).getText();
        String expectedNameOfUser = "Welcome " + name;
        Assert.assertEquals(actualNameOfUser, expectedNameOfUser);
    }
}
