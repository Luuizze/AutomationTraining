package pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.baseActionElement;
import utils.browser;

public class productPage extends baseActionElement {
    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[2]/div/a")
    public WebElement addToCartButton;

    @FindBy(id="cartur")
    public WebElement navbarCart;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[1]/a")
    public WebElement navbarHome;
    public productPage() {
        PageFactory.initElements(browser.getCurrentDriver(), this);
    }

    public void clickAddCart(){addToCartButton.click();}
    public void clickNavbarCart(){navbarCart.click();}
    public void clickNavbarHome(){navbarHome.click();}

}
