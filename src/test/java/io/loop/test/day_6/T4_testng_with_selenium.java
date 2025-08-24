package io.loop.test.day_6;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class T4_testng_with_selenium {

    WebDriver driver;
    String actual;
    String expected;

    @BeforeMethod
    public void setUpd() {
        driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
    }

    @Test
    public void googleTitle(){
        driver.get("https://www.google.com");
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
        expected = "Google";
        actual = driver.getTitle();
        assertEquals(actual, expected, " Actual: " + actual + " DOES NOT match expected" + expected);
    }

    @Test
    public void DocuportTitle(){
        driver.get(DocuportConstants.DOCUPORT_TEST);
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
        expected = "Docuport";
        actual = driver.getTitle();
        assertEquals(actual, expected, " Actual: " + actual + " DOES NOT match expected" + expected);
    }


}
