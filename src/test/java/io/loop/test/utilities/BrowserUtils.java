package io.loop.test.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class BrowserUtils {
    /**
     * validate if the driver switch to the expected url or title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author NSH
     * implements assertion
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle){
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();

        // get all window handles, switch one by one each time check if the url matches exp to stop
        // var windowHandles
        Set<String> windowHandle = driver.getWindowHandles();
        for(String each : windowHandle){
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }
        }
        // after stopping on expected url, validate the title
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * @param driver
     * @param targetTitle
     * @author NSH
     */
public static void switchToWindow(WebDriver driver, String targetTitle){
    String origin = driver.getWindowHandle();
    for(String handle : driver.getWindowHandles()){
        driver.switchTo().window(handle);
        if (driver.getTitle().contains(targetTitle)) {
            return;
        }
    }
    driver.switchTo().window(origin);

    }
}

