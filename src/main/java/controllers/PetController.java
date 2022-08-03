package controllers;

import com.github.javafaker.Faker;
import model.Pet;
import model.Type;

import java.text.SimpleDateFormat;

public class PetController {
    public static Pet generateNewRandomPet() {
        Faker faker = new Faker();
        Pet pet = new Pet();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

        pet.setName(faker.dog().name());
        pet.setOwner(OwnerController.generateNewRandomOwner());
        pet.setType(new Type(faker.animal().name()));
        pet.setBirthDate(formatter.format(faker.date().birthday(1, 15)));

        return pet;
    }


}
