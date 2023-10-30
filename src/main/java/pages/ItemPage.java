package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ItemPage {

    private  WebDriver driver;
    private WebDriverWait wait;
    private final By addToCart = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    private final By cart = By.id("cartur");
    private final By deleteItem = By.xpath("//*[@id=\"tbodyid\"]/tr/td[4]/a");
    private Alert alert;


    public ItemPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void addToCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart)).click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
    }

    public void closeAlert(){
        alert.accept();
    }

    public void openCart(){
        driver.findElement(cart).click();
    }

    public void deleteItemFromCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteItem)).click();
    }

    public void assertItemAddedToCartSuccessfully(){
        String actualPopUpMessage = alert.getText();
        String expectedMessage = "Product added.";
        Assert.assertEquals(actualPopUpMessage, expectedMessage);
    }

}
