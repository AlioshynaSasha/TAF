package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        String pathToFile = FileUploadTest.class.getClassLoader().getResource("nails.jpg").getPath();
        System.out.println(pathToFile);
        fileUploadPath.sendKeys(pathToFile);
        wait.waitForExists(By.id("file-submit")).submit();
    }
}

