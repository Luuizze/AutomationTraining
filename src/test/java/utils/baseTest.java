package utils;

import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.Alert;
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

}
