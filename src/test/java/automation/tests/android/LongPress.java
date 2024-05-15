package automation.tests.android;

import automation.utils.AndroidActions;
import automation.utils.AndroidBaseTest;
import automation.utils.TestOwners;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPress extends AndroidBaseTest {

    @Test
    public void longPressGesture() {
        Allure.addDescription("Owner: " + TestOwners.ANAR_SALMANOV);
        pages.homePage.VIEWS.click();
        pages.views.EXPANDABLE_LIST.click();
        pages.views.CUSTOM_ADAPTER.click();
        //Long press the element (press and hold)
        longPressAction(pages.views.PEOPLE_NAMES,driver);

        //Validate sample menu is visible now
        Assert.assertTrue(pages.views.SAMPLE_MENU.isDisplayed());
    }

}
