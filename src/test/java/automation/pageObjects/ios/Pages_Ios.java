package automation.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;

public class Pages_Ios {
    public HomePage homePage;
    public Steppers steppers;

    public Pages_Ios(IOSDriver driver) {
        homePage = new HomePage(driver);
        steppers = new Steppers(driver);
    }
}
