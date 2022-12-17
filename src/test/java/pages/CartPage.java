package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    public final static String pagePath = "cart.html";
    public SelenideElement headerTitleLabel = $(By.xpath("//span[@class='title'][contains(text(), 'Your Cart')]"));
    public List<SelenideElement> products = $$(By.className("cart_item"));
    public final static String productNameLocator = ".//div[@class='inventory_item_name'][contains(text(), '%s')]";
}
