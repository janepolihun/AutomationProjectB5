package io.loop.test.day_8;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/*
go to https://loopcamp.vercel.app/
click "Multiple Windows" link
Validate "Powered by Loopcamp" is displayed
Validate title is "Windows"
Click - click here
Switch to new window and validate title

 */
public class HWT3_multiple_windows_test extends TestBase {
    @Test
    public void multiple_windows_test() {
        //go to https://loopcamp.vercel.app/
        driver.get("https://loopcamp.vercel.app/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //click "Multiple Windows" link
        WebElement multipleWindows = driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]"));
        multipleWindows.click();

        //Validate "Powered by Loopcamp" is displayed
        WebElement poweredByLoopcamp = driver.findElement(By.xpath("//div[contains(text(),'Powered by ')]"));
        assertTrue(poweredByLoopcamp.isDisplayed(), "Powered by Loopcamp is NOT displayed");

        //Validate title is "Windows"
        assertEquals(driver.getTitle(), "Windows", "Title is NOT \"Windows\".");
        //Click - click here
        WebElement clickHere = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
        clickHere.click();
        // Switch to new window and validate title
        BrowserUtils.switchToWindow(driver, "New Window");
        assertEquals(driver.getTitle(), "New Window", "Actual DOES NOT MATCH expected.");
        System.out.println("driver.getTitle() " + driver.getTitle());




    }
}
