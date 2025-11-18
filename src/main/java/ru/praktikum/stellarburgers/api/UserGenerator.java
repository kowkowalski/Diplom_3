package ru.praktikum.stellarburgers.api;

import com.github.javafaker.Faker;

public class UserGenerator {

    private static final Faker faker = new Faker();

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static String randomPassword() {
        return faker.internet().password(6, 12);
    }

    public static String randomName() {
        return faker.name().firstName();
    }
}