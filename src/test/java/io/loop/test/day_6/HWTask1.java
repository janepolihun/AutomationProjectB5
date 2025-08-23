package io.loop.test.day_6;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*
task1
=============

go to http://the-internet.herokuapp.com/dropdown
validate "Please select an option" is selected by default
Choose option 1 and validate that it is selected
Choose option 2 and validate that it is selected
Validate dropdown name is "Dropdown List"
 */
public class HWTask1 {
    // create instance var driver
    WebDriver driver;
    String defaultSelection;
    String actualOption1;
    String actualOption2;
    String actualName;
    String expectedOption1 = "Option 1";
    String expected = "Please select an option";
    String expectedName = "Dropdown List";
    String expectedOption2 = "Option 2";



    @BeforeMethod
    public void setUpMethod (){
        // navigate to chrome driver (by default)
        driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterClass
    public void tearsDownMethod(){
        driver.quit();
    }

        @Test
        public void validationIsSelectionByDefault() {
        // navigate to the web page
        // set up waiting time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // create the dropdown // //select[@id='dropdown']
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        // validate "Please select an option" is selected by default
        defaultSelection = dropdown.getFirstSelectedOption().getText();
        assertEquals(defaultSelection, expected, "Actual" + defaultSelection + "DOES NOT match expected " + expected);
    }
        @Test
        public void selectedOption1() {
            Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

            // Choose option 1 and validate that it is selected
            // Select byIndex and validate
            dropdown.selectByIndex(1);
            actualOption1 = dropdown.getFirstSelectedOption().getText();
            assertEquals(actualOption1, expectedOption1, "Actual \"Option 1\"" + actualOption1 + "DOES NOT match" + expectedOption1);
        }
        
        @Test
        public void selectedOption2() {
            Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

            // Choose option 2 and validate that it is selected

            dropdown.selectByIndex(2);
            actualOption2 = dropdown.getFirstSelectedOption().getText();
            assertEquals(actualOption2, expectedOption2, "Actual \"Option 2\"" + actualOption2 + "DOES NOT match" + expectedOption2);
        }

        @Test
        public void validateName(){
            WebElement signatureText = driver.findElement(By.xpath("//h3[contains(text(),'Dropdown')]"));
            actualName = signatureText.getText();
            assertEquals(actualName, expectedName, "Actual text: " + actualName + " DOES NOT match " + expectedName );
        }


}




