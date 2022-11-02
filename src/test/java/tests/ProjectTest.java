package tests;

import models.Project;
import org.testng.annotations.Test;
import steps.ProjectsStep;

public class ProjectTest {
    ProjectsStep projectsStep = new ProjectsStep();

    @Test
    public void createProjectTest() {
        projectsStep.createProject("test1", "test2", 1, false, false);
    }

    @Test
    public void updateProjectTest() {
        Project project = new Project();
        project.setName("Sasha");
        project.setDescription("sitjrj");
        project.setType(2);
        project.setShowAnon(false);
        project.setAccess(true);
        project.setDeleted(true);

        projectsStep.createProject(project);
    }
}
