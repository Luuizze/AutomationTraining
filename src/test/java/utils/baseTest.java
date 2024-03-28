package utils;

import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static utils.browser.getCurrentDriver;

public class baseTest {

    //Método para iniciar o teste
    @Before
    public void startTest() {
        getCurrentDriver();
    }

    // Método para finalizar o teste
    @After
    public void endTest() {
        if (getCurrentDriver() != null) {
            getCurrentDriver().quit();
        }
    }

    // Método para testar a abertura de uma página
    @Test
    public void openPageTest() {
        getCurrentDriver().get("https://www.demoblaze.com/");
        assertEquals("https://www.demoblaze.com/", getCurrentDriver().getCurrentUrl());
    }

    public String getAlertText(){
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = getCurrentDriver().switchTo().alert();
        return alert.getText();
    }

    public String getCurrentUrl(){
        return getCurrentDriver().getCurrentUrl();
    }

    public void sleepTest(boolean IorE){
        if(IorE){ //Implicit Wait: Global, na vida útil do WebDriver
            getCurrentDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }else{ //Explicit Wait: Pra um elemento especifico
            WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xpath = \"//h4[@class='card-title']/a[contains(@class, 'hrefch') and contains(@href, 'prod.html?idp=2')]\"")));
        }
    }

    public void calm(){
        try {
            // Pausa a execução da thread atual por 5 segundos
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Trata a exceção InterruptedException
            e.printStackTrace();
        }
    }
}
