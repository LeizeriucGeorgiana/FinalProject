package tests;

import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;
import pages.IndexPage;
import shareData.ShareData;
@Feature("Form Feature")
public class FormTest extends ShareData {

    @Test(groups = {TestSuite.REGRESSION_SUITE, TestSuite.FORM_SUITE})
    public void testFormSubmission() {
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnFormMenu();

        FormPage formPage = new FormPage(getDriver());
        formPage.completeUsernameAndPassword("geo_user", "parola123");
        formPage.completeComments("Acesta este un comentariu pentru test");
        formPage.uploadFile("src/test/resources/testfile.txt");
        formPage.selectCheckboxes();
        formPage.selectRadioButton3();
        formPage.selectMultipleItems();
        formPage.selectDropdownItem5();
        formPage.submitForm();
        Assert.assertTrue(formPage.isFormSubmitted(), "Formularul nu a fost procesat corect");
    }
}