package io.loop.test.day_9;

import com.github.javafaker.Faker;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class day_8_extra {
    //  https://app.docuport.app/company-formation/resident

    @Test
    public void testExtraTask() throws InterruptedException {
        Driver.getDriver().get("https://app.docuport.app/company-formation/resident");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //page 1
        WebElement llcCheck = Driver.getDriver().findElement(By.xpath("//label[.='LLC']"));
        llcCheck.click();
        WebElement marylandClick =  Driver.getDriver().findElement(By.xpath("//label[.='Maryland']"));
        marylandClick.click();
        WebElement companyName = Driver.getDriver().findElement(By.xpath("//label[contains(text(), 'Legal Company Name')]/following-sibling::input"));
        companyName.sendKeys("Automation.com" );
        WebElement dba = Driver.getDriver().findElement(By.xpath("//label[contains(text(), 'DBA (Doing Business As)')]/following-sibling::input"));
        dba.sendKeys("Snoopy" );
        WebElement industry = Driver.getDriver().findElement(By.xpath("//div[@class='v-input__icon v-input__icon--append']/i"));
        industry.click();
        WebElement clickIndustry = Driver.getDriver().findElement(By.xpath("//div[contains(text(),'Agents')]"));
        clickIndustry.click();
        WebElement firstName = Driver.getDriver().findElement(By.xpath("//label[contains(normalize-space(.),'First name')]/following-sibling::input"));
        firstName.sendKeys("Snoopy" );
        WebElement lastName = Driver.getDriver().findElement(By.xpath("//label[contains(normalize-space(.),'Last name')]/following-sibling::input"));
        lastName.sendKeys("Rud");
        WebElement emailAddress = Driver.getDriver().findElement(By.xpath("//label[contains(normalize-space(.),'Email address *')]/following-sibling::input"));
        emailAddress.sendKeys("snoopy_rud@gamil.com" );
        WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//label[contains(normalize-space(.),'Phone number *')]/following-sibling::input[1]"));
        Faker faker = new Faker();
        phoneNumber.sendKeys(faker.numerify("222-###-###") + Keys.ENTER);
        // page 2
        Thread.sleep(2000);
        WebElement company = Driver.getDriver().findElement(By.xpath("//label[.='Company']"));
        company.click();
        WebElement companyNameAgent = Driver.getDriver().findElement(By.xpath("//label[.='Company name *']/following-sibling::input"));
        companyNameAgent.sendKeys(faker.name().name());
        WebElement companyAddress = Driver.getDriver().findElement(By.xpath("//label[.='Address line 1 *']/following-sibling::input"));
        companyAddress.sendKeys(faker.address().fullAddress());
        WebElement city = Driver.getDriver().findElement(By.xpath("//label[.='City *']/following-sibling::input"));
        city.sendKeys(faker.address().city());
        WebElement jurisdiction = Driver.getDriver().findElement(By.xpath("//label[.='Jurisdiction *']/following-sibling::input"));
        jurisdiction.click();
        WebElement clickJurisdiction = Driver.getDriver().findElement(By.xpath("//div[.='Baltimore County']"));
        clickJurisdiction.click();
        WebElement zipcode = Driver.getDriver().findElement(By.xpath("//label[.='Zip code *']/following-sibling::input"));
        zipcode.sendKeys(faker.address().zipCode());
        WebElement email = Driver.getDriver().findElement(By.xpath("//label[.='Email address']/following-sibling::input"));
        email.sendKeys(faker.internet().emailAddress());
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(3000);
        WebElement phoneNumAg = Driver.getDriver().findElement(By.xpath("(//label[text()='Phone number *']/following-sibling::input)[2]")); //Halina thank you
        phoneNumAg.sendKeys(faker.phoneNumber().phoneNumber() + Keys.ENTER);
        // page 3
        WebElement memberManaged = Driver.getDriver().findElement(By.xpath("//label[.='Member managed']"));
        memberManaged.click();
        Thread.sleep(2000);
        WebElement firsName = Driver.getDriver().findElement(By.xpath("(//label[.='First name *']/following-sibling::input)[2]"));
        firsName.sendKeys(faker.name().firstName());
        WebElement lastNamePage3 = Driver.getDriver().findElement(By.xpath("(//label[.='Last name *']/following-sibling::input)[2]"));
        lastNamePage3.sendKeys(faker.name().lastName());
        WebElement shareOwnership = Driver.getDriver().findElement(By.xpath("//label[text()='Share Ownership (%) *']/following-sibling::input"));
        shareOwnership.sendKeys("2");
        WebElement ssn = Driver.getDriver().findElement(By.xpath("//label[.='SSN of an Organizing Member *']/following-sibling::input"));
        ssn.sendKeys(faker.idNumber().ssnValid());
        WebElement firsName2 = Driver.getDriver().findElement(By.xpath("(//label[.='First name *']/following-sibling::input)[3]"));
        firsName2.sendKeys(faker.name().firstName());
        WebElement lastNamePage3_2 = Driver.getDriver().findElement(By.xpath("(//label[.='Last name *']/following-sibling::input)[3]"));
        lastNamePage3_2.sendKeys(faker.name().lastName() + Keys.ENTER);

        Driver.getDriver().quit();

    }

}
