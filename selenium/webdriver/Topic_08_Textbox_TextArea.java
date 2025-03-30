package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_08_Textbox_TextArea {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_TechPanda() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        String firstName = "John";
        String lastName = "Smith";
        String fullName = firstName + " " + lastName;
        String email = "johnsmith" + new Random().nextInt(9999) + "@gmail.com";
        String password = "1234567";
        String thoughtReview = "Best phone\nBest Provide\nBest Product";
        String summaryReview = "Hot Phone";
        String nickName = "johnny";

        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("email_address")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmation")).sendKeys(password);

        driver.findElement(By.cssSelector("button[title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Thank you for registering with Main Website Store.");

        String contactInfo = driver.findElement(
                By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div")).getText();

        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(email));

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();

        driver.findElement(By.cssSelector("input[id='Quality 1_5']")).click();
        driver.findElement(By.cssSelector("textarea#review_field")).sendKeys(thoughtReview);
        driver.findElement(By.cssSelector("input#summary_field")).sendKeys(summaryReview);
        driver.findElement(By.cssSelector("input#nickname_field")).clear();
        driver.findElement(By.cssSelector("input#nickname_field")).sendKeys(nickName);
        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Your review has been accepted for moderation.");
    }

    @Test
    public void TC_02_OrangeHRM() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String firstName = "John";
        String lastName = "Smith";
        String userName = "john" + new Random().nextInt(9999);

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(lastName);

        String employeeID = driver.findElement(
                By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"))
                .getAttribute("value");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text()=' Save ']")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getAttribute("value"), lastName);

        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        driver.findElement(
                By.xpath("//h6[text()='Assigned Immigration Records']/parent::div//button[text()=' Add ']")).click();

        String passportNumber = "111-222-333";

        driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input"))
                .sendKeys(passportNumber);
        driver.findElement(By.xpath("//button[text()=' Save ']")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input"))
                .getAttribute("value"), passportNumber);

    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
