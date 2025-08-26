package io.loop.test.day_7;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

/*
task1
=============
login as an advisor
go to received document
click search
validate that status dropdown does not allow to select multiple
validate that tags dropdown allows to select multiple
 */
public class HwTask1 extends TestBase {
    @BeforeMethod
    public void beforeMethod() {
        driver.get(DocuportConstants.DOCUPORT_TEST);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement name = driver.findElement(By.xpath("//input[@id='input-14']"));
        name.sendKeys(DocuportConstants.USERNAME_ADVISOR);

        WebElement password = driver.findElement(By.xpath("//input[@id='input-15']"));
        password.sendKeys(DocuportConstants.PASSWORD_GROUP2);

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        //go to received document
        WebElement receivedDocs = driver.findElement(By.xpath("//span[@class='body-1' and text()='Received docs']"));
        receivedDocs.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //click search
        WebElement search = driver.findElement(By.xpath("//div[@class='d-flex align-center justify-start justify-sm-end flex-wrap']/button/following-sibling::button/following-sibling::button"));
        search.click();
    }

    @AfterMethod
    public void afterMethod() {
       driver.quit();
    }


        @Test
        public void docupotTest() throws InterruptedException {



           /* task1
                    =============
                    login as an advisor
            go to received document
            click search
            validate that status dropdown does not allow to select multiple
            validate that tags dropdown allows to select multiple

            */


            // click "Status bottom"
            WebElement select = driver.findElement(By.xpath("//div[@class='v-select__slot'][.//label[normalize-space()='Status']]"));
            select.click();
            // find xpath for "In progress"
            WebElement selectInProgress = driver.findElement(By.xpath("//div[text()='In progress']"));
            //find xpath for "Done"
            WebElement selectDone = driver.findElement(By.xpath("//div[text()='Done']"));
            // create the List with my options
            List <WebElement> options =new ArrayList<>( Arrays.asList(selectInProgress, selectDone));
            // loop through for "click on these options"
            for (int i = 0; i < options.size(); i++) {
                options.get(i).click();
                Thread.sleep(3000);
                select.click();
            }
            // create a new List with chosen options
            List <WebElement> findElements = driver.findElements(By.xpath("//div[@class='v-select__selection v-select__selection--comma']"));

            if(findElements.size()==1){
                System.out.println("Dropdown IS NOT Multiselect");
            } else {
                System.out.println("Dropdown IS Multiselect");
            }
    }

      @Test
      public void docuportTest1() throws InterruptedException {
          //div[@class='v-select__slot'][.//label[normalize-space()='Tags']]
          WebElement tagsButton = driver.findElement(By.xpath("//div[@class='v-select__slot'][.//label[normalize-space()='Tags']]"));
          tagsButton.click();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

          WebElement otherDocumentsBottom = driver.findElement(By.xpath("//span[normalize-space()='Other Documents']"));
          otherDocumentsBottom.click();
          WebElement irsStateLetterButton = driver.findElement(By.xpath("//span[normalize-space()='IRS/State Letter']"));
          irsStateLetterButton.click();
          tagsButton.click();
          List <WebElement> findOptionsForTags = driver.findElements(By.xpath(".//button[@aria-label='Close']"));

          if(findOptionsForTags.size()>1){
              System.out.println("Dropdown IS Multiselect");
          }else{
              System.out.println("Dropdown IS NOT Multiselect");
          }

      }

}
