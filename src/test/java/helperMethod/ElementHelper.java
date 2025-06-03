package helperMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementHelper {

    private WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    private void waitForVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitForVisible(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }
    public void clickJSLocator(By locator) {
        waitForVisible(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(locator));
    }

    public void clickLocator(By locator) {
        waitForVisible(locator);
        driver.findElement(locator).click();
    }

    public String getTextFromElement(By locator) {
        waitForVisible(locator);
        return driver.findElement(locator).getText();
    }


}
