package pages;

import helperMethod.IFramesHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFramePage {
    private IFramesHelper helper;

    public static final String DYNAMIC_IFRAME_ID = "thedynamichtml";
    public static final String HEADER_IFRAME_ID = "theheaderhtml";
    private WebDriver driver;

    private static final By INDEX_LINK = By.linkText("Index");

    public IFramePage(WebDriver driver) {
        this.driver = driver;
        this.helper = new IFramesHelper(driver);
    }

    public String getDynamicIframeContent() {
        helper.switchToIframeById(DYNAMIC_IFRAME_ID);
        String text = helper.getBodyText();
        helper.switchToDefaultContent();
        return text;
    }

    public String getHeaderIframeContent() {
        helper.switchToIframeById(HEADER_IFRAME_ID);
        String text = helper.getBodyText();
        helper.switchToDefaultContent();
        return text;
    }

    public void clickIndexLink() {
        helper.clickElement(INDEX_LINK);
    }
}