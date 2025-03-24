package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_05_Browser_Element {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Page_Url() {
        driver.get("https://live.techpanda.org/");

        //Click on My Account at Footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/login/");

        //Click to navigate to Register page
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/create/");

    }

    @Test
    public void TC_02_Page_Title() {
        driver.get("https://live.techpanda.org/");

        //Click on My Account at Footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        Assert.assertEquals(driver.getTitle(), "Customer Login");

        //Click to navigate to Register page
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

    }

    @Test
    public void TC_03_Navigation() {
        driver.get("https://live.techpanda.org/");

        //Click on My Account at Footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        //Click to navigate to Register page
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/create/");

        //Back to previous page
        driver.navigate().forward();

        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

    }

    @Test
    public void TC_04_Page_Source() {
        driver.get("https://live.techpanda.org/");

        //Click on My Account at Footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        //Click to navigate to Register page
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));


    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
