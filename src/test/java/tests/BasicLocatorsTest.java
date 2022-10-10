package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class BasicLocatorsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        this.driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        this.driver.quit();
    }

    @Test
    public void basicLocatorsTest() {
        this.driver.get(ReadProperties.getUrl());
        this.driver.findElement(By.id("name")).sendKeys(ReadProperties.username());
        this.driver.findElement(By.name("password")).sendKeys(ReadProperties.password());
        this.driver.findElement(By.tagName("button")).click();
    }

    @Test
    public void basicLocatorsTest_2() {
        this.driver.get(ReadProperties.getUrl());
        this.driver.findElement(By.linkText("Forgot your password?")).click();
        this.driver.findElement(By.className("forgot_passwordpage-request-cancel")).click();
        this.driver.findElement(By.partialLinkText("your password?")).click();
    }
}
