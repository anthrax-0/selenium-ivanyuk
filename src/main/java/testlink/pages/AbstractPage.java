package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ivan.Ivanyuk on 3/24/2015.
 */
public class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected static final By headerFrame = By.name("titlebar");
    protected final static By mainFrame = By.name("mainframe");
    protected final static By treeFrame = By.name("treeframe");
    protected final static By workFrame = By.name("workframe");


    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    protected void switchToTitleBar() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(headerFrame));
    }

    protected void switchToMainFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
    }

    protected void switchToWorkFrame() {
        switchToMainFrame();
        driver.switchTo().frame(driver.findElement(workFrame));
    }

    protected void switchToTreeFrame() {
        switchToMainFrame();
        driver.switchTo().frame(driver.findElement(treeFrame));
    }

}
