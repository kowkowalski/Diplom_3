package ru.praktikum.stellarburgers.api;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UserApiClient {

    private static final String BASE_URL = "https://stellarburgers.education-services.ru";

    public static class UserData {
        public String email;
        public String password;
        public String name;

        public UserData(String email, String password, String name) {
            this.email = email;
            this.password = password;
            this.name = name;
        }
    }

    // Создание пользователя
    public static String createUser(String email, String password, String name) {
        UserData body = new UserData(email, password, name);

        String token = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/api/auth/register")
                .then()
                .statusCode(200)
                .extract()
                .path("accessToken");

        // Удаляем "Bearer " если сервер его вернул
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        return token;
    }

    // Удаление пользователя
    public static void deleteUser(String accessToken) {
        if (accessToken == null) return;

        given()
                .baseUri(BASE_URL)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .delete("/api/auth/user")
                .then()
                .statusCode(202); // API реально возвращает 202
    }
}