package pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.baseActionElement;
import utils.browser;

public class loginPage extends baseActionElement {

    @FindBy(id = "loginusername")
    public WebElement usernameLog;

    @FindBy(id="loginpassword")
    public WebElement passwordLog;

    @FindBy(xpath = "//button[contains(@class, 'btn') and contains(@class, 'btn-primary') and contains(text(), 'Log in')]")
    public WebElement submitLogin;

    @FindBy(xpath = "//button[contains(@class, 'btn') and contains(@class, 'btn-secondary') and contains(text(), 'Close')]")
    public WebElement submitClose;

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

    public void doLogin(String username, String password) {
        fillTextField(usernameLog, username);
        fillTextField(passwordLog, password);
        clickBtnSubmitLogin();
    }

}

