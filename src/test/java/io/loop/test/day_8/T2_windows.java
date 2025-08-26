package io.loop.test.day_8;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static org.testng.Assert.assertEquals;

    /*
    1. Open a chrome browser
    2. Go to : http://the-internet.herokuapp.com/windows
    3. Assert: Title is “The Internet”
    4. Click to: “Click Here” link
    5. Switch to new Window.
    6. Assert: Title is “New Window”
     */

public class T2_windows extends TestBase {

    @Test
    public void test_window_handle() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //3. Assert: Title is “The Internet”
        assertEquals(driver.getTitle(), "The Internet", "Actual DOES NOT match expected window title");

        // print out the current window handle
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        // 4. Click to: “Click Here” link
        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHere.click();
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        String originalWindow = driver.getWindowHandle();

        // get all window
        Set <String> windowHandles = driver.getWindowHandles();
        //loop through and stay at the last window
        for(String each :  windowHandles){
            System.out.println("each window handle: " + each);
            driver.switchTo().window(each);
        }

        System.out.println("driver.getTitle() = " +  driver.getTitle());
        driver.switchTo().window(originalWindow);
        System.out.println("driver.getTitle() = " +  driver.getTitle());
    }
}
