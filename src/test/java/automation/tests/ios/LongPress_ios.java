package automation.tests.ios;

import automation.utils.IOSActions;
import automation.utils.IOSBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LongPress_ios extends IOSBaseTest {

    @Test
    public void longPressElement() {
        pages.homePage.STEPPERS.click();
        longPressAction(pages.steppers.PLUS_BTN, 5, driver);
        int counterValue = Integer.parseInt(pages.steppers.COUNTER.getText());
        Assert.assertTrue(counterValue > 0);
    }


}
