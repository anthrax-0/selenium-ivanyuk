package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testlink.selenium.DriverWrapper;



/**
 * Created by Ivan.Ivanyuk on 3/24/2015.
 */
public class AbstractPage {
    Logger log = LoggerFactory.getLogger(AbstractPage.class);

    protected DriverWrapper driver;
    protected WebDriverWait wait;

    protected static final By headerFrame = By.name("titlebar");
    protected final static By mainFrame = By.name("mainframe");
    protected final static By treeFrame = By.name("treeframe");
    protected final static By workFrame = By.name("workframe");


    public AbstractPage(DriverWrapper driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    protected void switchToTitleBar() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElementAndWait(headerFrame));
    }

    protected void switchToMainFrame() {
        log.info("SwitchToMainFrame");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElementAndWait(mainFrame));
    }

    protected void switchToWorkFrame() {
        log.info("SwitchToWorkFrame");
        switchToMainFrame();
        driver.switchTo().frame(driver.findElementAndWait(workFrame));
    }

    protected void switchToTreeFrame() {
        log.info("SwitchToTreeFrame");
        switchToMainFrame();
        driver.switchTo().frame(driver.findElementAndWait(treeFrame));
    }

}
