package io.loop.test.day_4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TO_Temu {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");

        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        String searchText = "wooden spoon";
        searchBox.sendKeys(searchText + Keys.ENTER);

        String expectedTitle = "Etsy";

        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Actual title: " + actualTitle + ", matches expected title: " + expectedTitle + ". => TEST PASS");
        } else {
            System.err.println("Actual title: " + actualTitle + ",DOES NOT matches expected title: " + expectedTitle + ". => TEST FAIL");
        }

    }
}
