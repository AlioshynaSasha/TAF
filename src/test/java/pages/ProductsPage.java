package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductsPage extends BasePage {
    private final static String pagePath = "inventory.html";

    // Блок описания селекторов для элементов
    private final By headerTitleLabelLocator = By.xpath("//span[@class='title'][contains(text(), 'Products')]");
    private final By productsLocator = By.className("inventory_item");

    // Блок инициализации страницы
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    // Блок атомарных методов
    public List<WebElement> getProducts() {
        return driver.findElements(productsLocator);
    }
}
