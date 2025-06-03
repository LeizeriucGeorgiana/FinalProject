package pages;

import locators.IndexLocators;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;

public class IndexPage extends BasePage {

    public IndexPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnAlertMenu() {
        elementHelper.clickJSLocator(IndexLocators.alertsElement);
        LoggerUtility.infoLog("The user clicks on Alert Menu");
    }
    public void clickOnFormMenu() {
        elementHelper.clickJSLocator(IndexLocators.formElement);
        LoggerUtility.infoLog("The user clicks on From Menu");
    }

    public void clickOnIFrameMenu() {
        elementHelper.clickJSLocator(IndexLocators.iframeElement);
        LoggerUtility.infoLog("The user clicks on IFrame Menu");
    }





}
