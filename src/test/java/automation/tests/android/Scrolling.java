package automation.tests.android;

import automation.utils.AndroidActions;
import automation.utils.AndroidBaseTest;
import automation.utils.TestOwners;
import io.qameta.allure.Allure;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scrolling extends AndroidBaseTest {

    @Test
    public void scrollVerticalToTheEnd() {
        Allure.addDescription("Owner: " + TestOwners.ANAR_SALMANOV);
        pages.homePage.VIEWS.click();

        //Validate element is not visible in main screen
        try {
            Assert.assertFalse(pages.views.WEBVIEW_3.isDisplayed());
        } catch (NoSuchElementException ignored) {
        }

        //Scroll down till the end of screen
        scrollVerticalToTheEnd(driver);

        //Validate the element is visible now
        Assert.assertTrue(pages.views.WEBVIEW_3.isDisplayed());
    }

    @Test
    public void scrollToTheElement() {
        Allure.addDescription("Owner: " + TestOwners.ANAR_SALMANOV);
        pages.homePage.VIEWS.click();

        //Validate element is not visible in main screen
        try {
            Assert.assertFalse(pages.views.WEBVIEW_3.isDisplayed());
        } catch (NoSuchElementException ignored) {
        }

        //Scroll to the specific text in screen
        scrollToText("WebView3",driver);

        //Validate the element is visible now
        Assert.assertTrue(pages.views.WEBVIEW_3.isDisplayed());
    }


}
