package tests;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.IFramePage;
import pages.IndexPage;
import shareData.ShareData;
@Feature("Iframe Feature")
public class IframeTest extends ShareData {

    @Test (groups =  {TestSuite.REGRESSION_SUITE, TestSuite.IFRAME_SUITE})
    public void testIframesContent() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnIFrameMenu();
        IFramePage iframePage = new IFramePage(getDriver());


        String dynamicIframeText = iframePage.getDynamicIframeContent();
        System.out.println("Conținut iframe dinamic:\n" + dynamicIframeText);
        String headerIframeText = iframePage.getHeaderIframeContent();
        System.out.println("Conținut iframe header:\n" + headerIframeText);
        iframePage.clickIndexLink();
    }
}
