package com.endava.petclinic.day2;

import controllers.OwnerController;
import controllers.PetController;
import controllers.VisitController;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import model.Owner;
import model.Pet;
import model.Visit;
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

        Pet pet = PetController.generateNewRandomPet();

        ValidatableResponse creteOwnerResponse = given().baseUri(EnvReader.getBaseUri())
                .basePath(EnvReader.getBasePath())
                .port(EnvReader.getPort())
                .contentType(ContentType.JSON)
                .body(pet.getOwner())
                .when()
                .post("/api/owners").prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);

        pet.getOwner().setId(creteOwnerResponse.extract().jsonPath().getInt("id"));

        ValidatableResponse createPetTypeResponse = given().baseUri(EnvReader.getBaseUri())
                .basePath(EnvReader.getBasePath())
                .port(EnvReader.getPort())
                .contentType(ContentType.JSON)
                .body(pet.getType())
                .when()
                .post("/api/pettypes").prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);

        pet.getType().setId(createPetTypeResponse.extract().jsonPath().getInt("id"));


        ValidatableResponse createPetResponse  = given().baseUri(EnvReader.getBaseUri())
                .basePath(EnvReader.getBasePath())
                .port(EnvReader.getPort())
                .contentType(ContentType.JSON)
                .body(pet)
                .when().log().all()
                .post("/api/pets").prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);

        pet.setId(createPetResponse.extract().jsonPath().getInt("id"));

        ValidatableResponse getPetResponse = given().baseUri(EnvReader.getBaseUri())
                .basePath(EnvReader.getBasePath())
                .port(EnvReader.getPort())
                .pathParam("petId", pet.getId())
                .get("/api/pets/{petId}")
                .then()
                .statusCode(HttpStatus.SC_OK);

        Pet verifyPet = getPetResponse.extract().as(Pet.class);

        assertThat(verifyPet, is(pet));

    }

    @Test
    public void getPetList(){
        given().baseUri(EnvReader.getBaseUri())
                .basePath(EnvReader.getBasePath())
                .port(EnvReader.getPort())
                .when()
                .get("/api/pets")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void createVisitTest(){
        Visit visit = VisitController.generateNewRandomVisit();
        Pet pet = PetController.generateNewRandomPet();

        ValidatableResponse creteOwnerResponse = given().baseUri(EnvReader.getBaseUri())
                .basePath(EnvReader.getBasePath())
                .port(EnvReader.getPort())
                .contentType(ContentType.JSON)
                .body(visit.getOwner())
                .when()
                .post("/api/owners").prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);

        pet.getOwner().setId(creteOwnerResponse.extract().jsonPath().getInt("id"));
        visit.getOwner().setId(creteOwnerResponse.extract().jsonPath().getInt("id"));


        ValidatableResponse createPetTypeResponse = given().baseUri(EnvReader.getBaseUri())
                .basePath(EnvReader.getBasePath())
                .port(EnvReader.getPort())
                .contentType(ContentType.JSON)
                .body(visit.getType())
                .when()
                .post("/api/pettypes").prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);

        pet.getType().setId(createPetTypeResponse.extract().jsonPath().getInt("id"));
        visit.getType().setId(createPetTypeResponse.extract().jsonPath().getInt("id"));

        ValidatableResponse createPetResponse  = given().baseUri(EnvReader.getBaseUri())
                .basePath(EnvReader.getBasePath())
                .port(EnvReader.getPort())
                .contentType(ContentType.JSON)
                .body(visit.getPet())
                .when().log().all()
                .post("/api/pets").prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);

        pet.setId(createPetResponse.extract().jsonPath().getInt("id"));
        /*visit.getPet().setId(createPetResponse.extract().jsonPath().getInt("id"));

        ValidatableResponse createVisitResponse = given().baseUri(EnvReader.getBaseUri())
                .basePath(EnvReader.getBasePath())
                .port(EnvReader.getPort())
                .contentType(ContentType.JSON)
                .body(visit)
                .when()
                .post("/api/visits").prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);

        visit.setId(createVisitResponse.extract().jsonPath().getInt("id"));

        ValidatableResponse getVisitResponse = given().baseUri(EnvReader.getBaseUri())
                .basePath(EnvReader.getBasePath())
                .port(EnvReader.getPort())
                .pathParam("visitId", visit.getId())
                .get("/api/visits/{visitId}").prettyPeek()
                .then().statusCode(HttpStatus.SC_OK);

        Visit verifyVisit = getVisitResponse.extract().as(Visit.class);

        assertThat(verifyVisit, is(visit));*/
    }






}
