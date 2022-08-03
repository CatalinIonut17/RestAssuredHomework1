package com.endava.petclinic.day3;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import utils.TwitterReader;

import static io.restassured.RestAssured.given;

public class TwitterTest {

    @Test
    public void createATweet() {
        given().baseUri(TwitterReader.getBaseUri())
                .basePath(TwitterReader.getBasePath())
                .auth().oauth(TwitterReader.getApiKey(), TwitterReader.getApiKeySecret(), TwitterReader.getAccessToken(), TwitterReader.getAccessTokenSecret())
                .log().all()
                .queryParam("status", "La o bere cand?")
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post("/update.json")
                .then().log().all()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getAllTweet() {
        given().baseUri(TwitterReader.getBaseUri())
                .basePath(TwitterReader.getBasePath())
                .auth().oauth(TwitterReader.getApiKey(), TwitterReader.getApiKeySecret(), TwitterReader.getAccessToken(), TwitterReader.getAccessTokenSecret())
                .queryParam("screen_name", "j3r3my84")
                .header("Content-Type", "application/json")
                .when()
                .get("user_timeline.json").prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK);

    }


}
