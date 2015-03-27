package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testlink.selenium.DriverWrapper;

/**
 * Created by Ivan.Ivanyuk on 3/20/2015.
 */
public class HomePage extends AbstractPage{

    private static final By version = By.xpath("//div[@class='menu_title']/span[contains(text(),'TestLink')]");

    public HomePage(DriverWrapper driver) {
        super(driver);
    }

    public boolean isOpened() {
        driver.switchTo().frame(driver.findElement(headerFrame));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(version));
        return !driver.findElements(version).isEmpty();
    }

    public SpecificationPage openSpecificationPage(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.name("titlebar"))).findElement(By.xpath("//a[contains(@accesskey,'t')]")).click();
        return new SpecificationPage(driver);
    }
}
