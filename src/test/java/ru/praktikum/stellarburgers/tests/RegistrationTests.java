package ru.praktikum.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.stellarburgers.pages.HomePage;
import ru.praktikum.stellarburgers.pages.LoginPage;
import ru.praktikum.stellarburgers.pages.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTests extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Создаём нового пользователя → логинимся → проверяем загрузку главной страницы.")
    public void successfulRegistration() {

        String newEmail = "ui_" + System.currentTimeMillis() + "@mail.ru";
        String newPassword = "123456";

        HomePage home = new HomePage(driver);
        home.openMainPage();

        LoginPage login = home.clickLoginButton();
        RegistrationPage reg = login.clickRegistrationLink();

        // Успешная регистрация — ждём страницу логина
        reg.register("Автотест", newEmail, newPassword);

        login.enterEmail(newEmail);
        login.enterPassword(newPassword);

        HomePage afterLogin = login.clickLogin();

        assertTrue("Главная после регистрации не открылась",
                afterLogin.isOnMainPage());
    }

    @Test
    @DisplayName("Ошибка при коротком пароле")
    @Description("Проверяем отображение ошибки при пароле < 6 символов.")
    public void wrongPasswordRegistrationShowsError() {
        HomePage home = new HomePage(driver);
        home.openMainPage();

        LoginPage login = home.clickLoginButton();
        RegistrationPage reg = login.clickRegistrationLink();

        reg.enterName("Test");
        reg.enterEmail("wrong@mail.com");
        reg.enterPassword("123");

        // ⚠ Используем специальный метод без ожиданий
        reg.clickRegisterButtonRaw();

        assertTrue(
                "Ошибка 'Некорректный пароль' должна отображаться",
                reg.isPasswordErrorVisible()
        );
    }
}