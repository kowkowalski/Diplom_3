package ru.praktikum.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    private final By nameInput = By.xpath("//label[text()='Имя']/following-sibling::input");
    private final By emailInput = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By passwordInput = By.xpath("//input[@type='password']");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By loginLink = By.xpath("//a[text()='Войти']");
    private final By passwordError = By.xpath("//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        type(nameInput, name);
    }

    public void enterEmail(String email) {
        type(emailInput, email);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }


    public LoginPage clickRegisterButton() {
        click(registerButton);
        return new LoginPage(driver);   // ← главное исправление!
    }


    public LoginPage clickLoginLink() {
        click(loginLink);
        return new LoginPage(driver);
    }


    public boolean isPasswordErrorVisible() {
        return isVisible(passwordError);
    }
}