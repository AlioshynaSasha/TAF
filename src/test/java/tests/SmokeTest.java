package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.AdvancedDriver;

public class SmokeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        this.driver = new AdvancedDriver().getDriver();
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
    public void validateSKF() throws InterruptedException {
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

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
