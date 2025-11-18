package ru.praktikum.stellarburgers.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient {

    private static final String BASE_URL = "https://stellarburgers.education-services.ru";

    public ApiClient() {
        RestAssured.baseURI = BASE_URL;
    }


    public Response createUser(String email, String password, String name) {
        String body = String.format("""
                {
                  "email": "%s",
                  "password": "%s",
                  "name": "%s"
                }
                """, email, password, name);

        return RestAssured
                .given()
                .header("Content-type", "application/json")
                .body(body)
                .post("/api/auth/register");
    }


    public Response deleteUser(String token) {
        return RestAssured
                .given()
                .header("Authorization", token)
                .delete("/api/auth/user");
    }
}