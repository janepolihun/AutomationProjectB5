package io.loop.test.day_4;
/*
  /*
    go to url: https://loopcamp.vercel.app/registration_form.html
    validate header text expected:  Registration form
    validate placeholder attribute value for first name expected - first name
     */

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {
    public static void main(String[] args) {


        //go to url
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
        driver.navigate().to(LoopCampConstants.REGISTRATION_FORM_URL);

        // spy / locate the element - header
        WebElement header = driver.findElement(By.tagName("h2"));

       // use getText() method
        String actualHeaderForForm = header.getText();

        //validation
         if(actualHeaderForForm.equals(LoopCampConstants.EXPECTED_HEADER_FOR_FORM)){
             System.out.println("expected header for form: \"" + LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\", matches actual header: \"" + actualHeaderForForm + "\" => TEST PASS" );
         } else {
             System.out.println("expected header for form: \"" + LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\", DOES NOT matches actual header: \"" + actualHeaderForForm + "\" => TEST FAIL" );
         }

         // use get attribute method which return the value of attribute

        WebElement firstNamePlaceholder = driver.findElement(By.name("firstname"));
        String actualPlaceholderForFirstname = firstNamePlaceholder.getAttribute("placeholder");

        //validation
        if(actualPlaceholderForFirstname.equals(LoopCampConstants.EXPECTED_PLACEHOLDER_FOR_FIRSTNAME)){
            System.out.println("expected placeholder for form: \"" + LoopCampConstants.EXPECTED_PLACEHOLDER_FOR_FIRSTNAME + "\", matches actual placeholder: \"" + actualPlaceholderForFirstname + "\" => TEST PASS" );
        } else {
            System.out.println("expected placeholder for form: \"" + LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\", DOES NOT matches actual placeholder: \"" + actualPlaceholderForFirstname + "\" => TEST FAIL" );
        }
    }
}
