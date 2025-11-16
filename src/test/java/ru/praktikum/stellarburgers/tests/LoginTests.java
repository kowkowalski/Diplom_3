package ru.praktikum.stellarburgers.tests;

import org.junit.Test;
import ru.praktikum.stellarburgers.pages.ForgotPasswordPage;
import ru.praktikum.stellarburgers.pages.HomePage;
import ru.praktikum.stellarburgers.pages.LoginPage;
import ru.praktikum.stellarburgers.pages.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest {


    private final String EMAIL = "kowkowkowalski@yandex.ru";
    private final String PASSWORD = "Nutella2025!";

    @Test
    public void loginViaMainButton() {
        HomePage home = new HomePage(driver);
        home.openMainPage();

        LoginPage login = home.clickLoginButton();
        login.enterEmail(EMAIL);
        login.enterPassword(PASSWORD);

        HomePage homeAfterLogin = login.clickLogin();

        assertTrue("Профиль не открылся после логина через кнопку на главной",
                homeAfterLogin.isOnMainPage());
    }

    @Test
    public void loginViaPersonalAccountButton() {
        HomePage home = new HomePage(driver);
        home.openMainPage();

        LoginPage login = home.clickPersonalAccount();
        login.enterEmail(EMAIL);
        login.enterPassword(PASSWORD);

        HomePage homeAfterLogin = login.clickLogin();

        assertTrue("Профиль не открылся после логина через «Личный кабинет»",
                homeAfterLogin.isOnMainPage());
    }

    @Test
    public void loginViaRegistrationFormLink() {
        HomePage home = new HomePage(driver);
        home.openMainPage();

        LoginPage login = home.clickLoginButton();
        RegistrationPage registrationPage = login.clickRegistrationLink();

        LoginPage loginAgain = registrationPage.clickLoginLink();

        loginAgain.enterEmail(EMAIL);
        loginAgain.enterPassword(PASSWORD);

        HomePage homeAfterLogin = loginAgain.clickLogin();

        assertTrue("Профиль не открылся после логина через форму регистрации",
                homeAfterLogin.isOnMainPage());
    }

    @Test
    public void loginViaForgotPasswordForm() {
        HomePage home = new HomePage(driver);
        home.openMainPage();

        LoginPage login = home.clickLoginButton();
        ForgotPasswordPage forgotPasswordPage = login.clickForgotPasswordLink();

        LoginPage loginAgain = forgotPasswordPage.clickLoginLink();

        loginAgain.enterEmail(EMAIL);
        loginAgain.enterPassword(PASSWORD);

        HomePage homeAfterLogin = loginAgain.clickLogin();

        assertTrue("Профиль не открылся после логина через форму восстановления пароля",
                homeAfterLogin.isOnMainPage());
    }
}