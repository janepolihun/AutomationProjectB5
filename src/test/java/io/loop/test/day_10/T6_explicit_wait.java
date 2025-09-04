package io.loop.test.day_10;

import io.loop.pages.LoopPracticeDynamicLoading7Page;
import io.loop.test.utilities.BrowserUtils;
import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

/*
  1. go https://loopcamp.vercel.app/dynamic_loading/7.html
  2. Wait until title is “Dynamic title”
  3. Assert: Message “Done!” is displayed.
  4. Assert: Image is displayed.
*/
public class T6_explicit_wait {

    LoopPracticeDynamicLoading7Page  loopPracticeDynamicLoading7Page;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        loopPracticeDynamicLoading7Page = new LoopPracticeDynamicLoading7Page();
        Driver.getDriver().get(ConfigurationReader.getProperties("loop.practice"));
    }
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void explicit_wait_test() {
        BrowserUtils.loopLinkClick("Dynamic Loading");
        loopPracticeDynamicLoading7Page.getDynamicLoading7.click();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        assertTrue(loopPracticeDynamicLoading7Page.image.isDisplayed(), "Element is NOT displayed");
    }
}
