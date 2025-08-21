package io.loop.test.day_6;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*
   1. Open Chrome browse
   2. Go to http://the-internet.herokuapp.com/dropdown
   3. Verify “Dropdown list” default selected value is correct - Expected: “Please select an option”
    */
public class T5_simple_dropdown {
    WebDriver driver;
    String actual;
    String expected = "Please select an option";


    @BeforeClass
    public void setUpMethod(){
        driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void dropDownTest(){

        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // create the dropdown
        // create WebElement
        // WebElement dropdownElement =  driver.findElement(By.xpath("dropdown"));
        //Select dropdown = new Select(dropdownElement);

        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        dropdown.getFirstSelectedOption().getText();
        actual = dropdown.getFirstSelectedOption().getText();
        assertEquals(actual, expected, "Dropdown selected not match expected" + expected);

    }

}
