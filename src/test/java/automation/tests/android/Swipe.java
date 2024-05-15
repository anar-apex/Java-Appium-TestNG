package automation.tests.android;

import automation.utils.AndroidActions;
import automation.utils.AndroidBaseTest;
import automation.utils.TestOwners;
import com.beust.ah.A;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Swipe extends AndroidBaseTest {


    @Test
    public void swipeFromRightToLeft() throws InterruptedException {
        Allure.addDescription("Owner: " + TestOwners.ANAR_SALMANOV);
        pages.homePage.VIEWS.click();
        pages.views.GALLERY.click();
        pages.views.PHOTOS.click();
        WebElement firstImage = pages.views.FIRST_IMAGE;

        //Swipe to left
        swipeAction(firstImage, "left", driver);
        Thread.sleep(2000);

        //Validate first image now is not focusable
        Assert.assertEquals(firstImage.getAttribute("focusable"), "false");
    }


    @Test
    public void swipeFromLeftToRight() throws InterruptedException {
        Allure.addDescription("Owner: " + TestOwners.ANAR_SALMANOV);
        pages.homePage.VIEWS.click();
        pages.views.GALLERY.click();
        pages.views.PHOTOS.click();
        WebElement firstImage = pages.views.FIRST_IMAGE;
        swipeAction(firstImage, "left", driver);
        Thread.sleep(3000);

        //Swipe to right
        swipeAction(firstImage, "right", driver);
        Thread.sleep(3000);

        //Validate last image now is not focusable
        WebElement lastImage = pages.views.LAST_IMAGE;
        Assert.assertEquals(lastImage.getAttribute("focusable"), "false");
    }
}
