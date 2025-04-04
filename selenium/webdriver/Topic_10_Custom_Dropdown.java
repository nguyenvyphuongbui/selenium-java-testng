package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

    @Test
    public void TC_02_React_Semantic() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInDropdown("div.dropdown","div.item span.text","Elliot Fu");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Elliot Fu");

        selectItemInDropdown("div.dropdown","div.item span.text","Christian");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Christian");
    }

    @Test
    public void TC_03_VueJS() throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInDropdown("li.dropdown-toggle","ul.dropdown-menu  a","First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "First Option");

        selectItemInDropdown("li.dropdown-toggle","ul.dropdown-menu  a","Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");

        selectItemInDropdown("li.dropdown-toggle","ul.dropdown-menu  a","Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Third Option");
    }

    @Test
    public void TC_04_Editable() throws InterruptedException {
        driver.get("https://id5.cloud.huawei.com/CAS/portal/userRegister/regbyemail.html");

        selectItemInHuaweiDropdown("div[ht='input_emailregister_dropdown']","input[ht='input_emailregister_search']"
                ,"ul.hwid-alpla-list span", "Vietnam");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[ht='input_emailregister_dropdown")).getText(), "Vietnam");

        selectItemInHuaweiDropdown("div[ht='input_emailregister_dropdown']","input[ht='input_emailregister_search']"
                ,"ul.hwid-alpla-list span", "Australia");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[ht='input_emailregister_dropdown")).getText(), "Australia");

    }


    private void selectItemInDropdown(String parentLocator, String childLocator, String textItem) throws InterruptedException {
        driver.findElement(By.cssSelector(parentLocator)).click();
        Thread.sleep(2000);

        //Wait till all items get loaded
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));

        //Save them to a list
        List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));

        //Check each item
        for (WebElement item : allItems){
            if (item.getText().equals(textItem)){
                item.click();
                break;
            }
        }
    }

    private void selectItemInEditableDropdown(String parentLocator, String childLocator, String textItem) throws InterruptedException {
        driver.findElement(By.cssSelector(parentLocator)).clear();
        driver.findElement(By.cssSelector(parentLocator)).sendKeys(textItem);
        Thread.sleep(2000);

        //Wait till all items get loaded
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));

        //Save them to a list
        List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));

        //Check each item
        for (WebElement item : allItems){
            if (item.getText().equals(textItem)){
                item.click();
                break;
            }
        }
    }

    private void selectItemInHuaweiDropdown(String parentLocator, String editableLocator, String childLocator, String textItem) throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentLocator)));
        driver.findElement(By.cssSelector(parentLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector(editableLocator)).clear();
        driver.findElement(By.cssSelector(editableLocator)).sendKeys(textItem);
        Thread.sleep(2000);

        //Wait till all items get loaded
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));

        //Save them to a list
        List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));

        //Check each item
        for (WebElement item : allItems){
            if (item.getText().equals(textItem)){
                item.click();
                break;
            }
        }
    }


    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
