package io.loop.test.day_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsPractice {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);


        driver.get("https://google.com");
    }
}
