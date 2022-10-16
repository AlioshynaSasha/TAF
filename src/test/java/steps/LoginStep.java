package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {
    LoginPage loginPage;

    public LoginStep(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
    }

    public void login(String email, String psw) {
        loginPage.setEmail(email);
        loginPage.setPsw(psw);
        loginPage.clickLoginButton();
    }

    public ProductsPage loginSuccessful(String email, String psw) {
        login(email, psw);

        return new ProductsPage(driver);
    }
}
