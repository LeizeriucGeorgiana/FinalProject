package helperMethod;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {

    private WebDriver driver;

    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(){
        waitForAlert();
        Alert alertOk= driver.switchTo().alert();// // Comută către alert
        System.out.println(alertOk.getText()); //obtine textul din alerta
        alertOk.accept(); //dam accept
    }
    public void cancelAlert(){
        waitForAlert();
        Alert alertOkCancel= driver.switchTo().alert();//comuta catre alerta
        System.out.println(alertOkCancel.getText()); //obtinem textul din alerta
        alertOkCancel.dismiss();
    }
    public void sendKeysToAlert(String text) {
        waitForAlert();
        driver.switchTo().alert().sendKeys(text);
    }



}
