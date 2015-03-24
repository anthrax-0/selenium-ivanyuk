package homework1;

import functional.BaseWebdriverTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

/**
 * Created by Ivan Ivanyuk on 3/20/2015.
 */
public class ExceptionProneTest extends BaseWebdriverTest{
    @Test(expectedExceptions = NoSuchElementException.class)
    public void exceptionTest(){
        driver.get("http://www.w3.org/");
        driver.findElement(By.id("w3c_footers"));
    }

}
