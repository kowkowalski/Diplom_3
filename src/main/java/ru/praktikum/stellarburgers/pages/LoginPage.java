package ru.praktikum.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By emailInput = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By passwordInput = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private final By loginButton = By.xpath("//button[text()='Войти']");

    private final By registrationLink = By.xpath("//a[text()='Зарегистрироваться']");
    private final By forgotPasswordLink = By.xpath("//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        type(emailInput, email);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }


    public HomePage clickLogin() {
        click(loginButton);
        return new HomePage(driver);
    }

    public RegistrationPage clickRegistrationLink() {
        click(registrationLink);
        return new RegistrationPage(driver);
    }

    public ForgotPasswordPage clickForgotPasswordLink() {
        click(forgotPasswordLink);
        return new ForgotPasswordPage(driver);
    }
}