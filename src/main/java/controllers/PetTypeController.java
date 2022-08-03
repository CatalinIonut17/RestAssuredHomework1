package controllers;

import com.github.javafaker.Faker;
import model.PetType;

import java.util.Locale;

public class PetTypeController {
    public static PetType generateRandomPetType(){
        Faker faker =new Faker();

        PetType type = new PetType();
        type.setName(faker.animal().name().toLowerCase(Locale.ROOT));

        return type;
    }
}
