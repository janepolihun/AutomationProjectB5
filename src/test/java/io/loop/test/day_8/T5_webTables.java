package io.loop.test.day_8;

 /*
    1. login as an advisor
    2. go to users
    3. validate that full name for alex.de.souza@gmail.com is AAlex De Souza
    4. validate that user name for alex.de.souza@gmail.com is alexdesouze
    5. validate that phone number for alex.de.souza@gmail.com is +994512060042
    6. validate that role for alex.de.souza@gmail.com is client
    7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
     */

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class T5_webTables extends TestBase {

    @Test
    public void testWebTables() throws InterruptedException {
        DocuportUtils.login(driver, "advisor");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement users = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        users.click();
        String expectedFullName = "AAlex De Souza";
        String actualFullName = DocuportUtils.returnAnyFieldFromTable(driver, "alex.de.souza@gmail.com", "Full name");
        assertEquals(actualFullName, expectedFullName, "Actual DOES NOT MATCH");
        System.out.println("actual name: " + actualFullName);

        //WebElement email = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        //users.click();
       // String expectedFullName = "AAlex De Souza";
        //String actualFullName = DocuportUtils.returnAnyFieldFromTable(driver, "alex.de.souza@gmail.com", "Full name");
        assertEquals(actualFullName, expectedFullName, "Actual DOES NOT MATCH");
        System.out.println("actual name: " + actualFullName);

    }
}
