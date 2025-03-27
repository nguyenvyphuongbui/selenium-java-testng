package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
        driver.manage().window().maximize();
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
    @Test
    public void TC_03_Selected(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.cssSelector("input#under_18")).click();
        driver.findElement(By.cssSelector("input#java")).click();

        if(driver.findElement(By.cssSelector("input#under_18")).isSelected()){
            System.out.println("Age Under 18 radio button is selected.");
        }else{
            System.out.println("Age Under 18 radio button is deselected.");
        }

        if(driver.findElement(By.cssSelector("input#java")).isSelected()){
            System.out.println("Java checkbox is selected.");
        }else{
            System.out.println("Java checkbox is deselected.");
        }
    }

    @Test
    public void TC_04_Mailchimp_Validate() throws InterruptedException {
        driver.get("https://login.mailchimp.com/signup/");

        driver.findElement(By.cssSelector("input#email")).sendKeys("nguyen@gmail.com");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();

        Thread.sleep(3000);

        //If password is empty
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());


        //If password is lowercase
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("bella");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());


        //If password is uppercase
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("BELLA");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());


        //If password is numbers
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());


        //If password is special characters
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("!!@@##");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());


        //If password contains username
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("Nguyenbui");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());


        //If password meets all conditions
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("Bella@123");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Thread.sleep(3000);

        Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        Assert.assertFalse(driver.findElement(By.cssSelector("input#marketing_newsletter")).isSelected());
    }
    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
