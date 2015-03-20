package functional;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * Created by Ivan.Ivanyuk on 3/17/2015.
 */
public class XpathCSSSelector extends BaseWebdriverTest {
    @Test
    public void selectJob() {
        driver.get("http://www.valvesoftware.com/jobs/job_postings.html");
        //driver.get("http://www.valvesoftware.com/news/");
        assertNotNull(driver.findElement(By.xpath(".//*[contains(@id,'software_engineer')]/div[1]")), "No Software Engineer vacancy on the site!");
        assertNotNull(driver.findElement(By.cssSelector(".job_position_container[id*='psychologist']")), "No Psychologist vacancy on the site!");
    }
}
