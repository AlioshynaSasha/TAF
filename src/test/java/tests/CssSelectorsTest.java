package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class CssSelectorsTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        this.driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        this.driver.quit();
    }

    @Test
    public void basicLocatorsTest() {
        this.driver.get("file:/Users/aleksandra/IdeaProjects/TAF/src/test/resources/index.html");
        Assert.assertTrue(driver.findElement(By.cssSelector("#my-Address")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());

        // Поиск по нескольким значения в аттрибуте class
        Assert.assertTrue(driver.findElement(By.cssSelector(".noSel.newsletter")).isDisplayed());

        // Поиск по tag name
        Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());

        // Поиск по tag и значению из аттрибута class
        Assert.assertTrue(driver.findElement(By.cssSelector("div.intro")).isDisplayed());

        // Поиск по tag и значению из аттрибута class
        Assert.assertEquals(driver.findElements(By.cssSelector("#Lastname .markup")).size(), 2);

        // Поиск всех элементов с тэгом h1 или p
        Assert.assertEquals(driver.findElements(By.cssSelector("h1, p")).size(), 8);

        // Поиск всех элементов с тэгом p у которых непосредственный родитель с тэгом div
        Assert.assertEquals(driver.findElements(By.cssSelector("div > p")).size(), 6);

        // Поиск всех элементов с тэгом p которые идут сразу за элементом с тэго ul
        Assert.assertEquals(driver.findElements(By.cssSelector("ul + p")).size(), 1);

        // Поиск всех элементов с тэгом div которые являются братьями элементу с тэгом p
        Assert.assertEquals(driver.findElements(By.cssSelector("p ~ div")).size(), 2);

        // Поиск всех элементов у которых присутствует аттрибут title
        Assert.assertEquals(driver.findElements(By.cssSelector("[title]")).size(), 1);

        // Поиск всех элементов у которых присутствует аттрибут style с конкретным значением
        Assert.assertEquals(driver.findElements(By.cssSelector("[style='overflow: auto;']")).size(), 1);

        // Поиск всех элементов у которых присутствует аттрибут id со значением заканчивающимся на какое-то value
        Assert.assertEquals(driver.findElements(By.cssSelector("[id$='ess']")).size(), 1);

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value-
        Assert.assertEquals(driver.findElements(By.cssSelector("[id|=my]")).size(), 1);

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value
        Assert.assertEquals(driver.findElements(By.cssSelector("[id^=L]")).size(), 2);

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим слово целиком
        Assert.assertEquals(driver.findElements(By.cssSelector("[title~=beautiful]")).size(), 1);

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим какой текст
        Assert.assertEquals(driver.findElements(By.cssSelector("[title*=beaut]")).size(), 1);

        // Поиск всех disabled элементов
        Assert.assertEquals(driver.findElements(By.cssSelector(":disabled")).size(), 1);

        // Поиск всех enabled элементов
        Assert.assertEquals(driver.findElements(By.cssSelector(":enabled")).size(),8);

        // Поиск всех выборанных элементов
        Assert.assertEquals(driver.findElements(By.cssSelector(":checked")).size(), 2);

        // Поиск всех элементов c пустым телом
        Assert.assertEquals(driver.findElements(By.cssSelector(":empty")).size(), 16);

        // Поиск элемента с тэгом p и которым является первым дочерним элементом
        Assert.assertEquals(driver.findElements(By.cssSelector("p:first-child")).size(), 1);

        // Поиск элемента с тэгом p и которым является последним дочерним элементом
        Assert.assertEquals(driver.findElements(By.cssSelector("p:last-child")).size(), 2);

        // Поиск элемента с тэгом p и которым является n-ым дочерним элементом
        Assert.assertEquals(driver.findElements(By.cssSelector("p:nth-child(2)")).size(), 1);
    }
}
