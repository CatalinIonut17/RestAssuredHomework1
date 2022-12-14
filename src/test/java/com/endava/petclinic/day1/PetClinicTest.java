package com.endava.petclinic.day1;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PetClinicTest {

    @Test
    public void postOwnersTest() {
        given().baseUri("http://api.petclinic.mywire.org/")
                .basePath("/petclinic")
                .port(80)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"address\": \"Strada Apusului\",\n" +
                        "  \"city\": \"Bucuresti\",\n" +
                        "  \"firstName\": \"Cristinel\",\n" +
                        "  \"id\": null,\n" +
                        "  \"lastName\": \"Oprescu\",\n" +
                        "  \"telephone\": \"0789758557\"\n" +
                        "}")
                .when()
                .post("/api/owners")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    public void postPetType() {
        given().baseUri("http://api.petclinic.mywire.org/")
                .basePath("/petclinic")
                .port(80)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": null,\n" +
                        "  \"name\": \"Dog\"\n" +
                        "}")
                .when()
                .post("/api/pettypes")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }



    @Test
    public void postAPet() {
        ValidatableResponse responsePostPet = given().baseUri("http://api.petclinic.mywire.org")
                .port(80)
                .basePath("/petclinic")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"birthDate\": \"2022/08/01\",\n" +
                        "  \"id\": null,\n" +
                        "  \"name\": \"Tasha\",\n" +
                        "  \"owner\": {\n" +
                        "    \"address\": \"Strada Apusului\",\n" +
                        "    \"city\": \"Bucuresti\",\n" +
                        "    \"firstName\": \"Cristinel\",\n" +
                        "    \"id\": 221,\n" +
                        "    \"lastName\": \"Oprescu\",\n" +
                        "    \"pets\": [\n" +
                        "      null\n" +
                        "    ],\n" +
                        "    \"telephone\": \"0789758557\"\n" +
                        "  },\n" +
                        "  \"type\": {\n" +
                        "    \"id\": 36,\n" +
                        "    \"name\": \"Dog\"\n" +
                        "  },\n" +
                        "  \"visits\": [\n" +
                        "    {\n" +
                        "      \"date\": \"2022/08/01\",\n" +
                        "      \"description\": \"control\",\n" +
                        "      \"id\": null\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when().log().all()
                .post("/api/pets")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);

        Integer petId = responsePostPet.extract().jsonPath().getInt("id");
        given().baseUri("http://api.petclinic.mywire.org")
                .port(80)
                .basePath("/petclinic")
                .pathParam("petId", petId)
                .when()
                .get("/api/pets/{petId}").prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("id", is(petId));
    }

    @Test
    public void postAPet2() {
        ValidatableResponse responsePostPet2 = given().baseUri("http://api.petclinic.mywire.org")
                .port(80)
                .basePath("/petclinic")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"birthDate\": \"2017/08/26\",\n" +
                        "  \"id\": null,\n" +
                        "  \"name\": \"Sparky\",\n" +
                        "  \"owner\": {\n" +
                        "    \"address\": \"Strada Voievozilor\",\n" +
                        "    \"city\": \"Bucuresti\",\n" +
                        "    \"firstName\": \"Catalin-Ionut\",\n" +
                        "    \"id\": 27,\n" +
                        "    \"lastName\": \"Dinescu\",\n" +
                        "    \"pets\": [\n" +
                        "      null\n" +
                        "    ],\n" +
                        "    \"telephone\": \"0725753159\"\n" +
                        "  },\n" +
                        "  \"type\": {\n" +
                        "    \"id\": 10,\n" +
                        "    \"name\": \"Dog\"\n" +
                        "  },\n" +
                        "  \"visits\": [\n" +
                        "    {\n" +
                        "      \"date\": \"2022/08/01\",\n" +
                        "      \"description\": \"control\",\n" +
                        "      \"id\": null\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}\n")
                .when().log().all()
                .post("/api/pets")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);
        Integer petId = responsePostPet2.extract().jsonPath().getInt("id");

        given().baseUri("http://api.petclinic.mywire.org")
                .port(80)
                .basePath("/petclinic")
                .pathParam("petId", petId)
                .when()
                .get("/api/pets/{petId}").prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("id", is(petId));
    }

    @Test
    public void getPetList(){
        given().baseUri("http://api.petclinic.mywire.org")
                .basePath("/petclinic")
                .port(80)
                .when().log().all()
                .get("api/pets")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void getPetbyId(){
        given().baseUri("http://api.petclinic.mywire.org")
                .basePath("/petclinic")
                .port(80)
                .pathParam("petId" , 103)
                .when().log().all()
                .get("/api/pets/{petId}")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("id", is(103))
                .body("name", containsString("ky"))
                .body("name", startsWith("S"))
                .body("name", hasLength(6));
    }

    @Test
    public void postAVisit(){
        ValidatableResponse responsePostVisit = given().baseUri("http://api.petclinic.mywire.org")
                .basePath("/petclinic")
                .port(80)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"date\": \"2022/06/30\",\n" +
                        "  \"description\": \"Control\",\n" +
                        "  \"id\": null,\n" +
                        "  \"pet\": {\n" +
                        "    \"birthDate\": \"2021/07/11\",\n" +
                        "    \"id\": 44,\n" +
                        "    \"name\": \"Sparky\",\n" +
                        "    \"owner\": {\n" +
                        "      \"address\": \"Strada Voievozilor\",\n" +
                        "      \"city\": \"Bucuresti\",\n" +
                        "      \"firstName\": \"Catalin-Ionut\",\n" +
                        "      \"id\": 27,\n" +
                        "      \"lastName\": \"Dinescu\",\n" +
                        "      \"pets\": [\n" +
                        "        null\n" +
                        "      ],\n" +
                        "      \"telephone\": \"0725753159\"\n" +
                        "    },\n" +
                        "    \"type\": {\n" +
                        "      \"id\": 10,\n" +
                        "      \"name\": \"Dog\"\n" +
                        "    },\n" +
                        "    \"visits\": [\n" +
                        "      null\n" +
                        "    ]\n" +
                        "  }\n" +
                        "}")
                .when()
                .post("/api/visits").prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);

        Integer visitId = responsePostVisit.extract().jsonPath().getInt("id");
        given().baseUri("http://api.petclinic.mywire.org")
                .basePath("/petclinic")
                .port(80)
                .pathParam("visitId" , visitId)
                .when()
                .get( "/api/visits/{visitId}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("id", is(visitId));
    }



}
