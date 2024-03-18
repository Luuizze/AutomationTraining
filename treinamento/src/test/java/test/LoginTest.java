package test;

import pageObjects.homePage;
import pageObjects.loginPage;
import utils.baseTest;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;


public class LoginTest extends baseTest {
    private final loginPage loginpage = new loginPage();
    private final homePage homepage = new homePage();

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
        loginpage.sleepTest(false);
        loginpage.fillEmail("euluizteste");
        loginpage.fillpassword("1234");
        loginpage.clickBtnSubmitLogin();
        endTest();
    }

    @Test
    public void testInvalidUsername(){
        startTest();
        homepage.clickMenuLogin();
        loginpage.sleepTest(false);
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
        loginpage.sleepTest(false);
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
        loginpage.sleepTest(false);
        loginpage.fillEmail("");
        loginpage.fillpassword("");
        loginpage.clickBtnSubmitLogin();
        String alert = getAlertText();
        String expectedText = "Please fill out Username and Password.";
        assertEquals(expectedText, alert);
        endTest();
    }

}
