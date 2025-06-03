package pages;
import helperMethod.AlertHelper;
import helperMethod.ElementHelper;
import helperMethod.FormHelper;
import helperMethod.IFramesHelper;
import loggerUtility.LoggerUtility;
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
        LoggerUtility.infoLog("AlertHelper initialized");
        elementHelper=new ElementHelper(driver);
        LoggerUtility.infoLog("ElementHelper initialized");
        formHelper=new FormHelper(driver);
        LoggerUtility.infoLog("FormHelper initialized");
        iframeHelper=new IFramesHelper(driver);
        LoggerUtility.infoLog("IframeHelper initialized");
    }
 }
