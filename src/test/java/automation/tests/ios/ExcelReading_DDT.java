package automation.tests.ios;

import automation.utils.ExcelUtil;
import automation.utils.AndroidBaseTest;
import automation.utils.IOSBaseTest;
import automation.utils.TestOwners;
import io.qameta.allure.Allure;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class ExcelReading_DDT extends IOSBaseTest {

    //Set the Excel file path
    @DataProvider(name = "data")
    public Object[][] testData() {
        ExcelUtil excelUtil = new ExcelUtil("src/test/java/automation/resources/framework.xlsx", "data");
        return excelUtil.getDataArray();
    }

    //Read data from Excel and pass to the tests
    @Test(dataProvider = "data")
    public void dataDrivenTest(String language, String tool, String ciCd, String versionControl) {
        Allure.addDescription("Owner: " + TestOwners.ANAR_SALMANOV);
        System.out.println(language + " " + tool + " " + ciCd + " " + versionControl);
    }


}