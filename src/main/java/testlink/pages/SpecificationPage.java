package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testlink.models.TestCase;
import testlink.models.TestSuite;
import testlink.selenium.DriverWrapper;

/**
 * Created by Ivan.Ivanyuk on 3/20/2015.
 */
public class SpecificationPage extends AbstractPage {

    private static final By actionButton = By.xpath("//img[@title='Actions']");
    private static final By createTestSuiteButton = By.name("new_testsuite");
    private static final By suiteNameField = By.id("name");
    private static final By detailsFrame = By.xpath("//iframe[@title='Rich text editor, details']");
    private static final By frameBody = By.tagName("body");
    private static final By saveSuiteButton = By.name("add_testsuite_button");
    private static final By createTestCaseButton = By.id("create_tc");
    private static final By testCaseNameField = By.id("testcase_name");
    private static final By testCaseSummary = By.xpath("//iframe[@aria-describedby='cke_44']");
    private static final By testCasePreconditions = By.xpath("//iframe[@aria-describedby='cke_88']");
    private static final By saveTestCaseButton = By.id("do_create_button_2");
    private static final By createdTestCaseName = By.xpath("html/body/div/h2");

    public SpecificationPage(DriverWrapper driver) {
        super(driver);
    }

    public void createTestSuite(TestSuite testSuite){
        switchToWorkFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(actionButton));
        driver.findElement(actionButton).click();
        driver.findElement(createTestSuiteButton).click();
        switchToWorkFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(suiteNameField));
        driver.findElement(suiteNameField).sendKeys(testSuite.name);
        driver.switchTo().frame(driver.findElement(detailsFrame));
        driver.findElement(frameBody).sendKeys(testSuite.details);
        switchToWorkFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(saveSuiteButton));
        driver.findElement(saveSuiteButton).click();
        switchToTreeFrame();
        Assert.assertFalse(driver.findElements(By.xpath("//span[.='" + testSuite.name + " (0)']")).isEmpty(), "Suite is not created!");

    }

    public void createTestCase(TestSuite testSuite, TestCase testCase){
        switchToTreeFrame();
        driver.findElement(By.xpath("//span[.='" + testSuite.name + " (0)']")).click();
        switchToWorkFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(actionButton));
        driver.findElement(actionButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(createTestCaseButton));
        driver.findElement(createTestCaseButton).click();
        switchToWorkFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(testCaseNameField));
        driver.findElement(testCaseNameField).sendKeys(testCase.title);
        driver.switchTo().frame(driver.findElement(testCaseSummary));
        driver.findElement(frameBody).sendKeys(testCase.summary);
        switchToWorkFrame();
        driver.switchTo().frame(driver.findElement(testCasePreconditions));
        driver.findElement(frameBody).sendKeys(testCase.preconditions);
        switchToWorkFrame();
        driver.findElement(saveTestCaseButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(createdTestCaseName));
        System.out.println(driver.findElement(createdTestCaseName).getText());




    }
}
