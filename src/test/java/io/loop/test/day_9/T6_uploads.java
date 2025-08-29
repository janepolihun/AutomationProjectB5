package io.loop.test.day_9;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class T6_uploads {

    /*
    1. Go to “http://demo.guru99.com/test/upload”
    2. Upload file into Choose File
    3. Click terms of service check box
    4. Click Submit File button
    5. Validate expected message appeared. Expected: “1 file has been successfully uploaded.
    */

    @Test
    public void upload_file() throws InterruptedException {
        Driver.getDriver().get("http://demo.guru99.com/test/upload");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        WebElement choseFile = Driver.getDriver().findElement(By.xpath("//input[@type='file']"));
        String path = "/Users/janepoligyn/Desktop/text";
        choseFile.sendKeys(path);

        WebElement checkBox = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();

        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();

        String expected = "1 file\nhas been successfully uploaded.";
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//h3[@id='res']"));
        Thread.sleep(3000);
        assertEquals(successMessage.getText(), expected, "Actual text does not match expected text.");
    }
}
