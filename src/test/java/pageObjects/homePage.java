package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.baseActionElement;
import utils.browser;

public class homePage extends baseActionElement {
        @FindBy(xpath = "//*[@id=\"signin2\"]")
        public WebElement signin;
        @FindBy(xpath = "//*[@id=\"login2\"]")
        public WebElement login;

        public homePage() {
                PageFactory.initElements(browser.getCurrentDriver(), this);
        }

        public void clickMenuLogin() {
                login.click();
        }

        public void clickMenuSignIn() {
                signin.click();
        }

}

