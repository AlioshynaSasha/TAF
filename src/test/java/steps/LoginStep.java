package steps;

import pages.LoginPage;
import pages.ProductsPage;

import static com.codeborne.selenide.Selenide.page;

public class LoginStep {
    public LoginPage loginPage;

    public LoginStep() {
        loginPage = new LoginPage();
    }

    public void login(String login, String password) {
        loginPage.usernameInput.sendKeys(login);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
    }

    public ProductsPage loginSuccessful(String login, String password) {
        login(login, password);

        return page(ProductsPage.class);
    }
}
