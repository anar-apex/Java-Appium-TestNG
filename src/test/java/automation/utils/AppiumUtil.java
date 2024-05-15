package automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AppiumUtil {


    public AppiumDriverLocalService getAppiumService() {
        return new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
    }


    public void waitForElementToAppear(WebElement ele, AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains((ele), "text", "Cart"));
    }

    public static void deletePreviousAllureReport() {
        String deletePreviousAllureReport = "rm -rf allure-results allure-report";
        try {
            Process process = Runtime.getRuntime().exec(deletePreviousAllureReport);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void generateNewAllureReport() {
        String generateAllureReport = "allure generate allure-results --clean";
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(generateAllureReport);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }

    @Attachment
    public byte[] failureScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
}
