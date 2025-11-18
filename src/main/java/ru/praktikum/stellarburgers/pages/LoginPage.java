package ru.praktikum.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    // --- Локаторы ---
    private final By loginHeader = By.xpath("//h2[text()='Вход']");
    private final By emailInput = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By passwordInput = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By registrationLink = By.xpath("//a[text()='Зарегистрироваться']");
    private final By forgotPasswordLink = By.xpath("//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверяем, что открыта страница логина")
    public boolean isLoginPageOpened() {
        return isVisible(loginHeader);
    }

    @Step("Вводим email: {email}")
    public void enterEmail(String email) {
        type(emailInput, email);
    }

    @Step("Вводим пароль")
    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    @Step("Нажимаем кнопку 'Войти'")
    public HomePage clickLogin() {
        click(loginButton);

        // Ждём переход на главную
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Соберите бургер']")
        ));

        return new HomePage(driver);
    }

    @Step("Авторизуемся: {email}")
    public HomePage login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        return clickLogin();
    }

    @Step("Переходим на страницу регистрации")
    public RegistrationPage clickRegistrationLink() {
        click(registrationLink);
        return new RegistrationPage(driver);
    }

    @Step("Переходим на страницу восстановления пароля")
    public ForgotPasswordPage clickForgotPasswordLink() {
        click(forgotPasswordLink);
        return new ForgotPasswordPage(driver);
    }
}