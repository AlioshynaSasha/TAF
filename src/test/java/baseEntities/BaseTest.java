package baseEntities;

import com.codeborne.selenide.Configuration;
import configuration.ReadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.LoginStep;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    protected LoginStep loginStep;

    @BeforeMethod
    public void setUp() {
        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.headless = ReadProperties.isHeadless();
        Configuration.timeout = ReadProperties.timeout();
        Configuration.fastSetValue = true;

        loginStep = open("", LoginStep.class);
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
