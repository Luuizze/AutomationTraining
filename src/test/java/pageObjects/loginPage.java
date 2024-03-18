package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.baseActionElement;
import utils.browser;

import java.time.Duration;

import static utils.browser.getCurrentDriver;

public class loginPage extends baseActionElement {

    @FindBy(xpath = "//*[@id=\"loginusername\"]")
    public WebElement usernameLog;

    @FindBy(xpath = "//*[@id=\"loginpassword\"]")
    public WebElement passwordLog;

    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
    public WebElement submitLogin;

    public loginPage() {
        PageFactory.initElements(browser.getCurrentDriver(), this);
    }

    // Método para preencher o campo de email
    public void fillEmail(String username) {
        fillTextField(usernameLog, username);
    }

    // Método para preencher o campo de senha
    public void fillpassword(String password) {
        fillTextField(passwordLog, password);
    }

    // Método para clicar no botão de login
    public void clickBtnSubmitLogin() {
        clickElement(submitLogin);
    }

    public void sleepTest(boolean IorE){
        if(IorE){ //Implicit Wait: Global, na vida útil do WebDriver
            getCurrentDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }else{ //Explicit Wait: Pra um elemento especifico
            WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginusername\"]")));
        }
    }

}

