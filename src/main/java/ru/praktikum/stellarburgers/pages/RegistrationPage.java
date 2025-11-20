package ru.praktikum.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    private final By nameInput = By.xpath("//label[text()='Имя']/following-sibling::input");
    private final By emailInput = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By passwordInput = By.xpath("//label[text()='Пароль']/following-sibling::input");

    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By loginLink = By.xpath("//a[text()='Войти']");
    private final By passwordError = By.xpath("//p[text()='Некорректный пароль']");
    private final By loginHeader = By.xpath("//h2[text()='Вход']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Вводим имя: {name}")
    public void enterName(String name) {
        type(nameInput, name);
    }

    @Step("Вводим email: {email}")
    public void enterEmail(String email) {
        type(emailInput, email);
    }

    @Step("Вводим пароль")
    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    @Step("Нажимаем кнопку 'Зарегистрироваться' (без ожиданий)")
    public void clickRegisterButtonRaw() {
        click(registerButton);
    }

    @Step("Успешная регистрация → ожидаем страницу логина")
    public LoginPage clickRegisterButtonSuccess() {
        click(registerButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeader));
        return new LoginPage(driver);
    }

    @Step("Регистрация нового пользователя (успешная): {email}")
    public LoginPage register(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        return clickRegisterButtonSuccess();
    }

    @Step("Проверяем ошибку некорректного пароля")
    public boolean isPasswordErrorVisible() {
        return isVisible(passwordError);
    }

    @Step("Переходим по ссылке 'Войти'")
    public LoginPage clickLoginLink() {
        click(loginLink);
        return new LoginPage(driver);
    }
}