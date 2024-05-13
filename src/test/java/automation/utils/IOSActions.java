package automation.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class IOSActions extends AppiumUtil {


    public void longPressAction(WebElement element, int duration, IOSDriver driver) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) element).getId());
        params.put("duration", duration);
        driver.executeScript("mobile: touchAndHold", params);
    }

    public void scrollToEndAction(WebElement endElement, IOSDriver driver) {
        ((JavascriptExecutor) driver).executeScript("mobile: scroll", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", "down",
                "percent", 1.0
        ));
    }


    public void scrollToWebElement(WebElement element, IOSDriver driver) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: scroll", params);
    }


    public void swipeAction(WebElement ele, String direction, IOSDriver driver) {
        Map<String, Object> params1 = new HashMap<String, Object>();
        params1.put("direction", "left");
        //params1.put("element", ((RemoteWebElement)ele).getId());
        driver.executeScript("mobile: swipe", params1);
    }

}
