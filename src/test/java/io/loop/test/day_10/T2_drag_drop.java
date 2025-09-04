package io.loop.test.day_10;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/*
    1- Open a chrome browser
    2- Go to: https://demo.guru99.com/test/drag_drop.html
    3- Drag “BANK” and drop into Account area under Debit Side
    4- Drag “5000” and drop into Amount area under Debit Side
    5- Drag “SALES” and drop into Account area under Credit Side
    6- Drag “5000” and drop into Amount area under Credit Side
    7- Validate “Perfect!” text displayed.
     */
public class T2_drag_drop {

    @Test
    public void drag_drop_test() {
        Driver.getDriver().get("https://demo.guru99.com/test/drag_drop.html");
        WebElement bank = Driver.getDriver().findElement(By.xpath("//a[text()=' BANK ']"));
        WebElement debitAccount = Driver.getDriver().findElement(By.id("bank"));

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(bank, debitAccount).perform();

        WebElement fiveK = Driver.getDriver().findElement(By.xpath("//a[text()=' 5000 ']"));
        WebElement debitAmount = Driver.getDriver().findElement(By.id("amt7"));

        actions.dragAndDrop(fiveK, debitAmount).perform();

        WebElement sales = Driver.getDriver().findElement(By.xpath("//a[text()=' SALES ']"));
        WebElement creditAccount = Driver.getDriver().findElement(By.id("loan"));

        actions.dragAndDrop(sales, creditAccount).perform();

        WebElement creditAmount = Driver.getDriver().findElement(By.id("amt8"));

        actions.dragAndDrop(fiveK, creditAmount).perform();

        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//a[.='Perfect!']"));

        /*In IntelliJ IDEA, the shortcut to introduce a variable from an expression is:
        Windows/Linux
        Ctrl + Alt + V
        macOS
        ⌥ Option + ⌘ Command + V
         */

        String expectedMessage = "Perfect!";
        String actualMessage = successMessage.getText();
        assertEquals(actualMessage, expectedMessage, "Actual does NOT match expected message");
        assertTrue(successMessage.isDisplayed(), "The message IS NOT displayed");




    }
}
