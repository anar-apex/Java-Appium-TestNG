package automation.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomePage {

    public HomePage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    //    driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    public List<WebElement> PRODUCTLIST;

    //    driver.findElement(AppiumBy.accessibilityId("Preference"));
    @AndroidFindBy(accessibility = "Preference") //accessibility ID
    public WebElement PREFERENCES;

    @AndroidFindBy(accessibility = "App")
    public WebElement APP;

    //    driver.findElements(By.xpath("//android.widget.TextView[@content-desc='Alert Dialogs']"));
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Alert Dialogs']")
    public WebElement ALERT_DIALOGS;

    @AndroidFindBy(accessibility = "Views")
    public WebElement VIEWS;



}
