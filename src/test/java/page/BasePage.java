package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;


public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }
    //Wait wrapper method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    //Click method
    public void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }
    //Is Element Displayed
    public void isElementDisplayed(By elementBy) {
        waitVisibility(elementBy);
        assertTrue(driver.findElement(elementBy).isDisplayed());
    }
    public void waitForFilling(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    //Write Text in field located By
    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        WebElement element = driver.findElement(elementBy);
        element.clear();
        element.sendKeys(text);
    }

    public void isElementNotDisplayed(By elementBy) {
        assertFalse(driver.findElements(elementBy).size() > 0);
    }

    public void isAlertText(String message) {
        assertEquals(message, driver.switchTo().alert().getText());
    }
}
