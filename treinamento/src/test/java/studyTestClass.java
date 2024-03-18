import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class studyTestClass {

    @Test
    public void testGoogle() { //Teste de entrada no site
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        //driver.quit();
    }
    @Test
    public void testOpenWindow(){ //Teste de entrada com argumento
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.demoblaze.com/");
    }

    //DOM (Document Object Model)
    @Test
    public void testSearchIdLogin(){ //busca elemento
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.demoblaze.com/");
        driver.findElement(By.id("loginusername"));
    }

    @Test
    public void testMapingElements(){ //busca elemento pelo xpath
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.demoblaze.com/");
        WebElement username = driver.findElement(By.id("loginusername"));
        WebElement password = driver.findElement(By.id("loginpassword"));
        WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[1]"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
    }

    @Test
    public void testSeleniumFeatures(){
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.demoblaze.com/");
        driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();

        //Implicit Wait: Global, na vida útil do WebDriver
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Explicit Wait: Pra um elemento especifico
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginusername\"]")));

        driver.findElement(By.id("loginusername")).sendKeys("euluizteste");
        driver.findElement(By.id("loginpassword")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
    }

    @Test
    public void testValidLogin() {
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.demoblaze.com/");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login2\"]"));
        loginButton.click();
        WebElement username = driver.findElement(By.id("loginusername"));
        WebElement password = driver.findElement(By.id("loginpassword"));
        WebElement loginBt = driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginusername\"]")));

        username.sendKeys("euluizteste");
        password.sendKeys("1234");
        loginBt.click();
    }

    @Test
    public void testInvalidUsername() {
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.demoblaze.com/");
        driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();

        //String originalWindow = driver.getWindowHandle();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("loginusername")).sendKeys("azulino");
        driver.findElement(By.id("loginpassword")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedText = "User does not exist.";
        assertEquals(expectedText, alertText);

        //driver.quit();
    }

    @Test
    public void testInvalidPassword() {
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.demoblaze.com/");
        driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("loginusername")).sendKeys("euluizteste");
        driver.findElement(By.id("loginpassword")).sendKeys("senhaerrada");
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedText = "Wrong password.";
        assertEquals(expectedText, alertText);

        //driver.quit();
    }

    @Test
    public void testBlankField() {
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.demoblaze.com/");
        driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("loginusername")).sendKeys("");
        driver.findElement(By.id("loginpassword")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedText = "Please fill out Username and Password.";
        assertEquals(expectedText, alertText);

        //driver.quit();
    }





}