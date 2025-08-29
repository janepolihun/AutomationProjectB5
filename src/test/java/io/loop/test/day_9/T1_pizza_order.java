package io.loop.test.day_9;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.PizzaOrderWebTableUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T1_pizza_order extends TestBase {

    @Test
    public void test_pizza_order() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        String name = "Robert Baratheon";
        String expectedPizzaType = "Hawaiian";
        String actualPizzaType = PizzaOrderWebTableUtil.returnFieldValue(driver, name, "pizza type");
        assertEquals(actualPizzaType, expectedPizzaType, "Actual DOES NOT match expected ");
    }
}
