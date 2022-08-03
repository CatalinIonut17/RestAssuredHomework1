package controllers;

import com.github.javafaker.Faker;
import model.Visit;

import java.text.SimpleDateFormat;

public class VisitController {
    public static Visit generateNewRandomVisit() {
        Visit visit = new Visit();
        Faker faker = new Faker();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

        visit.setDate(formatter.format(faker.date().birthday(1, 5)));
        visit.setDescription(faker.dog().memePhrase());
        visit.setPet(PetController.generateNewRandomPet());
        visit.setOwner(OwnerController.generateNewRandomOwner());
        visit.setType(TypeController.generateRandomPetType());

        return visit;

    }
}
