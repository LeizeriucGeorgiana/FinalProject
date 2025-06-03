package tests;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.IndexPage;
import shareData.ShareData;
@Feature("Alerts Feature")
public class AlertTest extends ShareData {

    @Test (groups = {TestSuite.REGRESSION_SUITE, TestSuite.ALERT_FRAME_SUITE})
    public void testJavaScriptAlerts() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnAlertMenu();

        AlertPage alertPage = new AlertPage(getDriver());

        alertPage.triggerSimpleAlert();
        alertPage.assertSimpleAlertHandled();

        alertPage.triggerConfirmAlertAndCancel();
        alertPage.assertConfirmAlertCanceled();

        alertPage.triggerPromptAlert(AlertPage.PROMPT_INPUT_TEXT);
        alertPage.assertPromptAlertInput(AlertPage.PROMPT_INPUT_TEXT);
    }
}