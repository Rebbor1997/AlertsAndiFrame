package tests;

import baseEntities.BaseTest;
import elements.RadioButton;
import elements.Table;
import elements.UIElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.LoginStep;

public class TableTest extends BaseTest {

    @Test
    public void tableTest1() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.Login(properties.getUsername(), properties.getPassword());

        driver.get("https://aqa06onl03.testrail.io/index.php?/admin/projects/overview");
        Table table = new Table(driver, By.cssSelector("table.grid"));
        //System.out.println(table.rowsCount());
        //System.out.println(table.getElementFromCell(6 , 0).getText());
        //UIElement editButton = table.getElementFromCell("qeqe", 0, 1);
        UIElement editButton = table.getElementFromCell("qeqe", 0, "Edit");
        editButton.click();

        Thread.sleep(5000);
    }
}
