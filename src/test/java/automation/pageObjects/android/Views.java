package automation.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Views {
    public Views(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Expandable Lists")
    public WebElement EXPANDABLE_LIST;

    @AndroidFindBy(accessibility = "1. Custom Adapter")
    public WebElement CUSTOM_ADAPTER;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='People Names']")
    public WebElement PEOPLE_NAMES;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/title' and @text=\"Sample menu\"]")
    public WebElement SAMPLE_MENU;

    @AndroidFindBy(accessibility = "WebView3")
    public WebElement WEBVIEW_3;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Gallery\")")
    public WebElement GALLERY;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"1. Photos\")")
    public WebElement PHOTOS;

    @AndroidFindBy(xpath = "//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]")
    public WebElement FIRST_IMAGE;

    @AndroidFindBy(xpath = "//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[3]")
    public WebElement LAST_IMAGE;

    @AndroidFindBy(accessibility = "Drag and Drop")
    public WebElement DRAG_AND_DROP;

    @AndroidFindBy(xpath = "    //android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_1']")
    public WebElement DOT_1;

    @AndroidFindBy(xpath = "    //android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_2']")
    public WebElement DOT_2;

    @AndroidFindBy(xpath = "    //android.widget.TextView[@resource-id='io.appium.android.apis:id/drag_result_text']")
    public WebElement DRAG_RESULT;

}
