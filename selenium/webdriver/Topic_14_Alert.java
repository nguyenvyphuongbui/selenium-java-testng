package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_14_Alert {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Accept_Alert() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);

        //Wait alert to appear in html then switch to
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(alert.getText(), "I am a JS Alert");

        alert.accept();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked an alert successfully");

    }

    @Test
    public void TC_02_Confirm_Alert() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        alert.dismiss();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked: Cancel");

    }

    @Test
    public void TC_03_Prompt_Alert() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(alert.getText(), "I am a JS prompt");

        String name = "Bella";

        alert.sendKeys(name);
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You entered: " + name);
    }

    @Test
    public void TC_04_Authentication_Alert() throws InterruptedException {
        String username = "admin";
        String password = "admin";
        String url = "http://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";

        driver.get(url);
        Thread.sleep(2000); // Replace with proper wait ideally

        Assert.assertEquals(
                driver.findElement(By.cssSelector("div.example > p")).getText(),
                "Congratulations! You must have the proper credentials.");
    }
    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
