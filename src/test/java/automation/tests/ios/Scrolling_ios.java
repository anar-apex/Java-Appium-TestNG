package automation.tests.ios;

import automation.utils.IOSActions;
import automation.utils.IOSBaseTest;
import automation.utils.TestOwners;
import io.qameta.allure.Allure;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scrolling_ios extends IOSBaseTest {

    @Test
    public void scrollToTheElement() throws InterruptedException {
        Allure.addDescription("Owner: " + TestOwners.ANAR_SALMANOV);
        // Validate the WebView element is not visible in main screen
        try {
            Assert.assertFalse(pages.homePage.WEB_VIEW.isDisplayed());
        } catch (NoSuchElementException ignored) {
        }

        //Scroll to the WebView element and validate now the element and click that
        scrollToEndAction(pages.homePage.WEB_VIEW,driver);
        Assert.assertTrue(pages.homePage.WEB_VIEW.isDisplayed());
    }

}
