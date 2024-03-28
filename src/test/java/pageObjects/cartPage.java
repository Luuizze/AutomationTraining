package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.baseActionElement;
import utils.browser;

public class cartPage extends baseActionElement {
    @FindBy(xpath = "//button[contains(@class, 'btn') and contains(@class, 'btn-success') and contains(text(), 'Place Order')]")
    public WebElement placeOrderButton;

    @FindBy(id="name")
    public WebElement namePurchase;
    @FindBy(id="country")
    public WebElement countryPurchase;
    @FindBy(id="city")
    public WebElement cityPurchase;
    @FindBy(id="card")
    public WebElement cardPurchase;
    @FindBy(id="month")
    public WebElement monthPurchase;
    @FindBy(id="year")
    public WebElement yearPurchase;
    @FindBy(xpath = "//button[contains(@class, 'btn') and contains(@class, 'btn-primary') and contains(text(), 'Purchase')]")
    public WebElement submitPurchase;
    @FindBy(xpath = "/html/body/div[10]/div[7]/div/button")
    public WebElement okButton;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/tr[1]/td[4]/a")
    public WebElement deleteNote;



    public cartPage() {
        PageFactory.initElements(browser.getCurrentDriver(), this);
    }

    public void clickPlaceOrder(){placeOrderButton.click();}

    public void fillName(String name) {
        fillTextField(namePurchase, name);
    }
    public void fillCountry(String country) {
        fillTextField(countryPurchase, country);
    }
    public void fillCity(String city) {
        fillTextField(cityPurchase, city);
    }
    public void fillCard(String card) {
        fillTextField(cardPurchase, card);
    }
    public void fillMonth(String month) {
        fillTextField(monthPurchase, month);
    }
    public void fillYear(String year) {
        fillTextField(yearPurchase, year);
    }

    public void clickSubmitPurchase(){submitPurchase.click();}
    public void clickOkButton(){okButton.click();}

    public void clickDeleteNote(){deleteNote.click();}
}
