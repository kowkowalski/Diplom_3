package ru.praktikum.stellarburgers.utils;

public class UserFactory {

    public static String randomEmail() {
        return "autotest_" + System.currentTimeMillis() + "@example.com";
    }
}