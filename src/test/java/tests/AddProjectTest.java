package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.Project;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.projects.ProjectsPage;
import steps.AddProjectStep;

public class AddProjectTest extends BaseTest {
    private AddProjectStep addProjectStep;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();

        loginStep.loginSuccessful(
                new User(ReadProperties.username(), ReadProperties.password())
        ).addProjectButton.click();
        addProjectStep = new AddProjectStep(driver);
    }

    @Test
    public void createProjectSuccessTest() {
        ProjectsPage projectsPage = addProjectStep.createProjectSuccessful(
                new Project.Builder()
                        .withName("TestName")
                        .withAnnouncement("Test Announcement")
                        .withType(2)
                        .withShowAnon(true)
                        .build()
        );

        Assert.assertTrue(projectsPage.title.isDisplayed());
    }

    @Test
    public void createProjectFailureTest() {
        Assert.assertTrue(addProjectStep.createProjectIncorrect().errorField.isDisplayed());
    }
}
