package controllers;

import com.github.javafaker.Faker;
import model.Type;

public class TypeController {
    public static Type generateRandomPetType() {
        Faker faker = new Faker();
        Type type = new Type();

        type.setName(faker.animal().name());

        return type;
    }
}
