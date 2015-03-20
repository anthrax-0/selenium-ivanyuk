package homework1;

import functional.BaseWebdriverTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;

/**
 * Created by Ivan Ivanyuk on 3/20/2015.
 */
public class ExceptionSafeTest extends BaseWebdriverTest{
    @Test
    public void failWithAssert(){
        driver.get("http://www.w3.org/");
        List<WebElement> result = driver.findElements(By.id("w3c_footers"));
        assertFalse(result.isEmpty(), "Element not found!");
    }

}
