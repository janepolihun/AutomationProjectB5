package io.loop.test.day_8;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*login as an advisor
go to users
validate that full name for alex.de.souza@gmail.com is AAlex De Souza
validate that user name for alex.de.souza@gmail.com is alexdesouze
validate that phone number for alex.de.souza@gmail.com is +994512060042
validate that role for alex.de.souza@gmail.com is client
validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1

 */
public class HWT1_verify_user_details extends TestBase {
    @Test
    public void verify_user_details() throws InterruptedException {
        // using docuportUtils go to docuport and login as "advisor"
        DocuportUtils.login(driver,"advisor" );
        // go to users
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement usersButton = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        usersButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //validate that full name for alex.de.souza@gmail.com is Alex De Souza
        String expectedFullName = "AAlex De Souza";
        String actualFullName = DocuportUtils.returnAnyFieldFromTable(driver,"alex.de.souza@gmail.com", "Full name" );
        assertEquals(actualFullName,expectedFullName, "The full name DOES NOT MATCH");
        //validate that user name for alex.de.souza@gmail.com is alexdesouze
        String expectedUsername = "alexdesouze";
        String actualUsername = DocuportUtils.returnAnyFieldFromTable(driver, "alex.de.souza@gmail.com", "Username");
        assertEquals(actualUsername,expectedUsername, "The username DOES NOT MATCH");
        //validate that phone number for alex.de.souza@gmail.com is +994512060042
        String expectedPhoneNumber = "+994512060042";
        String actualPhoneNumber = DocuportUtils.returnAnyFieldFromTable(driver, "alex.de.souza@gmail.com", "Phone Number");
        assertEquals(actualPhoneNumber,expectedPhoneNumber, "The phone number DOES NOT MATCH");
        //validate that role for alex.de.souza@gmail.com is client
        String actualRole = DocuportUtils.returnAnyFieldFromTable(driver, "alex.de.souza@gmail.com", "Role");
        String expectedRole = "Client";
        assertEquals(actualRole,expectedRole, "The role DOES NOT MATCH");
        //validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
        String actualAdviser = DocuportUtils.returnAnyFieldFromTable(driver,"alex.de.souza@gmail.com",  "advisor" );
        String expectedAdviser = "Batch1 Group1";
        assertEquals(actualAdviser, expectedAdviser, "The adviser DOES NOT MATCH");
    }
}

