package io.loop.test.day_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        Thread.sleep(3000);

        driver.get("https://www.loopcamp.io");

        Thread.sleep(3000);

        driver.navigate().to("https://www.google.com");

        driver.navigate().back();
        driver.navigate().forward();

        driver.navigate().refresh();

        driver.quit();
    }
}
