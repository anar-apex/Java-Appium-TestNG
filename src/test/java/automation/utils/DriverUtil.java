package automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;


public class DriverUtil {

    public static final ThreadLocal<AppiumDriver> driverPool = new ThreadLocal<>();

    private DriverUtil() {
    }

    public static AppiumDriver getDriver(String platform) {
        String url = ConfigReader.getProperty("Url");
        try {
            if (platform.equalsIgnoreCase("ANDROID")) {
                UiAutomator2Options androidOptions = new UiAutomator2Options();
                androidOptions.setDeviceName(ConfigReader.getProperty("AndroidDevice"));
                androidOptions.setPlatformVersion(ConfigReader.getProperty("AndroidVersion"));
                androidOptions.setApp(ConfigReader.getProperty("DemoApk"));
                androidOptions.setAutoGrantPermissions(true);
                driverPool.set(new AndroidDriver(new URL(url), androidOptions));
            } else if (platform.equalsIgnoreCase("IOS")) {
                XCUITestOptions iosOptions = new XCUITestOptions();
                iosOptions.setDeviceName(ConfigReader.getProperty("IOSDevice"));
                iosOptions.setPlatformVersion(ConfigReader.getProperty("IOSVersion"));
                iosOptions.setApp(ConfigReader.getProperty("UIKitCatalogApp"));
                iosOptions.setWdaLaunchTimeout(Duration.ofSeconds(20));
                driverPool.set(new IOSDriver(new URL(url), iosOptions));
            } else {
                throw new IllegalArgumentException("Unsupported platform: " + platform);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driverPool.get();
    }


    public static void quitDriver() {
        driverPool.get().quit();
        driverPool.remove();
    }
}
