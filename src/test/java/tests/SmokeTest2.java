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

public class SmokeTest2 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        this.driver = new BrowsersService().getDriver();
    }

    @Test
    public void validateIKTCalculationTest() {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");
        WebElement sex = driver.findElement(By.id("oSex"));
        Select selectSex = new Select(sex);
        WebElement creatinine = driver.findElement(By.id("oCr"));
        WebElement age = driver.findElement(By.id("oAge"));
        WebElement weight = driver.findElement(By.id("oWeight"));
        WebElement height = driver.findElement(By.id("oHeight"));
        WebElement button = driver.findElement(By.cssSelector("input[type='button']"));

        selectSex.selectByValue("1");
        creatinine.sendKeys("80");
        age.sendKeys("38");
        weight.sendKeys("55");
        height.sendKeys("163");
        button.click();

        WebElement mdrd = driver.findElement(By.id("txtMDRD"));
        WebElement hbp = driver.findElement(By.id("txtMDRD1"));
        WebElement cg = driver.findElement(By.id("txtCG"));
        WebElement bsa = driver.findElement(By.id("txtBSA"));

        Assert.assertEquals(mdrd.getText(), "MDRD: 74 (мл/мин/1,73кв.м)");
        Assert.assertEquals(hbp.getText(), "ХБП: 2 стадия (при наличии почечного повреждения)");
        Assert.assertEquals(cg.getText(), "Cockroft-Gault: 70 (мл/мин)");
        Assert.assertEquals(bsa.getText(), "Поверхность тела:1.58 (кв.м)");
    }

    @Test
    public void validateCalculationThermalFloorTest() {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        WebElement width = driver.findElement(By.id("el_f_width"));
        WebElement length = driver.findElement(By.id("el_f_lenght"));
        WebElement room = driver.findElement(By.id("room_type"));
        Select selectRoom = new Select(room);
        WebElement heating = driver.findElement(By.id("heating_type"));
        Select selectHeating = new Select(heating);
        WebElement heatLoss = driver.findElement(By.id("el_f_losses"));
        WebElement button = driver.findElement(By.name("button"));

        width.sendKeys("120");
        length.sendKeys("140");
        selectRoom.selectByValue("2");
        selectHeating.selectByValue("2");
        heatLoss.sendKeys("25");
        button.click();

        WebElement floorCable = driver.findElement(By.id("floor_cable_power"));
        WebElement specFloorCable= driver.findElement(By.id("spec_floor_cable_power"));

        Assert.assertEquals(floorCable.getAttribute("value"), "26");
        Assert.assertEquals(specFloorCable.getAttribute("value"), "0");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
