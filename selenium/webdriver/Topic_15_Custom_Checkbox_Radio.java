package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_15_Custom_Checkbox_Radio {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Ubuntu() throws InterruptedException {
        driver.get("https://login.ubuntu.com/");
        Thread.sleep(3000);

        By registerRadio = By.cssSelector("input#id_new_user");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(registerRadio));
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(registerRadio).isSelected());

        By termCheckbox = By.cssSelector("input#id_accept_tos");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(termCheckbox));
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(termCheckbox).isSelected());
    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
