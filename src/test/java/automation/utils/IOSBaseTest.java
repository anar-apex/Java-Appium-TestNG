package automation.utils;

import automation.pageObjects.ios.Pages_Ios;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class IOSBaseTest extends IOSActions {

    public AppiumDriverLocalService service;
    public IOSDriver driver;
    public Pages_Ios pages;

    @BeforeSuite
    public void deleteExistingAllureReport(){
        deletePreviousAllureReport();
    }


    @BeforeClass(alwaysRun = true)
    public void startAppiumServer() {
        service = getAppiumService();
        service.start();
    }

    @BeforeMethod
    public void driverSetup()  {
        driver = (IOSDriver) DriverUtil.getDriverAndLaunchApp("IOS");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Pages
        pages = new Pages_Ios(driver);
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
        service.stop();
        generateNewAllureReport();
    }

}
