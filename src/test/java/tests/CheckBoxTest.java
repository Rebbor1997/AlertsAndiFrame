package tests;

import baseEntities.BaseTest;
import elements.CheckBox;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.LoginStep;

public class CheckBoxTest extends BaseTest {
    @Test
    public void checkBoxTest1() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.Login(properties.getUsername(), properties.getPassword());

        driver.get("https://aqa06onl03.testrail.io/index.php?/admin/projects/add/1");

        CheckBox checkBox = new CheckBox(driver, By.name("show_announcement"));
        //checkBox.changeState(checkBox.isSelected());
        checkBox.selectByText("Show the announcement on the overview page");
        Thread.sleep(3000);
    }
}
