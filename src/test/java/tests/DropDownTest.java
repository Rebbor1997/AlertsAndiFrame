package tests;

import baseEntities.BaseTest;
import elements.DropDownMenu;
import elements.UIElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.LoginStep;
import steps.ProjectStep;

public class DropDownTest extends BaseTest {
    @Test
    public void dropDownTest1() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.Login(properties.getUsername(), properties.getPassword());

        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.clickDropDown();
        //Thread.sleep(3000);

        DropDownMenu dropDownMenu = new DropDownMenu(driver, By.xpath("//div[@id='helpDropdown']//ul"));
        System.out.println(dropDownMenu.rowsCount());
        System.out.println(dropDownMenu.getElementFrom(13).getText());

        UIElement clickButton = dropDownMenu.getElementFromCell("About TestRail", 13);
        clickButton.click();

        Thread.sleep(3000);
    }
}
