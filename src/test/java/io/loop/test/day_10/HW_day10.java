package io.loop.test.day_10;
/*
task1
Open a chrome browser
Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
Click and hold small circle
Move it on top of the big circle
validate “Now drop…” text appears on big circ
 */

import io.loop.pages.LoopPracticeDragDropPage;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

import static org.testng.Assert.assertEquals;

public class HW_day10 {

    LoopPracticeDragDropPage loopPracticeDropPage;
    Actions actions;

    @BeforeMethod
    public void test1() {
        // Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        loopPracticeDropPage =  new LoopPracticeDragDropPage();
        actions = new Actions(Driver.getDriver());
    }

    @AfterMethod
    public void tearDownMethod(){
        Driver.getDriver().quit();
    }

    @Test
    public void test2() {
        // Click and hold small circle
       actions.moveToElement(loopPracticeDropPage.smallCircle)
               .clickAndHold()
               .moveToElement(loopPracticeDropPage.bigCircle)
               .perform();
       assertEquals(loopPracticeDropPage.bigCircle.getText(),"Now drop...", "Text DOES NOT match");
    }
}
