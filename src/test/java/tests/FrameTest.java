package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test
    public void frameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.findElement(By.tagName("h3")).isDisplayed();

        WebElement frameElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frameElement);
        //driver.switchTo().frame(0);

        driver.findElement(By.xpath("//p[. = 'Your content goes here.']")).isDisplayed();

        //driver.switchTo().parentFrame(); //переключится в родительский документ на один уровень выше
        driver.switchTo().defaultContent(); //переключится в самый первый документ

        driver.findElement(By.tagName("h3")).isDisplayed();
    }

}
