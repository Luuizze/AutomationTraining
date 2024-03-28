package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.productPage;
import pageObjects.cartPage;
import utils.baseTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static utils.browser.getCurrentDriver;


public class LoginTest extends baseTest {
    private final loginPage loginpage = new loginPage();
    private final homePage homepage = new homePage();
    private final productPage productpage = new productPage();
    private final cartPage cartpage = new cartPage();
    @Test
    public void testOpenWindow(){
        startTest();
        String url = getCurrentUrl();
        assertEquals("https://www.demoblaze.com/", url);
        endTest();
    }

    @Test
    public void realizarLogin() {
        startTest();
        homepage.clickMenuLogin();
        sleepTest(false);
        loginpage.fillEmail("euluizteste");
        loginpage.fillpassword("1234");
        loginpage.clickBtnSubmitLogin();
        endTest();
    }

    @Test
    public void testInvalidUsername(){
        startTest();
        homepage.clickMenuLogin();
        sleepTest(false);
        loginpage.fillEmail("azulino");
        loginpage.fillpassword("1234");
        loginpage.clickBtnSubmitLogin();
        String alert = getAlertText();
        String expectedText = "User does not exist.";
        assertEquals(expectedText, alert);
        endTest();
    }

    @Test
    public void testInvalidPassword(){
        startTest();
        homepage.clickMenuLogin();
        sleepTest(false);
        loginpage.fillEmail("euluizteste");
        loginpage.fillpassword("azul");
        loginpage.clickBtnSubmitLogin();
        String alert = getAlertText();
        String expectedText = "Wrong password.";
        assertEquals(expectedText, alert);
        endTest();
    }

    @Test
    public void testBlankField(){
        startTest();
        homepage.clickMenuLogin();
        sleepTest(false);
        loginpage.fillEmail("");
        loginpage.fillpassword("");
        loginpage.clickBtnSubmitLogin();
        String alert = getAlertText();
        String expectedText = "Please fill out Username and Password.";
        assertEquals(expectedText, alert);
        endTest();
    }

    @Test
    public void realizarCompra(){
        startTest();
        login("euluizteste", "1234");
        selectNokia("//*[@id=\"tbodyid\"]/div[2]/div/a");
        verifyAlertText("Product added.");
        goToCart();
        placeOrder("luiz", "brazil", "salvador", "0000-0000", "september", "2024");
        endTest();
    }

    @Test
    public void carItemsRemove(){
        startTest();
        login("euluizteste", "1234");
        selectProduct("//*[@id=\"tbodyid\"]/div[2]/div/a");
        goToCart();
        calm();
        cartpage.clickDeleteNote();
        calm();
        placeOrder("luiz", "brazil", "salvador", "0000-0000", "september", "2024");
        endTest();
    }


    //Functions

    private void selectProduct(String addCartXpath) {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(15));
        calm();
        homepage.clickLinkNokia();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addCartXpath)));
        productpage.clickAddCart();
        verifyAlertText("Product added.");
        productpage.clickNavbarHome();

        calm();
        homepage.clickLinkNote();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addCartXpath)));
        productpage.clickAddCart();
        verifyAlertText("Product added.");
        productpage.clickNavbarHome();

        homepage.clickMonitorBttn();
        calm();
        homepage.clickLinkMonitor();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addCartXpath)));
        productpage.clickAddCart();
        verifyAlertText("Product added.");
        productpage.clickNavbarHome();
    }

    private void login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(5));
        homepage.clickMenuLogin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        loginpage.fillEmail(email);
        loginpage.fillpassword(password);
        loginpage.clickBtnSubmitLogin();
    }

    private void selectNokia(String addCartXpath) {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(15));
        calm();
        homepage.clickLinkNokia();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addCartXpath)));
        productpage.clickAddCart();
    }

    private void verifyAlertText(String expectedText) {
        String alertText = getAlertText();
        assertEquals(expectedText, alertText);
        Alert alert = getCurrentDriver().switchTo().alert();
        alert.accept();
        getCurrentDriver().switchTo().defaultContent();
    }

    private void goToCart() {productpage.clickNavbarCart();}

    private void placeOrder(String name, String country, String city, String card, String month, String year) {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(5));
        cartpage.clickPlaceOrder();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        cartpage.fillName(name);
        cartpage.fillCountry(country);
        cartpage.fillCity(city);
        cartpage.fillCard(card);
        cartpage.fillMonth(month);
        cartpage.fillYear(year);
        cartpage.clickSubmitPurchase();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[10]/div[7]/div/button")));
        cartpage.clickOkButton();
    }

}
