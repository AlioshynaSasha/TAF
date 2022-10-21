package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    @Test
    public void frameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        WebElement frameElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frameElement);

        Assert.assertEquals(
                driver.findElement(By.xpath("//*[@id='tinymce']/p")).getText(),
                "Your content goes here."
        );
    }
}
