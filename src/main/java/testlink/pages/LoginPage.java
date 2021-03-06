package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testlink.selenium.DriverWrapper;

/**
 * Created by Ivan.Ivanyuk on 3/20/2015.
 */
public class LoginPage extends AbstractPage {
    static private final String URL = "http://demo.testlink.org/latest/login.php";

    private final static By loginField = By.id("login");
    private final static By passwordField = By.name("tl_password");
    private static final By loginButton = By.name("login_submit");

    public LoginPage(DriverWrapper driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);

    }

    public HomePage login(String login, String password) {
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
