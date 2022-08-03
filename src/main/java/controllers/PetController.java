package controllers;

import com.github.javafaker.Faker;
import model.Owner;
import model.Pet;
import model.PetType;
import model.Visit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class PetController {
    public static Pet generateNewRandomPet() {
        Faker faker = new Faker();
        Pet pet = new Pet();

        String dateString ="04-01-2020";
        String dateString1 ="30-07-2022";
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyyy");
        Date date = null;
        Date date1 = null;
        try {
            date = format.parse(dateString);
            date1= format.parse(dateString1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Date between = faker.date().between(date, date1);

        LocalDateTime localDateTime = LocalDateTime.from(between.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        LocalDate localDate = between.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd\'T\'hh:mm:ss.SSS\'Z\'");
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        //System.out.println(localDateTime.format(dateTimeFormatter));

        pet.setName(faker.animal().name());
        //pet.setBrithDate(String.valueOf(localDateTime.format(dateTimeFormatter)));
        pet.setBrithDate(localDate.format(dateTimeFormatter2));
        Owner owner = new Owner();
        PetType petType = new PetType();
        Visit visit = new Visit();

        pet.setOwner(owner);
        pet.setType(petType);
        pet.setVisit(visit);
        return pet;
    }

    /*public static void main(String[] args) {
        System.out.println(generateNewRandomPet());
    }*/
}
