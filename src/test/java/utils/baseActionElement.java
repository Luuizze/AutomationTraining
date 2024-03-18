package utils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class baseActionElement {
    //Metodo para avaliar se existe um elemento
    public boolean isElementExisting(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch(NoSuchElementException e) {
            return false;
        }
    }
    // Método para clicar em um elemento
    public void clickElement(WebElement element) {
        if (isElementExisting(element)) {
            element.click();
        }
    }

    // Método para preencher um campo de texto
    public void fillTextField(WebElement element, String text) {
        if (isElementExisting(element)) {
            element.sendKeys(text);
        }
    }

    // Método para obter o texto de um elemento
    public String getElementText(WebElement element) {
        if (isElementExisting(element)) {
            return element.getText();
        }
        return null;
    }

    // Método para verificar se um elemento está habilitado
    public boolean isElementEnabled(WebElement element) {
        if (isElementExisting(element)) {
            return element.isEnabled();
        }
        return false;
    }

}
