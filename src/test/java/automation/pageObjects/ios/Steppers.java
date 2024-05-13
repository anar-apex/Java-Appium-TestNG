package automation.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Steppers {
    public Steppers(IOSDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Increment'])[3]")
    public WebElement PLUS_BTN;


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[4]")
    public WebElement COUNTER;

}
