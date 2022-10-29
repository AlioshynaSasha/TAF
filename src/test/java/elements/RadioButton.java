package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton {
    private final UIElement uiElement;

    public RadioButton(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public void click(By by) {
        if (!this.isSelected(by)) {
            uiElement.findElement(by).click();
        }
    }

    public boolean isSelected(By by) {
        return uiElement.findElement(by).isSelected();
    }
}
