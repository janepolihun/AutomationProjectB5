package io.loop.test.day_7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

/*
task3
=============
go to https://demoqa.com/nestedframes
Validate "Child Iframe" text
Validate "Parent Iframe" text
Validate the "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame."
 */
public class HwTask3 extends TestBase {

    @Test
    public void nestedFrame(){
        // go to https://demoqa.com/nestedframes
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().window().maximize();
        // switch to parent iframe with id
        driver.switchTo().frame("frame1");
        // locate "Child Iframe"
        WebElement iframe = driver.findElement(By.xpath("//iframe[@srcdoc]"));
        // switch to "Child Iframe"
        driver.switchTo().frame(iframe);
        // with xpath find text in iframe
        WebElement childIframe = driver.findElement(By.xpath("//*[contains(text(),'Child Iframe')]"));
        String actualChildIframeText = childIframe.getText();
        String expectedChildIframeText = "Child Iframe";
        // Validate "Child Iframe" text
        assertEquals(actualChildIframeText, expectedChildIframeText, "Text in the Child Iframe DOES NOT match");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.switchTo().parentFrame();
        // * - means find in any tags on the page
        WebElement parentIframe = driver.findElement(By.xpath("//*[contains(text(),'Parent')]"));
        String actualParentIframeText = parentIframe.getText();
        String expectedParentIframeText = "Parent frame";
        // Validate "Parent Iframe" text
        assertEquals(actualParentIframeText,expectedParentIframeText,  "Text in the Parent Iframe DOES NOT match");

        // Validate the "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame."
        driver.switchTo().defaultContent();
        WebElement sampleNestedIframePageText = driver.findElement(By.xpath("//div[contains(text(),'Sample Nested Iframe page')]"));
        assertFalse(!sampleNestedIframePageText.isDisplayed(), "\"Sample Nested Iframe page\" DOES NOT displayed");
    }

}
