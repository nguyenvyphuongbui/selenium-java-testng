package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_09_Default_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        //Turn off pop up of location permission
        FirefoxOptions option = new FirefoxOptions();
        option.addPreference("geo.enabled", false);
        option.addPreference("geo.provider.use_corelocation", false);
        driver = new FirefoxDriver(option);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Rode() throws InterruptedException {
        driver.get("https://rode.com/en/support/where-to-buy");

        new Select(driver.findElement(By.cssSelector("select#country"))).selectByVisibleText("Vietnam");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input#map_search_query")).sendKeys("Ho Chi Minh");
        driver.findElement(By.xpath("//button[text()='Search']")).click();
        Thread.sleep(3000);

        //Verify - there are 16 dealers
        List<WebElement> dealerBranches = driver.findElements(By.cssSelector("div.dealer_branch h4"));
        Assert.assertEquals(dealerBranches.size(),16);

        //Print dealer names
        for(WebElement dealerName: dealerBranches){
            System.out.println(dealerName.getText());
        }


    }

    @Test
    public void TC_02_() {

    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
