package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import models.User;
import models.UserBuilder;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProjectsPage;

public class LoginStep extends BaseStep {
    public LoginStep(WebDriver driver) {
        super(driver);
    }
    @Step
    public ProjectsPage Login (String username, String password) {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.name_Input.sendKeys(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        return new ProjectsPage(driver, false);
    }



    public ProjectStep LoginChainOfInvocation (String username, String password) {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        return new ProjectStep(driver);
    }



}
