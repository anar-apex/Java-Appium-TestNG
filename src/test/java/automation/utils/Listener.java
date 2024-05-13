package automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

import java.io.IOException;

public class Listener implements ITestListener {

    @Attachment
    public byte[] failureScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
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

    public static void generateNewAllureReport() {
        String generateAllureReport = "allure generate allure-results -o allure-report";
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

    //   This method initializes the driver and prints running test suite name
    @Override
    public void onStart(ITestContext iTestContext) {
        deletePreviousAllureReport();
        System.out.println("Running test suite: " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", DriverUtil.driverPool.get());
    }


    //This method attaches screenshot of failing test to the report
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        WebDriver driver = DriverUtil.driverPool.get();
        if (driver != null) {
            failureScreenShot(driver);
        }
    }

    //This method generates allure report from allure-results files
    @Override
    public void onFinish(ITestContext iTestContext) {
        generateNewAllureReport();
    }


}