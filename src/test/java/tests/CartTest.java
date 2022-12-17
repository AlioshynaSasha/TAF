package tests;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartTest extends BaseTest {
    @Test
    public void successAddProductToCartTest() {
        ProductsPage productsPage = loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        int countOfProducts = productsPage.products.size();
        List<String> productsNames = new ArrayList<>();

        for (SelenideElement product : productsPage.products) {
            productsNames.add(product.$(ProductsPage.productNameLocator).getText());
            product.$(ProductsPage.addProductButton).click();
        }

        CartPage cartPage = open(CartPage.pagePath, CartPage.class);

        Assert.assertEquals(cartPage.products.size(), countOfProducts);

        for (String name : productsNames) {
            $(By.xpath(String.format(CartPage.productNameLocator, name))).shouldBe(Condition.visible);
        }
    }

    @Test
    public void successEmptyCartTest() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        CartPage cartPage = open(CartPage.pagePath, CartPage.class);

        cartPage.headerTitleLabel.shouldBe(Condition.visible);
        Assert.assertTrue(cartPage.products.isEmpty());
    }

    @Test
    public void incorrectShowCartPageTest() {
        CartPage cartPage = open(CartPage.pagePath, CartPage.class);
        cartPage.headerTitleLabel.shouldNotBe(Condition.visible);
    }

    @Test
    public void deleteProductsFromCartTest() {
        ProductsPage productsPage = loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());

        for (SelenideElement product : productsPage.products) {
            product.$(ProductsPage.addProductButton).click();
        }

        CartPage cartPage = open(CartPage.pagePath, CartPage.class);

        for (SelenideElement product : cartPage.products) {
            product.$(ProductsPage.deleteProductButton).click();
        }

        Assert.assertTrue(cartPage.products.isEmpty());
    }
}
