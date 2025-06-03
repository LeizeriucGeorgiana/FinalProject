package pages;

import helperMethod.AlertHelper;
import helperMethod.ElementHelper;
import locators.AlertLocators;
import loggerUtility.LoggerUtility;
import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertPage {

    private WebDriver driver;
    private AlertHelper alertHelper;
    private ElementHelper elementHelper;

    public static final String PROMPT_INPUT_TEXT = "Textul introdus de Georgiana";

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        this.alertHelper = new AlertHelper(driver);
        this.elementHelper = new ElementHelper(driver);
    }

    public void triggerSimpleAlert() {
        LoggerUtility.infoLog("Se încearcă deschiderea simple alert.");
        elementHelper.clickLocator(AlertLocators.alertOkElement);
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("Simple alert a fost deschisă și acceptată cu succes.");
    }

    public void triggerConfirmAlertAndCancel() {
        LoggerUtility.infoLog("S-a deschis confirmare alerta.");
        elementHelper.clickLocator(AlertLocators.alertConfirmElement);
        alertHelper.cancelAlert();
        LoggerUtility.infoLog("Confirmare alerta a fost deschisă și s-a dat Cancel.");
    }

    public void triggerPromptAlert(String input) {
        LoggerUtility.infoLog("S-a deschis prompt alert cu input: " + input);
        elementHelper.clickLocator(AlertLocators.alertPromptElement);
        alertHelper.waitForAlert();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(input);
        alert.accept();
        LoggerUtility.infoLog("Prompt alert a fost deschisă, textul introdus și alerta a fost acceptată.");
    }

    public String getAlertMessage() {
        return elementHelper.getTextFromElement(AlertLocators.alertSimpleResult);
    }

    public String getConfirmMessage() {
        return elementHelper.getTextFromElement(AlertLocators.alertConfirmResult);
    }

    public String getPromptMessage() {
        return elementHelper.getTextFromElement(AlertLocators.alertPromptResult);
    }

    public void assertSimpleAlertHandled() {
        Assert.assertTrue(
                getAlertMessage().contains("You triggered and handled"),
                "Mesajul alert simplu este greșit"
        );
    }

    public void assertConfirmAlertCanceled() {
        Assert.assertEquals("false", getConfirmMessage());
    }

    public void assertPromptAlertInput(String expectedText) {
        Assert.assertEquals(expectedText, getPromptMessage());
    }
}