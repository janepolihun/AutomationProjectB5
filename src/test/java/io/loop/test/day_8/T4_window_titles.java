package io.loop.test.day_8;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class T4_window_titles extends TestBase {
/*
            ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
            ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
            ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

             */

        @Test
        public void windowHandleTitle(){
            driver.get("http://google.com");
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("http://etsy.com");
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("http://facebook.com");
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("http://amazon.com");
            driver.switchTo().newWindow(WindowType.TAB);

            System.out.println("driver.getTitle() = " + driver.getTitle());

//            Set<String> windowHandle = driver.getWindowHandles();
//            for(String window : windowHandle){
//                driver.switchTo().window(window);
//                if(driver.getTitle().contains("Google")){
//                    break;
//                }
//            }

            //BrowserUtils.switchWindowAndValidate(driver, "www.loopcamp.io", "Loopcamp");
            BrowserUtils.switchToWindow(driver,"Amazon");







        }
    }

