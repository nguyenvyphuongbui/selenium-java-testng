package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_02_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_ID() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        driver.findElement(By.id("input-email"));

    }

    @Test
    public void TC_02_Class() {
        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
        driver.findElement(By.className("btn-dark"));
    }

    @Test
    public void TC_03_Name() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        driver.findElement(By.name("email"));
    }

    @Test
    public void TC_04_Linktext() {
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.findElement(By.linkText("Ajax Form Submit"));
    }

    @Test
    public void TC_05_Partial_Linktext() {
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.findElement(By.partialLinkText("Healing"));
    }

    @Test
    public void TC_06_Tagname() {
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.findElement(By.tagName("a"));
    }

    @Test
    public void TC_07_Css() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

        //Css with tagname and ID
        driver.findElement(By.cssSelector("input[id='input-email']"));
        driver.findElement(By.cssSelector("#input-email"));
        driver.findElement(By.cssSelector("input#input-email"));

        //Css with tagname and Class
        driver.findElement(By.cssSelector("button[class='btn dropdown-toggle']"));
        driver.findElement(By.cssSelector("button.btn.dropdown-toggle")); //space replaced by dot
        driver.findElement(By.cssSelector(".btn.dropdown-toggle"));

        //Css with tagname and Link (not linktext)
        driver.findElement(By.cssSelector("a[href='https://ecommerce-playground.lambdatest.io/index.php?route=account/login']"));

        //Css with tagname and partial Link
        driver.findElement(By.cssSelector("a[href^='https://ecommerce-playground.lambdatest.io/']"));
        driver.findElement(By.cssSelector("a[href*='io/index.php?route=account']"));
        driver.findElement(By.cssSelector("a[href$='/index.php?route=account/login']"));
    }

    @Test
    public void TC_08_Xpath() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

        //Standard Xpath
        driver.findElement(By.xpath("//input[@id='input-email']"));
        driver.findElement(By.xpath("//button[@class='btn dropdown-toggle']"));
        driver.findElement(By.xpath("//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/login']"));

        //Xpath contains
        //tagname[contains(@attribute, 'partial value of attribute')]
        driver.findElement(By.xpath("//input[contains(@class, 'form-control')]"));

        //Xpath starts-with()
        //tagname[starts-with(@attribute,'starting name of the attribute value')]
        driver.findElement(By.xpath("//input[starts-with(@name,'pass')]"));

        //XPath Using AND and OR
        driver.findElement(By.xpath("//input[@id='input-email' or @name='email']"));
        driver.findElement(By.xpath("//input[@id='input-email' and @name='email']"));

        //Xpath text
        driver.findElement(By.xpath("//a[text()='Continue']"));

   }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
