package io.loop.test.day_5;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

/*
       1- Open a chrome browser
       2- Go to: https://www.nba.com
       3- Locate all the links in the page.
        */
public class T3_findElements {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
        driver.get("https://www.nba.com");


        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> nbaLinks = driver.findElements(By.tagName("a"));
        System.out.println("nbaLinks.size() = " + nbaLinks.size());

        List<WebElement> nbaListWithXpath = driver.findElements(By.xpath("//a"));
        System.out.println("nbaListWithXpath.size() = " + nbaListWithXpath.size());

        for (WebElement nbaLink : nbaLinks) {
            if(!nbaLink.getText().equals("")){
                System.out.println(" nbaLink.getText() = " + nbaLink.getText());
                System.out.println("nba.getAttribute(\"href\") = " + nbaLink.getAttribute("href"));
            }
        }


        for (int i = 0; i < nbaLinks.size(); i++) {
            if(!nbaLinks.get(i).getText().equals("")){
                System.out.println(" nbaLink.getText() = " + nbaLinks.get(i).getText());
                System.out.println("nba.getAttribute(\"href\") = " + nbaLinks.get(i).getAttribute("href"));
            }
        }
    }
}
