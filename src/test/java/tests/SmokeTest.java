package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

import java.nio.channels.Selector;

public class SmokeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        this.driver = new BrowsersService().getDriver();
    }

    @Test
    public void validateIKTCalculationTest() {
        driver.get("https://clinic-cvetkov.ru/company/kalkulyator-imt/");
        WebElement weight = driver.findElement(By.name("weight"));
        WebElement height = driver.findElement(By.name("height"));
        WebElement button = driver.findElement(By.id("calc-mass-c"));

        weight.sendKeys("58");
        height.sendKeys("183");
        button.click();

        WebElement result = driver.findElement(By.id("imt-result"));
        Assert.assertEquals(result.getText(), "17.3 - Недостаточная (дефицит) масса тела");
    }

    @Test
    public void validateSKFTest() throws InterruptedException {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");

        WebElement selectWebElement = driver.findElement(By.id("oSex"));
        Select selectSex = new Select(selectWebElement);
        selectSex.selectByIndex(1);
        Thread.sleep(2000);
        selectSex.selectByValue("0");
        Thread.sleep(2000);
        selectSex.selectByVisibleText("женский");
        Thread.sleep(2000);
    }

//    Примеры работы с селектами
    @Test
    public void validateRoomTest() {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        WebElement selectWebElement = driver.findElement(By.id("room_type"));
        Select selectRoom = new Select(selectWebElement);
        selectRoom.selectByValue("2");
        selectRoom.selectByVisibleText("Кухня или спальня");
    }

    @Test
    public void validateHeatingTest() {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        WebElement selectWebElement = driver.findElement(By.id("heating_type"));
        Select selectorHeating = new Select(selectWebElement);
        selectorHeating.selectByValue("2");
        selectorHeating.selectByVisibleText("Основное отопление");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
