package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

//Epic -> Feature -> Story
@Epics({@Epic("Epic 1"), @Epic("Epic 2")})
@Feature("Feature 1")
public class AllureTest {

    @Test
    @Issue("AQA21-1")
    public void testIssue() {
        Assert.assertTrue(true);
    }

    @Test
    @TmsLink("TMS-1")
    public void testTms() {
        Assert.assertTrue(true);
    }

    @Test
    @Link("https://onliner.by")
    @Link(name = "Onliner Catalog", type = "mylink", url = "https://onliner.by")
    public void testLink() {
        Assert.assertTrue(true);
    }

    @Test(description = "Описание теста")
    public void testDescription() {
        Assert.assertTrue(true);
    }

    @Test
    @Description("Описание теста Allure")
    public void testDescription1() {
        Assert.assertTrue(true);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void testSeverity() {
        Assert.assertTrue(true);
    }

    @Test
    @Stories({@Story("Test Story 1"), @Story("Test Story 2")})
    public void testStory() {
        Assert.assertTrue(true);
    }
}
