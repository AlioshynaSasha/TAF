package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDownMenu {
    private final UIElement uiElement;

    public DropDownMenu(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public void click(By by) {
        uiElement.findElement(by).click();
    }
}