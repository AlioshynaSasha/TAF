package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {
    public List<SelenideElement> products = $$(By.className("inventory_item"));
    public final static By productNameLocator = By.className("inventory_item_name");
    public final static By addProductButton = By.xpath(".//button[contains(text(), 'Add to cart')]");
    public final static By deleteProductButton = By.xpath(".//button[contains(text(), 'Remove')]");
}
