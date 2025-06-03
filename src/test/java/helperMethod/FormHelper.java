package helperMethod;

import locators.FormLocators;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class FormHelper {

    private WebDriver driver;

    public FormHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openFormPage(String url) {
        LoggerUtility.infoLog("Se deschide pagina: " + url);
        driver.get(url);
    }

    public void enterUsername(String username) {
        LoggerUtility.infoLog("Introduc username: " + username);
        driver.findElement(FormLocators.username_field).sendKeys(username);
    }

    public void enterPassword(String password) {
        LoggerUtility.infoLog("Introduc parola.");
        driver.findElement(FormLocators.password_field).sendKeys(password);
    }

    public void enterComments(String comment) {
        LoggerUtility.infoLog("Introduc comentariu: " + comment);
        WebElement comments = driver.findElement(FormLocators.comments_field);
        comments.clear();
        comments.sendKeys(comment);
    }

    public void uploadFile(String relativeFilePath) {
        LoggerUtility.infoLog("Se încarcă fișierul: " + relativeFilePath);
        File file = new File(relativeFilePath);
        driver.findElement(FormLocators.file_upload_field).sendKeys(file.getAbsolutePath());
    }

    public void selectCheckboxes(String... values) {
        for (String value : values) {
            LoggerUtility.infoLog("Selectez checkbox: " + value);
            WebElement checkbox = driver.findElement(By.cssSelector("input[value='" + value + "']"));
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public void selectRadioButton(String value) {
        LoggerUtility.infoLog("Selectez radio button: " + value);
        driver.findElement(By.cssSelector("input[value='" + value + "']")).click();
    }

    public void selectMultipleItems(String... items) {
        LoggerUtility.infoLog("Selectez multiple iteme: " + String.join(", ", items));
        Select multiSelect = new Select(driver.findElement(FormLocators.multi_select));
        multiSelect.deselectAll();
        for (String item : items) {
            multiSelect.selectByVisibleText(item);
        }
    }

    public void selectDropdownItem(String visibleText) {
        LoggerUtility.infoLog("Selectez dropdown item: " + visibleText);
        Select dropdown = new Select(driver.findElement(FormLocators.drop_field));
        dropdown.selectByVisibleText(visibleText);
    }

    public void submitForm() {
        LoggerUtility.infoLog("Se dă submit formularului.");
        driver.findElement(FormLocators.submit_button).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}