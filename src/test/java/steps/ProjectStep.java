package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;

public class ProjectStep extends  BaseStep {
    public ProjectStep(WebDriver driver) {
        super(driver);
    }
    public void addProject(String nameproject, String editnameproject){
        ProjectsPage projectsPage = new ProjectsPage(driver, true);
        projectsPage.clickAddProject();
        projectsPage.setNameProject(nameproject);
        projectsPage.clickAddProjectButton();
        projectsPage.clickEditProject();
        projectsPage.clearNameProject();
        projectsPage.setNewNameProject(editnameproject);
        projectsPage.clickEditProjectButton();

    }
    public void clickDropDown(){
        ProjectsPage projectsPage = new ProjectsPage(driver, true);
        projectsPage.clickDropDownButton();
    }
    public TestCaseStep addProjectChainOfInvocation(String nameproject, String editnameproject) {
        ProjectsPage projectsPage = new ProjectsPage(driver, true);
        projectsPage.clickAddProject();
        projectsPage.setNameProject(nameproject);
        projectsPage.optionsList.get(1).click();
        projectsPage.clickAddProjectButton();
        projectsPage.clickEditProject();
        projectsPage.clearNameProject();
        projectsPage.setNewNameProject(editnameproject);

        return new TestCaseStep(driver);
    }
}
