package shareData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class ShareData {

    private String testName;
    private WebDriver driver;
    private Path tempProfileDir;

    @BeforeMethod(alwaysRun = true)
    public void prepareEnviroment() throws Exception {
        testName = this.getClass().getSimpleName();
        String remoteEnv = System.getProperty("remote");
        if (Boolean.parseBoolean(remoteEnv)) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");

            // Folder temporar unic pentru fiecare sesiune
            tempProfileDir = Files.createTempDirectory("chrome-ci-profile-");
            options.addArguments("--user-data-dir=" + tempProfileDir.toString());

            driver = new ChromeDriver(options);
        } else {
            driver = new ChromeDriver();
        }

        driver.get("https://testpages.eviltester.com/styled/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoggerUtility.startTest(testName);
    }

    @AfterMethod(alwaysRun = true)
    public void clearEnviroment() {
        try {
            if (driver != null) {
                driver.quit();
            }
            // Șterge folderul temporar dacă există
            if (tempProfileDir != null) {
                Files.walk(tempProfileDir)
                        .map(Path::toFile)
                        .sorted((o1, o2) -> -o1.compareTo(o2))
                        .forEach(java.io.File::delete);
            }
        } catch (Exception e) {
            System.out.println("Eroare la driver.quit() sau la ștergerea folderului: " + e.getMessage());
        }
        LoggerUtility.finishTest(testName);
    }

    public WebDriver getDriver() {
        return driver;
    }
}