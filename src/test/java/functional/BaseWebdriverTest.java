package functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by Ivan.Ivanyuk on 3/17/2015.
 */
public class BaseWebdriverTest {
    protected WebDriver driver;

    @BeforeTest
    public void startWebdriver() {
        driver = new FirefoxDriver();
    }

    @AfterTest
    public void closeWebDriver() {
        driver.quit();
    }

}
