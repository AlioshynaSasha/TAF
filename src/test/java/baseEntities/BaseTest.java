package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.BrowsersService;
import steps.LoginStep;
import utils.InvokedListener;

@Listeners(InvokedListener.class)
public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        iTestContext.setAttribute("driver", driver);
        driver.get(ReadProperties.getUrl());

        loginStep = new LoginStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
