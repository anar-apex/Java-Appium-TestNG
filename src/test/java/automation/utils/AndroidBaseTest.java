package automation.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import automation.pageObjects.android.Pages_Android;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class AndroidBaseTest extends AndroidActions {

    public AppiumDriverLocalService service;
    public AndroidDriver driver;
    public Pages_Android pages;

    @BeforeSuite
    public void deleteExistingAllureReport() {
        deletePreviousAllureReport();
    }

//    @BeforeClass(alwaysRun = true)
//    public void startAppiumServer() {
//        service = getAppiumService();
//        service.start();
//    }


    @BeforeMethod(alwaysRun = true)
    public void driverSetup() {
        driver = (AndroidDriver) DriverUtil.getDriverAndLaunchApp("ANDROID");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Pages
        pages = new Pages_Android(driver);
    }


    @AfterMethod(alwaysRun = true)
    public void endSession(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            failureScreenShot(driver);
        }
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void stopAppiumServer() {
        DriverUtil.quitDriver();
//        service.stop();
        generateNewAllureReport();
    }

}
