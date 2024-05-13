package automation.tests.android;

import automation.utils.AndroidActions;
import automation.utils.AndroidBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop extends AndroidBaseTest {

    @Test
    public void dragAndDropElement() throws InterruptedException {
        pages.homePage.VIEWS.click();
        pages.views.DRAG_AND_DROP.click();
        WebElement draggable = pages.views.DOT_1;

        //Drag and drop the element
        int droppableX = 623;
        int droppableY = 639;
        dragAndDrop(draggable, droppableX, droppableY,driver);
        Thread.sleep(2000);

        //Validate drag and drop operation is successful
        Assert.assertEquals(pages.views.DRAG_RESULT.getText(), "Dropped!");

    }


}

