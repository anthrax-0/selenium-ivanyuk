package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testlink.models.TestSuite;

/**
 * Created by Ivan.Ivanyuk on 3/20/2015.
 */
public class SpecificationPage extends AbstractPage {

    private static final By actionButton = By.xpath("//img[@title='Actions']");
    private static final By createTestsuiteButton = By.name("new_testsuite");
    private static final By suiteName = By.id("name");
    private static final By detailsFrame = By.xpath("//iframe[@title='Rich text editor, details']");
    private static final By frameBody = By.tagName("body");
    private static final By saveSuiteButton = By.name("add_testsuite_button");

    public SpecificationPage(WebDriver driver) {
        super(driver);
    }

    public void createTestSuite(TestSuite suite){
        switchToWorkFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(actionButton));
        driver.findElement(actionButton).click();
        driver.findElement(createTestsuiteButton).click();
        driver.findElement(suiteName).sendKeys(suite.name);
        driver.findElement(saveSuiteButton).click();
    }
}
