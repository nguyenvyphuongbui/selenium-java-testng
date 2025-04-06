package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Checkbox_Radio {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_KendoUI_Checkbox() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        Thread.sleep(3000);

        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.xpath("//div[@id='demo-runner']")));
        Thread.sleep(2000);

        //Click to select the checkbox
        if(!driver.findElement(dualZoneCheckbox).isSelected()) {
            driver.findElement(dualZoneCheckbox).click();
            Thread.sleep(2000);
        }

        //Verify if the checkbox is selected
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());

        //Click to deselect
        if(driver.findElement(dualZoneCheckbox).isSelected()) {
            driver.findElement(dualZoneCheckbox).click();
            Thread.sleep(2000);
        }

        //Verify if the checkbox is deselected
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());
    }

    @Test
    public void TC_02_Select_All() {
        driver.get("https://automationfc.github.io/multiple-fields/");

        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));

        //Select all checkboxes
        for (WebElement checkbox : allCheckboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }

        //Verify all checkboxes are selected
        for (WebElement checkbox : allCheckboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }

        //Deselect all checkboxes
        for (WebElement checkbox : allCheckboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }

        //Verify all checkboxes are deselected
        for (WebElement checkbox : allCheckboxes) {
            Assert.assertFalse(checkbox.isSelected());
        }

        //Select/Deselect 1 item in all items
        for (WebElement checkbox : allCheckboxes) {
            if (checkbox.getAttribute("value").equals("Asthma") && !checkbox.isSelected()) {
                checkbox.click();
            }
        }

        //Verify that item
        for (WebElement checkbox : allCheckboxes) {
            if (checkbox.getAttribute("value").equals("Asthma")) {
                Assert.assertTrue(checkbox.isSelected());
            }

        }
    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
