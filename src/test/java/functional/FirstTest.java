package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * Created by Ivan.Ivanyuk on 3/13/2015.
 */
public class FirstTest extends BaseWebdriverTest {
    private static final By searchField = By.id("lst-ib");

    @DataProvider
    public Object[][] keyWords() {
        return new Object[][]{
                new Object[]{"осциллограф", "www.tehencom.com", 3}
        };
    }

    @Test(dataProvider = "keyWords")
    public void firstTest(String keyWord, String url, int maxPageDepth) throws InterruptedException {
        driver.get("http://google.com");
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(keyWord);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        WebElement result = null;
        WebDriverWait wait = new WebDriverWait(driver, 15);
        int linkRank = 0;
        for (int i = 0; i < maxPageDepth; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("pnnext")));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("cite")));
            //Thread.sleep(1000); Can be required for some cases
            for (WebElement cite : driver.findElements(By.tagName("cite"))) {
                linkRank++;
                try {
                    if (cite.getText().contains(url)) {
                        result = cite;
                        break;
                    }
                } catch (StaleElementReferenceException ex) {
                    System.out.print("Add timeout at least 1s to allow page to load fully.\n");
                    throw ex;
                }
            }
            if (result != null) {
                break;
            } else {
                driver.findElement(By.id("pnnext")).click();
            }
        }
        assertNotNull(result, "URL not found!\n");
        System.out.print("URL: " + url + " has rank " + linkRank);
    }
}
