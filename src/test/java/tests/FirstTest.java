package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import services.SimpleDriver;

public class FirstTest {
    @Test
    public void simpleDriverTest() {
        SimpleDriver simpleDriver = new SimpleDriver();
        WebDriver driver = simpleDriver.getDriver();
    }
}
