package shareData;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class ShareData {

    private String testName;
    private WebDriver driver;
    @BeforeMethod (alwaysRun = true)
    public void prepareEnviroment(){

        testName=this.getClass().getSimpleName();
        String remoteEnv= System.getProperty("remote");
        if (Boolean.parseBoolean(remoteEnv))
        { ChromeOptions options= new ChromeOptions();
            options.addArguments("--headless=new");
            driver = new ChromeDriver(options);
        }
        else {
            driver = new ChromeDriver();//deschidem un browser
        }

        driver.get("https://testpages.eviltester.com/styled/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoggerUtility.startTest(testName);
    }

    @AfterMethod(alwaysRun = true)
    public void clearEnviroment() {
         driver.quit();
        LoggerUtility.finishTest(testName);
    }

    public WebDriver getDriver()
    {return driver;}
}
