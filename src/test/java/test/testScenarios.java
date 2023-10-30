package test;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.ItemPage;

public class testScenarios extends baseTest{

    private final Faker faker = new Faker();
    private ItemPage itemPage;


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

    //ToDo failed login

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

    public void addRandomItemToCart() {
        homePage.selectMonitorsCategory();
        homePage.getItemsList();
        itemPage = homePage.selectRandomItem();
        itemPage.addToCart();
    }

    @Test(priority = 6)
    public void addRandomItemToCartSuccessfully(){
        addRandomItemToCart();
        itemPage.assertItemAddedToCartSuccessfully();
        itemPage.closeAlert();
    }


    @Test(priority = 7)
    public void deleteItemFromCart(){
        itemPage.openCart();
        itemPage.deleteItemFromCart();
    }

    @Test(priority = 8)
    public void createSuccessfulCheckout(){
        homePage.selectHome();
        addRandomItemToCart();
        itemPage.closeAlert();
        itemPage.openCart();
        String name = "Sara"; String country = "Egypt"; String city = "Cairo";
        String card = "123245678"; String month = "12"; String year = "27";
        itemPage.openPlaceOrderForm();
        itemPage.successfulCheckout(name,country,city,card,month,year);
        itemPage.assertSuccessfulPurchase();

    }

}
