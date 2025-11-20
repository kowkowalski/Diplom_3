package ru.praktikum.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.stellarburgers.pages.ForgotPasswordPage;
import ru.praktikum.stellarburgers.pages.HomePage;
import ru.praktikum.stellarburgers.pages.LoginPage;
import ru.praktikum.stellarburgers.pages.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    @DisplayName("Логин через кнопку «Войти в аккаунт»")
    @Description("Создаём пользователя через API → логинимся через главную страницу.")
    public void loginViaMainButton() {
        HomePage home = new HomePage(driver);
        home.openMainPage();

        LoginPage login = home.clickLoginButton();
        login.login(email, password);

        assertTrue("Главная страница не открылась после логина",
                home.isOnMainPage());
    }

    @Test
    @DisplayName("Логин через кнопку «Личный кабинет»")
    @Description("Переходим в ЛК → вводим данные → логинимся.")
    public void loginViaPersonalAccount() {
        HomePage home = new HomePage(driver);
        home.openMainPage();

        LoginPage login = home.clickPersonalAccount();
        login.login(email, password);

        assertTrue("Главная страница не открылась после логина",
                home.isOnMainPage());
    }

    @Test
    @DisplayName("Логин через форму регистрации")
    @Description("Переходим в регистрацию → затем в логин → логинимся.")
    public void loginViaRegistrationFormLink() {
        HomePage home = new HomePage(driver);
        home.openMainPage();

        LoginPage login = home.clickLoginButton();
        RegistrationPage reg = login.clickRegistrationLink();
        LoginPage againLogin = reg.clickLoginLink();

        againLogin.login(email, password);

        assertTrue("Главная страница не открылась после логина", home.isOnMainPage());
    }

    @Test
    @DisplayName("Логин через форму восстановления пароля")
    @Description("Переходим в восстановление → обратно в логин → логинимся.")
    public void loginViaForgotPasswordForm() {
        HomePage home = new HomePage(driver);
        home.openMainPage();

        LoginPage login = home.clickLoginButton();
        ForgotPasswordPage forgot = login.clickForgotPasswordLink();
        LoginPage againLogin = forgot.clickLoginLink();

        againLogin.login(email, password);

        assertTrue("Главная страница не открылась после логина", home.isOnMainPage());
    }
}