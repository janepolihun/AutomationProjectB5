package io.loop.test.day_3.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Task 1

1- Open a chrome browser
2- Go to: https://google.com/
3- Click to Gmail from top right.
4- Validate title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Validate title equals:
Expected: Google

 */
public class Task1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://google.com/");
        WebElement aboutLink = driver.findElement(By.linkText("Gmail")) ;
        aboutLink.click();

        // validation
        String expectedTitle = "Gmail";

        // actual title
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Actual title: " + actualTitle + ", matches expected title: " + expectedTitle + ". => TEST PASS");
        } else {
            System.out.println("Actual title: " + actualTitle + ",DOES NOT matches expected title: " + expectedTitle + ". => TEST FAIL");
        }

        driver.navigate().back();

        String expected1 = "Google";
        String actual = driver.getTitle();
        if (actual.contains(expected1)){
            System.out.println("Actual title: " + actualTitle + ", matches expected title: " + expectedTitle + ". => TEST PASS");

        }else{
            System.out.println("Actual title: " + actualTitle + ",DOES NOT matches expected title: " + expectedTitle + ". => TEST FAIL");
        }

    }

}
