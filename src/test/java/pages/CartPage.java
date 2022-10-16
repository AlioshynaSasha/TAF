package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    private final static String pagePath = "cart.html";

    // Блок описания селекторов для элементов
    private final By headerTitleLabelLocator = By.xpath("//span[@class='title'][contains(text(), 'Your Cart')]");
    private final By productsLocator = By.className("cart_item");

    // Блок инициализации страницы
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов
    public List<WebElement> getProducts() {
        return driver.findElements(productsLocator);
    }
}
