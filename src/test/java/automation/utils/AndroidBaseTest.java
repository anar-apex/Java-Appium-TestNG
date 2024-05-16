package automation.utils;

import automation.pageObjects.android.Pages_Android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
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

    @Parameters({"Platform"})
    @BeforeClass(alwaysRun = true)
    public void startAppiumServer(@Optional String platform) {
        if (platform == null) {
            service = getAppiumService();
            service.start();
        }
    }

    @Parameters({"Platform"})
    @BeforeMethod(alwaysRun = true)
    public void driverSetup(@Optional String platform) {
        platform = (platform == null) ? "ANDROID" : platform;
        driver = (AndroidDriver) DriverUtil.getDriverAndLaunchApp(platform);
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

    @Parameters({"Platform"})
    @AfterSuite(alwaysRun = true)
    public void stopAppiumServer(@Optional String platform) {
        DriverUtil.quitDriver();
        if (platform == null) {
            service.stop();
        }
        generateNewAllureReport();
    }

}
