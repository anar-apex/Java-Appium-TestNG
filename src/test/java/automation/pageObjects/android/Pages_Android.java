package automation.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;

public class Pages_Android {
    public HomePage homePage;
    public AlertDialogs alertDialogs;
    public Views views;

    public Pages_Android(AndroidDriver driver) {
        homePage = new HomePage(driver);
        alertDialogs = new AlertDialogs(driver);
        views = new Views(driver);
    }
}
