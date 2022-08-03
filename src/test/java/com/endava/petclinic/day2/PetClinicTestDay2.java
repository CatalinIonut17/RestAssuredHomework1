package com.endava.petclinic.day2;

import controllers.OwnerController;
import controllers.PetTypeController;
import controllers.PetController;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import model.Owner;
import model.Pet;
import model.PetType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import utils.EnvReader;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PetClinicTestDay2 {

    @Test

    public void postAPest(){

       /* Owner owner = OwnerController.genereteNewRandomOwner();

        ValidatableResponse ownerPostResponse = given().baseUri(EnvReader.getBaseUri())
                .basePath(EnvReader.getBasePath())
                .port(EnvReader.getPort())
                .contentType(ContentType.JSON)
                .body(owner)
                .when().log().all()
                .post("/api/owners").prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);

        owner.setId(ownerPostResponse.extract().jsonPath().getInt("id"));
        PetType type = PetTypeController.generateRandomPetType();
        //Pet pet = new Pet(PetController.generateNewRandomPet(), owner, type);*/
        Pet pet = PetController.generateNewRandomPet();

        ValidatableResponse postPetResponse  = given().baseUri(EnvReader.getBaseUri())
                .basePath(EnvReader.getBasePath())
                .port(EnvReader.getPort())
                .contentType(ContentType.JSON)
                .body(pet)
                .when().log().all()
                .post("/api/pets").prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);

        //Integer petId = postPetResponse.extract().jsonPath().getInt("id");

       /* ValidatableResponse getResponse = given().baseUri(EnvReader.getBaseUri())
                .basePath(EnvReader.getBasePath())
                .port(EnvReader.getPort())
                .pathParam("petId", petId)
                .when()
                .get("/api/pets/{petId}").prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("id", is(petId));

        Pet petFromGetResponse = getResponse.extract().as(Pet.class);

        assertThat(petFromGetResponse, is(pet));*/


    }





}
