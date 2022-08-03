package controllers;

import com.github.javafaker.Faker;
import model.Owner;
import model.Visit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class VisitController {
    public static Visit generateRandomVisit(){
        Visit visit = new Visit();
        Faker faker = new Faker();

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

        LocalDate localDate = between.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        visit.setDate(localDate.format(dateTimeFormatter));
        visit.setDescription(faker.beer().name().toLowerCase(Locale.ROOT));
        //visit.setPet(PetController.generateNewRandomPet());
        //visit.setOwner(OwnerController.genereteNewRandomOwner());
        //visit.setType(PetTypeController.generateRandomPetType());

        return visit;

    }

    //public static void main(String[] args) {
       // System.out.println(generateRandomVisit());
   // }
}
