package testlink.steps;

import org.openqa.selenium.WebDriver;
import testlink.pages.HomePage;
import testlink.pages.LoginPage;
import testlink.pages.SpecificationPage;

/**
 * Created by Ivan.Ivanyuk on 3/20/2015.
 */
public class TestSteps {
    protected WebDriver driver;

    public boolean login(String login, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        return loginPage.login(login, password).isOpened();
    }

    public boolean openSpecificationPage() {
        HomePage homePage = new HomePage(driver);
        homePage.openSpecificationPage();
        return true;

    }
}