package services;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AdvancedDriver {
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/aleksandra/IdeaProjects/TAF/src/test/resources/chromedriver");

        return new ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setHeadless(ReadProperties.isHeadless());
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");

        return chromeOptions;
    }
}