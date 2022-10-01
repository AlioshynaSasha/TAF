package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/aleksandra/IdeaProjects/TAF/src/test/resources/chromedriver");

        return new ChromeDriver();
    }
}
