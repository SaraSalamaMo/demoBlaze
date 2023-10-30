package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;

import java.lang.reflect.Method;

public class baseTest{

    public WebDriver driver;
    public HomePage homePage;
    // Given: SaraSalama is a registered user in demoblaze site
    public final String name = "SaraSalama";
    public final String password = "SaraSalama";


    @BeforeClass
    public void setUp(){

        String url = "https://www.demoblaze.com/";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        homePage = new HomePage(driver);

    }


    @AfterMethod
    public void afterFailedSignUp(Method method){
        if(method.getName().equals("failedSignUp")){
            homePage.closeAlert();
            homePage.clearUserNameAndPassword();
        }
    }


//    @AfterClass
    public void tearDown(){
        driver.close();
    }


}
