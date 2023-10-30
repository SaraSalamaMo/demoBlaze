package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ItemPage {

    private  WebDriver driver;
    private WebDriverWait wait;
    private final By addToCart = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    private final By cart = By.id("cartur");
    private final By deleteItem = By.xpath("//*[@id=\"tbodyid\"]/tr/td[4]/a");
    private final By placeOrderForm = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    private final By name = By.xpath("//*[@id=\"name\"]");
    private final By country = By.id("country");
    private final By city = By.id("city");
    private final By card = By.id("card");
    private final By month = By.id("month");
    private final By year = By.id("year");
    private final By purchase = By.cssSelector("[onclick=\"purchaseOrder()\"]");
    private final By confirmationMessage = By.xpath("/html/body/div[10]/h2");
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


    public void openPlaceOrderForm(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderForm)).click();
    }

    public void successfulCheckout(String name, String country, String city, String card, String month, String year){
        wait.until(ExpectedConditions.elementToBeClickable(this.name)).sendKeys(name);
        driver.findElement(this.country).sendKeys(country);
        driver.findElement(this.city).sendKeys(city);
        driver.findElement(this.card).sendKeys(card);
        driver.findElement(this.month).sendKeys(month);
        driver.findElement(this.year).sendKeys(year);
        driver.findElement(purchase).click();

    }

    public void assertItemAddedToCartSuccessfully(){
        String actualPopUpMessage = alert.getText();
        String expectedMessage = "Product added.";
        Assert.assertEquals(actualPopUpMessage, expectedMessage);
    }

    public void assertSuccessfulPurchase(){
        String actualPopUpMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).getText();
        String expectedMessage = "Thank you for your purchase!";
        Assert.assertEquals(actualPopUpMessage, expectedMessage);
    }


}
