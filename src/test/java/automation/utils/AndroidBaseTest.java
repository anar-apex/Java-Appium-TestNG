package automation.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import automation.pageObjects.android.Pages_Android;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

public class AndroidBaseTest extends AndroidActions {

    public AppiumDriverLocalService service;
    public AndroidDriver driver;
    public Pages_Android pages;


    @BeforeClass(alwaysRun = true)
    public void startAppiumServer() {
        service = getAppiumService();
        service.start();
    }


    @BeforeMethod(alwaysRun = true)
    public void driverSetup() throws IOException, URISyntaxException {
        driver = (AndroidDriver) DriverUtil.getDriver("ANDROID");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Pages
        pages = new Pages_Android(driver);
    }


    @AfterMethod(alwaysRun = true)
    public void endSession() {
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void stopAppiumServer() {
        DriverUtil.quitDriver();
        service.stop();
    }

}
