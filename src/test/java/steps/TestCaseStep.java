package steps;

import baseEntities.BaseStep;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.TestCasePage;


public class TestCaseStep extends BaseStep {

    public TestCaseStep(WebDriver driver) {
        super(driver);
    }

    public DeleteStep addTestCase(User user) {
        TestCasePage testCasePage = new TestCasePage(driver, true);
        testCasePage.clickRunTestCase();

        testCasePage.clickTabSuiteAndCases();
        testCasePage.clickTestRuns();
        testCasePage.clickSectionAndCases();

        testCasePage.clickTestCaseButton();
        testCasePage.setTittle(user.getTitle());
        testCasePage.setPreconds(user.getPreconds());
        testCasePage.setSteps(user.getSteps());
        testCasePage.setResult(user.getResult());
        testCasePage.clickAddTestCase();

        return new DeleteStep(driver);
    }
}
