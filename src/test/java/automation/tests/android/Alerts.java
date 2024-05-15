package automation.tests.android;

import automation.utils.AndroidBaseTest;
import automation.utils.TestOwners;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alerts extends AndroidBaseTest {


    @Test
    public void acceptAlert() throws InterruptedException {
        pages.homePage.APP.click();
        pages.homePage.ALERT_DIALOGS.click();
        pages.alertDialogs.OK_CANCEL_ALERT_BTN.click();
        Thread.sleep(1000);
        //Accept the alert
        driver.switchTo().alert().accept();
    }


    @Test
    public void dismissAlert() throws InterruptedException {
        Allure.addDescription("Owner: " + TestOwners.ANAR_SALMANOV);
        pages.homePage.APP.click();
        pages.homePage.ALERT_DIALOGS.click();
        pages.alertDialogs.OK_CANCEL_ALERT_BTN.click();
        Thread.sleep(1000);

        //Dismiss the alert
        driver.switchTo().alert().dismiss();
    }

    //Making to fail on purpose
    @Test
    public void getAlertText() throws InterruptedException {
        Allure.addDescription("Owner: " + TestOwners.ANAR_SALMANOV);
        pages.homePage.APP.click();
        pages.homePage.ALERT_DIALOGS.click();
        pages.alertDialogs.OK_CANCEL_ALERT_BTN.click();
        Thread.sleep(1000);

        //Get alert text
        String alertText = driver.switchTo().alert().getText();

        //Validate the alert text
        Assert.assertEquals(alertText, "Lorem ipsum dolor sit aie consectetur adipiscing\n" +
                "Plloaso mako nuto siwuf cakso dodtos anr koop..");

    }
}
