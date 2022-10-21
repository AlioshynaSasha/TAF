package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControlsTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkBox = driver.findElement(By.xpath("//*[@type='checkbox']"));
        driver.findElement(By.xpath("//*[@type='button'][text()='Remove']")).click();

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        wait.waitForExists(By.id("message"));

        Assert.assertTrue(wait.waitForElementInvisible(checkBox));

        WebElement input = wait.waitForExists(By.xpath("//input"));

        Assert.assertFalse(input.isEnabled());

        wait.waitForExists(By.xpath("//*[@type='button'][text()='Enable']")).click();

        wait.waitForExists(By.id("message"));

        Assert.assertTrue(input.isEnabled());
    }
}
