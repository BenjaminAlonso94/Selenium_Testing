package challenge.ui.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;

public class DriverHelper {
    public WebDriver driver;

    public DriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeys(By elem, String key) {
        fluentWait(elem);
        driver.findElement(elem).sendKeys(key);
    }

    public String getText(By elem) {
        fluentWait(elem);
        return driver.findElement(elem).getText();
    }

    public void click(By elem) {
        fluentWait(elem);
        driver.findElement(elem).click();
    }

    public void verifyElementIsDisplayed(By elem) {
        fluentWait(elem);
        assertEquals(driver.findElement(elem).isDisplayed(), true);
    }

    public void selectData(By elem, String value) {
        fluentWait(elem);
        Select selectElem = new Select(driver.findElement(elem));
        selectElem.selectByValue(value);
    }

    public void fluentWait(By element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
