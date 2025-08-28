package io.loop.test.day_8;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.LoopUtils;
import org.testng.annotations.Test;

import java.time.Duration;


public class HWT2_create_method extends TestBase {

    //type, amount, date, street, city, state, zip, card, card number, exp
   @Test
    public void t2_test() throws InterruptedException {
       driver.get("https://loopcamp.vercel.app/web-tables.html");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

       String actualType = LoopUtils.returnAnyFieldFromTableLOOP(driver, "Alexandra Gray", "pizza type");
       System.out.println("Pizza type " + "\"" + actualType + "\".");

       String amount = LoopUtils.returnAnyFieldFromTableLOOP(driver, "Alexandra Gray", "amount");
       System.out.println("Amount: " + "\"" + amount + "\".");

       String date = LoopUtils.returnAnyFieldFromTableLOOP(driver, "Alexandra Gray", "date");
       System.out.println("Date: " + "\"" + date + "\".");

       String street = LoopUtils.returnAnyFieldFromTableLOOP(driver, "Alexandra Gray", "street");
       System.out.println("Street: " + "\"" + street + "\".");

       String city = LoopUtils.returnAnyFieldFromTableLOOP(driver, "Alexandra Gray", "city");
       System.out.println("City: " + "\"" + city + "\".");

       String state = LoopUtils.returnAnyFieldFromTableLOOP(driver, "Alexandra Gray", "state");
       System.out.println("State: " + "\"" + state + "\".");

       String zip = LoopUtils.returnAnyFieldFromTableLOOP(driver, "Alexandra Gray", "zip");
       System.out.println("Zip: " + "\"" + zip + "\".");

       String card = LoopUtils.returnAnyFieldFromTableLOOP(driver, "Alexandra Gray", "card");
       System.out.println("Card: " + "\"" + card + "\".");

       String cardNumber = LoopUtils.returnAnyFieldFromTableLOOP(driver, "Alexandra Gray", "card number");
       System.out.println("Card number: " + "\"" + cardNumber + "\".");

       String exp = LoopUtils.returnAnyFieldFromTableLOOP(driver, "Alexandra Gray", "exp");
       System.out.println("Exp: " + "\"" + exp + "\".");

       String exp2 = LoopUtils.returnAnyFieldFromTableLOOP(driver, "Alexandra Gray", "expf");
       System.out.println("Exp: " + "\"" + exp2 + "\".");

   }

}
