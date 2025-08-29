package io.loop.test.day_9;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class T5_java_faker {

    @Test
    public void java_faker() {
        Faker faker = new Faker();

        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println(faker.numerify("202-###-#### = " + faker.numerify("202-###-####")));
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.finance().creditCard());
        System.out.println(faker.chuckNorris().fact().replace("Chuck Norris", "Feyruz"));

    }
}
