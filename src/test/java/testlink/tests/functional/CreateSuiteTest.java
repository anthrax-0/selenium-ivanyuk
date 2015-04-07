package testlink.tests.functional;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testlink.models.TestCase;
import testlink.models.TestStep;
import testlink.models.TestSuite;
import testlink.selenium.DriverFactory;
import testlink.selenium.DriverWrapper;
import testlink.steps.TestSteps;
import utils.PropertyLoader;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ivan.Ivanyuk on 3/20/2015.
 */
public class CreateSuiteTest extends TestSteps {
    @BeforeSuite
    public void initEnv() {
        try {
            driver = new DriverWrapper(DriverFactory.makeDriver(PropertyLoader.loadProperty("browser")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                new Object[]{"Conspicuous name","Some details", "New test case", "Test summary", "Test preconditions", Arrays.asList(new TestStep("action1", "result1"), new TestStep("action2", "result2"), new TestStep("action3", "result3"))}
        };
    }

    @Test(dataProvider = "testData")
    public void createSuite(String testSuiteName, String testSuiteDetails, String testCaseTitle, String testCaseSummary, String testCasePreconditions,  List<TestStep> testSteps) {
        Assert.assertTrue(login("admin", "admin"), "Login failed");
        TestSuite testSuite = new TestSuite(testSuiteName, testSuiteDetails);
        TestCase testCase = new TestCase(testCaseTitle, testCaseSummary, testCasePreconditions);
        Assert.assertTrue(createTestSuite(testSuite, testCase, testSteps));
    }

    @AfterSuite
    public void shutEnv() {
        if (driver != null) driver.quit();
    }
}
