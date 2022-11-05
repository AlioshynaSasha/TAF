package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends BasePage {
    // Блок описания селекторов для элементов
    @FindBy(xpath = "")
    public WebElement pageIdentifier;

    // Блок инициализации страницы
    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    // Блок атомарных методов
//    public WebElement getHeaderTitleLabel() {
//        return driver.findElement(pageIdentifier);
//    }
//
//    public boolean isHeaderTitleLabelDisplayed() {
//        return getHeaderTitleLabel().isDisplayed();
//    }
}
