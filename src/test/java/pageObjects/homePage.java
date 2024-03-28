package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.baseActionElement;
import utils.browser;

public class homePage extends baseActionElement {
        @FindBy(id="signin2")
        public WebElement signin;
        @FindBy(id="login2")
        public WebElement login;
        @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a")
        public WebElement nokiaLinkItem;
        @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[8]/div/div/h4/a")
        public WebElement noteLinkItem;
        @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a")
        public WebElement MonitorLinkItem;
        @FindBy(xpath = "//*[@id=\"itemc\"][3]")
        public WebElement MonitorBttn;

        public boolean getNokiaLinkItemExist() {
                if(isElementExisting(nokiaLinkItem)){
                        return true;
                }
                return false;
        }


        public homePage() {
                PageFactory.initElements(browser.getCurrentDriver(), this);
        }

        public void clickMenuLogin() {
                login.click();
        }

        public void clickMenuSignIn() {
                signin.click();
        }

        public void clickLinkNokia(){nokiaLinkItem.click();}
        public void clickLinkNote(){noteLinkItem.click();}
        public void clickLinkMonitor(){MonitorLinkItem.click();}
        public void clickMonitorBttn(){MonitorBttn.click();}
}

