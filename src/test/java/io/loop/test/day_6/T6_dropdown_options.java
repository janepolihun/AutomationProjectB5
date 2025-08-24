package io.loop.test.day_6;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*
    1. Open Chrome browser
    2. Go to https://demoqa.com/select-menu
    3. go old style select menu
    4. Select Yellow and validate
    5. Select Red and validate
    6. Select White and validate
    Use all Select options. (visible text, value, index)
    */
public class T6_dropdown_options {
WebDriver driver;


@BeforeMethod
    public void setUpMethod(){
    driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
    driver.manage().window().maximize() ;
    driver.get("https://demoqa.com/select-menu");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}
@AfterMethod
    public void tearDownMethod(){
    driver.quit();
}
@Test
    public void colorTest(){
    //create a dropdown
    Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));

    // select yellow and validate - select by index
    dropdown.selectByIndex(3);

    // validate yellow
    String actualYellow = dropdown.getFirstSelectedOption().getText();
    String expectedYellow = "Yellow";
    assertEquals(dropdown.getFirstSelectedOption().getText(),"Yellow", " Actual: " + actualYellow + " DOES NOT match expected" + expectedYellow);

    // select red and validate - select by Value
    dropdown.selectByValue("red");
    String actualRed = dropdown.getFirstSelectedOption().getText();
    String expectedRed = "Red";
    assertEquals(actualRed,expectedRed, " Actual: " + actualRed + " DOES NOT match expected" + expectedRed );

    // select white and validate - by visible text
    dropdown.selectByVisibleText("White");
    String actualWhite = dropdown.getFirstSelectedOption().getText();
    String expectedWhite = "White";
    assertEquals(actualWhite, expectedWhite , " Actual: " + actualWhite + " DOES NOT match expected: " + expectedWhite);


}


}
