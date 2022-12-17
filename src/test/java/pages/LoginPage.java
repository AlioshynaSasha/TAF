package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement usernameInput = $(By.id("user-name"));
    public SelenideElement passwordInput = $(By.id("password"));
    public SelenideElement loginButton = $(By.id("login-button"));
}
