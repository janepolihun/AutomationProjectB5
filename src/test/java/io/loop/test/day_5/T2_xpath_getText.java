package io.loop.test.day_5;
/*
 1. open chrome
 2. go to docuport
 3. click on forgot password
 4. validate url contains: reset-password
 5. validate - Enter the email address associated with your account
 6. enter forgotpasswordg1@gmail.com to email box
 7. validate send button is displayed
 8. validate cancel button is displayed
 9. click send button
 10. validate - We've sent you an email with a link to reset your password. Please check your email
  */

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.*;

public class T2_xpath_getText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
        driver.get(DocuportConstants.DOCUPORT_TEST);

        // click on forgot password link
        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href= '/reset-password']"));
        forgotPassword.click();

       // validate url contains: reset-password
        String actualURL = driver.getCurrentUrl();

        if (actualURL.equals(DocuportConstants.FORGOT_PASSWORD_URL)) {
            System.out.println("Test Pass!");
        }else{
            System.out.println("Test Fail!");
        }

        // validate - Enter the email address associated with your account
        WebElement validateMessage = driver.findElement(By.xpath("//div[contains(text(),'Enter')]"));
        String actualValidateMessage = validateMessage.getText();

        if(actualValidateMessage.equals(DocuportConstants.RESET_PASSWORD_MESSAGE)){
            System.out.println("Test Pass!");
        }else{
            System.out.println("Test Fail!");
        }

        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@id,'input')]"));
        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_PASSWORD_RESET);

         //   7. validate send button is displayed
         //   8. validate cancel button is displayed


        WebElement cancelButton = driver.findElement(By.xpath("//span[contains(text(),'Cancel')]"));
       // System.out.println(cancelButton.isDisplayed());

        if(cancelButton.isDisplayed()){
            System.out.println("Test Pass!");
        }else{
            System.out.println("Test Fail!");
        }

        WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space()='Send']"));

        if(sendButton.isDisplayed()){
            System.out.println("Test Pass!");
        }else{
            System.out.println("Test Fail!");
        }

        sendButton.click();

         // Thread.sleep(5000);
        //  validate - We've sent you an email with a link to reset your password. Please check your email
        WebElement successMessage;

        try{
            successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));

        } catch( NoSuchElementException nse) {

            nse.printStackTrace();
            Thread.sleep(5000);
            successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));
        }

        System.out.println("successMessage text: " + successMessage.getText());

        Thread.sleep(10000);

        try {
            System.out.println("successMessage text: " + successMessage.getText());
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            System.out.println("Element is not here anymore");
        }
    }
}
