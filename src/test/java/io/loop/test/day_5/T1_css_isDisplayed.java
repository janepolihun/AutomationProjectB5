package io.loop.test.day_5;
    /*
    1- Open a chrome browser
    2- Go to: https://www.nba.com
    3- Locate all the links in the page.
     */

     /*
    https://the-internet.herokuapp.com/forgot_password
     */

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_css_isDisplayed {
    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement forgotPasswordHeading = driver.findElement(By.cssSelector("div[class='example']>h2"));

        // print
        System.out.println("forgotPasswordHeading.getText() = " + forgotPasswordHeading.getText());
        System.out.println("forgotPasswordHeading.isDisplayed() = " + forgotPasswordHeading.isDisplayed());








    }

}
