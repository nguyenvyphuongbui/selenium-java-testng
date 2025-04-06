package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_11_Button {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Button() throws InterruptedException {
        By registerButton = By.cssSelector("button.fhs-btn-register");
        By loginButton = By.cssSelector("button.fhs-btn-login");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();

        //Verify Register button is disabled
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());

        //Verify button color when disabled
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).
                getCssValue("background-color")).asHex().toUpperCase(),"#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("bella@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456789");
        Thread.sleep(2000);

        //Verify Register button is enabled
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());

        //Verify button color when enabled
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).
                getCssValue("background-color")).asHex().toUpperCase(),"#C92127");
    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
