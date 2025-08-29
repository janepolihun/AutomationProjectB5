package io.loop.test.day_9;

import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import static io.loop.test.utilities.Driver.driver;
import static org.testng.Assert.assertEquals;

/*
    1. go to "https://www.google.com"
    2. write "Loop Academy" and search
    3. validate title: Loop Academy - Google Search
     */
public class T4_google_search {

    @Test
    public void googleSearch() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getProperties("google.url"));
        System.out.println("((RemoteWebDriver) Driver.getDriver()).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        searchBox.sendKeys("Loop Academy" + Keys.ENTER);
        String actualTitle = Driver.getDriver().getTitle();
        Thread.sleep(3000);
        assertEquals(actualTitle, "Loop Academy - Google Search");
    }

    @Test
    public void googleSearch2() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperties("docuportBETA"));
        System.out.println("((RemoteWebDriver) Driver.getDriver()).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());

        DocuportUtils.login(Driver.getDriver(),  "client");

        WebElement myUploads = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'My uploads')]"));
        myUploads.click();
    }

}
