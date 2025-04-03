package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_10_Custom_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_JQuery() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        selectItemInDropdown("span#speed-button","ul#speed-menu div", "Medium");
        selectItemInDropdown("span#speed-button","ul#speed-menu div", "Slow");
        selectItemInDropdown("span#speed-button","ul#speed-menu div", "Fast");
    }

    private void selectItemInDropdown(String parentLocator, String childLocator, String textItem) throws InterruptedException {
        //driver.findElement(By.cssSelector()).click();
        driver.findElement(By.cssSelector(parentLocator)).click();
        Thread.sleep(2000);

        //Wait till all items get loaded
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));

        //Save them to a list
        List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));
        //List<WebElement> allItems = driver.findElements(By.cssSelector("ul#speed-menu div"));

        //Check each item
        for (WebElement item : allItems){
            if (item.getText().equals(textItem)){
                item.click();
                break;
            }
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
