package automation.pageObjects.ios;

import automation.utils.IOSBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    public HomePage(IOSDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
    @iOSXCUITFindBy(accessibility = "Alert Views")
    public WebElement ALERT_VIEWS;

    //driver.findElement(AppiumBy.ByIosClassChain("Alert Views")).click();
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Text Entry\"`]")
    public WebElement TEXT_ENTRY;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Steppers\"")
    public WebElement STEPPERS;

    @iOSXCUITFindBy(accessibility = "WebViewController")
    public WebElement WEB_VIEW;

}
