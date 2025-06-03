package locators;

import org.openqa.selenium.By;

public class FormLocators {
    public static final By username_field = By.name("username");
    public static final By password_field = By.name("password");
    public static final By comments_field = By.name("comments");
    public static final By file_upload_field = By.name("filename");
    public static final By checkbox_1 = By.cssSelector("input[value='cb1']");
    public static final By checkbox_2 = By.cssSelector("input[value='cb2']");
    public static final By radio_button_3 = By.cssSelector("input[value='rd3']");
    public static final By multi_select = By.name("multipleselect[]");
    public static final By drop_field = By.name("dropdown");
    public static final By submit_button = By.cssSelector("input[type='submit']");
}