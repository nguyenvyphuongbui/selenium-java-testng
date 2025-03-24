package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;


public class Topic_04_Register {
    WebDriver driver;


    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void TC_01_Empty_Data() {
        driver.get("https://practice.expandtesting.com/register");


        driver.findElement(By.xpath("//button[text()='Register']")).click();


        Assert.assertEquals(driver.findElement(By.id("flash")).getText(),"All fields are required.");


    }


    @Test
    public void TC_02_Invalid_Password() {
        driver.get("https://practice.expandtesting.com/register");


        driver.findElement(By.id("username")).sendKeys("Bella");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("confirmPassword")).sendKeys("123");


        driver.findElement(By.xpath("//button[text()='Register']")).click();


        Assert.assertEquals(driver.findElement(By.id("flash")).getText(),"Password must be at least 4 characters long.");


    }


    @Test
    public void TC_03_Incorrect_Confirm_Password() {
        driver.get("https://practice.expandtesting.com/register");


        driver.findElement(By.id("username")).sendKeys("Bella");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("confirmPassword")).sendKeys("54321");


        driver.findElement(By.xpath("//button[text()='Register']")).click();


        Assert.assertEquals(driver.findElement(By.id("flash")).getText(),"Passwords do not match.");


    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }


}
