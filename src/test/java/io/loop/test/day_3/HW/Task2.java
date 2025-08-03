package io.loop.test.day_3.HW;

import org.apache.commons.exec.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*Open Chrome browser
Go to https://www.temu.com/
Search for “wooden spoon”
Validate title:
Expected: “Temu”

 */
public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.temu.com/");

        // locate the element

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // chatGPT helps me
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchInput")));

        searchBox.sendKeys("wooden spoon", Keys.ENTER);

        String expectedTitle = "Temu";

        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Actual title: " + actualTitle + ", matches expected title: " + expectedTitle + ". => TEST PASS");
        } else {
            System.err.println("Actual title: " + actualTitle + ",DOES NOT matches expected title: " + expectedTitle + ". => TEST FAIL");
        }

    }

}
