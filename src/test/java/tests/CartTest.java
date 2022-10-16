package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import steps.LoginStep;
import java.util.ArrayList;
import java.util.List;

public class CartTest extends BaseTest {
    private CartPage cartPage;
    @BeforeMethod
    public void setUp() {
        super.setUp();

        cartPage = new CartPage(driver);
    }

    @Test
    public void successAddProductToCartTest() {
        ProductsPage productsPage = new LoginStep(driver).loginSuccessful(ReadProperties.username(), ReadProperties.password());
        List<WebElement> products = productsPage.getProducts();
        List<String> productsNames = new ArrayList<>();

        for (WebElement product : products) {
            productsNames.add(product.findElement(By.className("inventory_item_name")).getText());
            product.findElement(By.xpath("//button[contains(text(), 'Add to cart')]")).click();
        }

        cartPage.openPageByUrl();

        List<WebElement> productsFromCart = cartPage.getProducts();

        Assert.assertEquals(productsFromCart.size(), products.size());

        for (String name : productsNames) {
            Assert.assertTrue(
                    driver.findElement(
                            By.xpath(String.format("//div[@class='inventory_item_name'][contains(text(), '%s')]", name))
                    ).isDisplayed()
            );
        }
    }

    @Test
    public void successEmptyCartTest() {
        new LoginStep(driver).login(ReadProperties.username(), ReadProperties.password());
        cartPage.openPageByUrl();

        Assert.assertEquals(cartPage.getProducts().size(), 0);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void incorrectShowCartPageTest() {
        cartPage.openPageByUrl();
        cartPage.isPageOpened();
    }

    @Test
    public void deleteProductsFromCartTest() {
        ProductsPage productsPage = new LoginStep(driver).loginSuccessful(ReadProperties.username(), ReadProperties.password());

        for (WebElement product : productsPage.getProducts()) {
            product.findElement(By.xpath("//button[contains(text(), 'Add to cart')]")).click();
        }

        cartPage.openPageByUrl();

        for (WebElement product : cartPage.getProducts()) {
            product.findElement(By.xpath("//button[contains(text(), 'Remove')]")).click();
        }

        Assert.assertEquals(cartPage.getProducts().size(), 0);
    }
}
