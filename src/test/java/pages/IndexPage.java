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
        LoggerUtility.infoLog("User-ul a accesat meniul Alerte ");
    }
    public void clickOnFormMenu() {
        elementHelper.clickJSLocator(IndexLocators.formElement);
        LoggerUtility.infoLog("User-ul a accesat meniul Form");
    }

    public void clickOnIFrameMenu() {
        elementHelper.clickJSLocator(IndexLocators.iframeElement);
        LoggerUtility.infoLog("TUser-ul a accesat meniul IFrame");
    }





}
