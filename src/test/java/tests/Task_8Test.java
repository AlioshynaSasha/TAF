package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class Task_8Test {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        this.driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        this.driver.quit();
    }

    @Test
    public void basicLocatorsTest() {
        this.driver.get(ReadProperties.getUrl());
        this.driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
        this.driver.findElement(By.cssSelector("[name=password]")).sendKeys(ReadProperties.password());
        this.driver.findElement(By.cssSelector("[id^=login-butt]")).click();
        this.driver.findElement(By.xpath("//*[contains(@id, 'to-cart-sauce-labs-onesie')]")).click();
        this.driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();

        Assert.assertEquals(this.driver.findElement(By.className("cart_quantity")).getText(), "1");
        Assert.assertEquals(this.driver.findElement(By.cssSelector(".inventory_item_name")).getText(), "Sauce Labs Onesie");
    }
}
