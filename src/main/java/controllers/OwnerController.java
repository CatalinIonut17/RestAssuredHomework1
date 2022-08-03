package controllers;

import com.github.javafaker.Faker;
import model.Owner;

public class OwnerController {
    public static Owner generateNewRandomOwner(){
        Faker faker = new Faker();

        Owner owner = new Owner();
        owner.setFirstName(faker.name().firstName());
        owner.setLastName(faker.name().lastName());
        owner.setAddress(faker.address().streetAddress());
        owner.setCity(faker.address().city());
        owner.setTelephone(faker.number().digits(10));

        return owner;

    }
}
