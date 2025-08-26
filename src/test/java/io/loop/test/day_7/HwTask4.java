package io.loop.test.day_7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*
task4
=============
go to https://loopcamp.vercel.app/nested-frames.html
validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"

 */
public class HwTask4 extends TestBase {

    @Test
    public void validateIframes(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // validate "LEFT",
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//*[contains(text(),'LEFT')]"));
        String actualLeft = left.getText();
        String expectedLeft = "LEFT";
        assertEquals(actualLeft.trim(), expectedLeft, "Left text DOES NOT match");
        //validate "MIDDLE"
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.xpath("//*[contains(text(),'MIDDLE')]"));
        String actualMiddle = middle.getText();
        assertEquals(actualMiddle.trim(), "MIDDLE", "Middle text DOES NOT match");
        driver.switchTo().parentFrame();
        //validate "RIGHT"

        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.xpath("//*[contains(text(),'RIGHT')]"));
        assertEquals(right.getText().trim(), "RIGHT", "Right text DOES NOT match");
        driver.switchTo().defaultContent();
        //validate "BOTTOM"
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//*[contains(text(),'BOTTOM')]"));
        assertEquals(bottom.getText().trim(), "BOTTOM", "Bottom text does not match");


    }
}
