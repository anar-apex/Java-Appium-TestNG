package automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class DriverUtil {

    private static final String BS_USERNAME = "anar_jYhBtq";
    private static final String BS_KEY = "hbNLyyAwqzfELwjqhx9f";
    private static final String BS_URL = "https://" + BS_USERNAME + ":" + BS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    private static final String BS_ANDROID_APP = "bs://51a13558a3e018454b141de69736b26f4f7d4c79";

    //TODO: Convert .app file to .ipa file (for real IOS devices), upload to BS and get the app location.
    private static final String BS_IOS_APP = "";


    public static final ThreadLocal<AppiumDriver> driverPool = new ThreadLocal<>();

    private DriverUtil() {}

    public static AppiumDriver getDriverAndLaunchApp(String platform) {
        String url = ConfigReader.getProperty("Url");
        try {
            if (platform.equalsIgnoreCase("BS_ANDROID")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("deviceName", "Samsung Galaxy S21");
                capabilities.setCapability("os_version", "12.0");
                capabilities.setCapability("name", "Android tests");
                capabilities.setCapability("app", BS_ANDROID_APP);
                driverPool.set(new AndroidDriver(new URL(BS_URL), capabilities));
            } else if (platform.equalsIgnoreCase("ANDROID")) {
                UiAutomator2Options androidOptions = new UiAutomator2Options();
                androidOptions.setDeviceName(ConfigReader.getProperty("AndroidDevice"))
                        .setPlatformVersion(ConfigReader.getProperty("AndroidVersion"))
                        .setApp(ConfigReader.getProperty("DemoApk"))
                        .setAutoGrantPermissions(true);
//                        .setAppPackage("")
//                        .setAppActivity("")
                driverPool.set(new AndroidDriver(new URL(url), androidOptions));
            } else if (platform.equalsIgnoreCase("BS_IOS")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("deviceName", "iPhone 14 Pro Max");
                capabilities.setCapability("os_version", "16.0");
                capabilities.setCapability("name", "IOS tests");
                capabilities.setCapability("app", BS_IOS_APP);
                driverPool.set(new IOSDriver(new URL(BS_URL), capabilities));
            } else if (platform.equalsIgnoreCase("IOS")) {
                XCUITestOptions iosOptions = new XCUITestOptions()
                        .setDeviceName(ConfigReader.getProperty("IOSDevice"))
                        .setPlatformVersion(ConfigReader.getProperty("IOSVersion"))
                        .setApp(ConfigReader.getProperty("UIKitCatalogApp"))
//                        .setAppPackage("")
//                        .setAppActivity("")
                        .setWdaLaunchTimeout(Duration.ofSeconds(20));
                driverPool.set(new IOSDriver(new URL(url), iosOptions));
            } else {
                throw new IllegalArgumentException("Unsupported platform: " + platform);
            }
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
        return driverPool.get();
    }


    public static void quitDriver() {
        driverPool.get().quit();
        driverPool.remove();
    }
}
