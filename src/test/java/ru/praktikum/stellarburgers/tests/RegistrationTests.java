package ru.praktikum.stellarburgers.tests;

import org.junit.Test;
import ru.praktikum.stellarburgers.pages.*;

import static org.junit.Assert.assertTrue;

public class RegistrationTests extends BaseTest {

    @Test
    public void successfulRegistration() {
        HomePage home = new HomePage(driver);
        home.openMainPage();

        LoginPage login = home.clickLoginButton();
        RegistrationPage reg = login.clickRegistrationLink();


        String randomEmail = "autotest_" + System.currentTimeMillis() + "@mail.ru";

        reg.enterName("Автотест");
        reg.enterEmail(randomEmail);
        reg.enterPassword("123456");

        login = reg.clickRegisterButton();


        LoginPage loginAfterReg = login;
        loginAfterReg.enterEmail(randomEmail);
        loginAfterReg.enterPassword("123456");

        HomePage homeAfterLogin = loginAfterReg.clickLogin();
        assertTrue(homeAfterLogin.isOnMainPage());
    }

    @Test
    public void wrongPasswordRegistrationShowsError() {
        HomePage home = new HomePage(driver);
        home.openMainPage();

        LoginPage login = home.clickLoginButton();
        RegistrationPage reg = login.clickRegistrationLink();

        reg.enterName("Test");
        reg.enterEmail("wrongemail@mail.com");
        reg.enterPassword("123"); // слишком короткий пароль

        reg.clickRegisterButton();

        assertTrue("Ожидалось сообщение об ошибке",
                reg.isPasswordErrorVisible());
    }
}