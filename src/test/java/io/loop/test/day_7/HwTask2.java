package io.loop.test.day_7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*
task2
=============
go to https://demoqa.com/alerts
click - click button to see alert
handle alert
click - On button click, alert will appear after 5 seconds
handle alert
click - On button click, confirm box will appear
click ok and validate - You selected Ok
after that do it again this time cancel and validate - You selected Cancel
click - On button click, prompt box will appear
enter "Loop Academy" and validate You entered Loop Academy
 */
public class HwTask2 extends TestBase {


    @Test
    public void alertsTest() {

        driver.get("https://demoqa.com/alerts");
        //click - click button to see alert
        WebElement clickButtonToSeeAlerts = driver.findElement(By.xpath("//button[@id='alertButton']"));
        clickButtonToSeeAlerts.click();

        //handle alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

        @Test
         public void alertsTest2() throws InterruptedException {
            driver.get("https://demoqa.com/alerts");

        //click - On button click, alert will appear after 5 seconds
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement clickButtonAppearAfter5Seconds = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
            Thread.sleep(5000);
            clickButtonAppearAfter5Seconds.click();
           //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); - WHY IT DOES NOT WORK?
            Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        alert.accept();


    }

    @Test (priority = 1)
    public void alertsTest3() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        // click - On button click, confirm box will appear
        WebElement confirmBoxWillAppear = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        // it should to roll down to click on bottom
        // sometimes it is in time
        confirmBoxWillAppear.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement confirmMessage = driver.findElement(By.xpath("//span[@id='confirmResult']"));
        String expectedTextForOk = "You selected Ok";
        String actualTextForOk = confirmMessage.getText();
        assertEquals(actualTextForOk, expectedTextForOk, "Actual does not match expected text");

        // click and dismiss the alert
        confirmBoxWillAppear.click();
        driver.switchTo().alert().dismiss();

        String expectedTextForCancel = "You selected Cancel";
        String actualTextForCancel = confirmMessage.getText();
        assertEquals(actualTextForCancel,expectedTextForCancel, "Actual does not match expected text" );

    }

    @Test
    public void alertsTest4() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        //click - On button click, prompt box will appear
        //enter "Loop Academy" and validate You entered Loop Academy

        WebElement promptBoxWillAppear = driver.findElement(By.xpath("//button[@id='promtButton']"));
        promptBoxWillAppear.click();
        String promptText = "Loop Academy";

        driver.switchTo().alert().sendKeys(promptText);
        driver.switchTo().alert().accept();
        WebElement promptMessage = driver.findElement(By.xpath("//span[@id='promptResult']"));
        String expectedPromptText = "You entered " + promptText ;
        String actualPromptText = promptMessage.getText();

        assertEquals(actualPromptText,expectedPromptText, "Actual does not match expected text" );

    }
}
