package testlink.steps;

import org.openqa.selenium.WebDriver;
import testlink.models.TestCase;
import testlink.models.TestStep;
import testlink.models.TestSuite;
import testlink.pages.HomePage;
import testlink.pages.LoginPage;
import testlink.pages.SpecificationPage;
import testlink.selenium.DriverWrapper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ivan.Ivanyuk on 3/20/2015.
 */
public class TestSteps {
    protected DriverWrapper driver;

    public boolean login(String login, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        return loginPage.login(login, password).isOpened();
    }

    public boolean createTestSuite(TestSuite testSuite, TestCase testCase, List<TestStep> testSteps) {
        HomePage homePage = new HomePage(driver);
        homePage.openSpecificationPage();
        SpecificationPage specificationPage = new SpecificationPage(driver);
        //specificationPage.createTestSuite(testSuite);
        //specificationPage.createTestCase(testSuite,testCase);
        specificationPage.createTestSteps(testSuite,testCase,testSteps);
        return true;

    }
}
