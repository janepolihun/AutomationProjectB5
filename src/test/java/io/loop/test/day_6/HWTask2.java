package io.loop.test.day_6;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HWTask2 {

    WebDriver driver;
    WebElement element;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
        driver.get(DocuportConstants.DOCUPORT_TEST);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void docupotTest() throws InterruptedException {
        element = driver.findElement(By.xpath("//input[@id='input-14']"));
        element.sendKeys(DocuportConstants.USERNAME_ADVISOR);

        element = driver.findElement(By.xpath("//input[@id='input-15']"));
        element.sendKeys(DocuportConstants.PASSWORD_GROUP2);

        element = driver.findElement(By.xpath("//button[@type='submit']"));
        element.click();

        Thread.sleep(3000);

        element = driver.findElement(By.xpath("//span[@class='body-1' and text()='Received docs']"));
        element.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        element = driver.findElement(By.xpath("//div[@class='d-flex align-center justify-start justify-sm-end flex-wrap']/button/following-sibling::button/following-sibling::button"));
        element.click();

        element = driver.findElement(By.xpath("//div[@class='v-select__slot']/label/following-sibling::div/div/following-sibling::input"));
        element.click();

        element = driver.findElement(By.xpath("//div[text()='In progress']"));
        element.click();
    }
}









