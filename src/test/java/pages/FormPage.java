package pages;

import helperMethod.FormHelper;
import org.openqa.selenium.WebDriver;

public class FormPage {

    private FormHelper formHelper;

    public FormPage(WebDriver driver) {
        this.formHelper = new FormHelper(driver);
    }

    public void navigateToFormPage() {
        formHelper.openFormPage("https://testpages.eviltester.com/styled/basic-html-form-test.html");
    }

    public void completeUsernameAndPassword(String username, String password) {
        formHelper.enterUsername(username);
        formHelper.enterPassword(password);
    }

    public void completeComments(String text) {
        formHelper.enterComments(text);
    }

    public void uploadFile(String path) {
        formHelper.uploadFile(path);
    }

    public void selectCheckboxes() {
        formHelper.selectCheckboxes("cb1", "cb2");
    }

    public void selectRadioButton3() {
        formHelper.selectRadioButton("rd3");
    }

    public void selectMultipleItems() {
        formHelper.selectMultipleItems("Selection Item 1", "Selection Item 3");
    }

    public void selectDropdownItem5() {
        formHelper.selectDropdownItem("Drop Down Item 5");
    }

    public void submitForm() {
        formHelper.submitForm();
    }

    public boolean isFormSubmitted() {
        return formHelper.getCurrentUrl().contains("the_form_processor");
    }
}