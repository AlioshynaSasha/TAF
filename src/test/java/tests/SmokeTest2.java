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
        WebElement button = driver.findElement(By.cssSelector("#Form1 > ul > li:nth-child(6) > input[type=button]:nth-child(1)"));

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

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
