package com.omdbapi.base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class baseConfig {

    public static final String BASE_URL = "https://www.omdbapi.com/";

    public static Response get(HashMap<String, Object> map) {
        return given()
                .baseUri(BASE_URL)
                .queryParams(map)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                //log().body()
                .extract().response();
    }
}
