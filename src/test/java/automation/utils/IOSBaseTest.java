package automation.utils;

import automation.pageObjects.ios.Pages_Ios;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

public class IOSBaseTest extends IOSActions {

    public AppiumDriverLocalService service;
    public IOSDriver driver;
    public Pages_Ios pages;

    @BeforeClass(alwaysRun = true)
    public void startAppiumServer() {
        service = getAppiumService();
        service.start();
    }

    @BeforeMethod
    public void driverSetup() throws IOException, URISyntaxException {
        driver = (IOSDriver) DriverUtil.getDriver("IOS");
        //Pages
        pages = new Pages_Ios(driver);
    }


    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void stopAppiumServer() {
        service.stop();
    }

}
