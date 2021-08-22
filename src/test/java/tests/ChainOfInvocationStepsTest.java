package tests;

import baseEntities.BaseTest;
import models.User;
import org.testng.annotations.Test;
import steps.LoginStep;

public class ChainOfInvocationStepsTest extends BaseTest {

    @Test
    public void chainOfInvocationTest() throws InterruptedException {
        User user = setupUser();

        LoginStep loginStep = new LoginStep(driver);
        loginStep
                .LoginChainOfInvocation(properties.getUsername(), properties.getPassword())
                .addProjectChainOfInvocation(properties.getNameProject(), properties.getNewNameProject())
                .addTestCase(user)
                .deleteProject();
        Thread.sleep(4000);
    }
    private User setupUser(){
        User user = new User();
        user.setTitle("Name");
        user.setPreconds("regsregt");
        user.setSteps("Step by step");
        user.setResult("well");

        return user;
    }
}
