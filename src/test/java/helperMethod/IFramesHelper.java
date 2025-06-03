package helperMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFramesHelper {
    private WebDriver driver;
    private static final By BODY = By.tagName("body");

    public IFramesHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToIframeById(String iframeId) {
        driver.switchTo().frame(iframeId);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public String getBodyText() {
        WebElement body = driver.findElement(BODY);
        return body.getText();
    }

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }
}