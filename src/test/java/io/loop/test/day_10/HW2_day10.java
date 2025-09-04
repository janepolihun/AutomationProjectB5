package io.loop.test.day_10;

import io.loop.pages.LoopPracticeDragDropPage;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*
task2
Open a chrome browser
Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
Click and hold small circle
Dropped anywhere outside of big circle
validate “Try again!” text appears on big circle
 */
public class HW2_day10 {
    LoopPracticeDragDropPage loopPracticeDropPage;
    Actions actions;
    @BeforeMethod
    public void setUp() {
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
    public void test2() throws InterruptedException {
       //Click and hold small circle
        actions.moveToElement(loopPracticeDropPage.smallCircle)
                .clickAndHold()
                .pause(3000)
                .moveByOffset(0,200)
                .perform();

        assertEquals(loopPracticeDropPage.bigCircle.getText(), "Try again!", "Text DOES NOT match");


    }
}
