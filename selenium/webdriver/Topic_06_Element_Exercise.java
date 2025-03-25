package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06_Element_Exercise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if(driver.findElement(By.cssSelector("input#mail")).isDisplayed()){
            driver.findElement(By.cssSelector("input#mail")).sendKeys("Automation Testing");
            System.out.println("Email textbox is displayed.");
        }else{
            System.out.println("Email textbox is not displayed.");
        }

        if(driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()){
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("Automation Testing");
            System.out.println("Education textarea is displayed.");
        }else{
            System.out.println("Education textarea is not displayed.");
        }

        if(driver.findElement(By.cssSelector("input#under_18")).isDisplayed()){
            driver.findElement(By.cssSelector("input#under_18")).click();
            System.out.println("Age Under 18 Radio button is displayed.");
        }else {
            System.out.println("Age Under 18 Radio button is not displayed.");
        }


        if(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()){
            driver.findElement(By.cssSelector("//h5[text()='Name: User5']/following-sibling::a")).click();
            System.out.println("Name User5 Text is displayed.");
        }else {
            System.out.println("Name User5 Text is not displayed.");
        }

    }

    @Test
    public void TC_02_Enabled_Disabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if(driver.findElement(By.cssSelector("input#mail")).isEnabled()){
            System.out.println("Email textbox is enabled.");
        }else{
            System.out.println("Email textbox is disabled.");
        }

        if(driver.findElement(By.cssSelector("input#disable_password")).isEnabled()){
            System.out.println("Password textbox is enabled.");
        }else{
            System.out.println("Password textbox is disabled.");
        }

        if(driver.findElement(By.cssSelector("input#slider-2")).isEnabled()){
            System.out.println("Slider is enabled.");
        }else{
            System.out.println("Slider is disabled.");
        }
    }


    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
