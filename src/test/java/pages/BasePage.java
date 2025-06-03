package pages;
import helperMethod.AlertHelper;
import helperMethod.ElementHelper;
import helperMethod.FormHelper;
import helperMethod.IFramesHelper;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    protected AlertHelper alertHelper;
    protected ElementHelper elementHelper;
    protected FormHelper formHelper;
    protected IFramesHelper iframeHelper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        alertHelper = new AlertHelper(driver);
        elementHelper = new ElementHelper(driver);
        formHelper = new FormHelper(driver);
        iframeHelper = new IFramesHelper(driver);
    }
}