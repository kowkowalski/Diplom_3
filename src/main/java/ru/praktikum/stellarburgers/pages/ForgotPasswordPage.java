package ru.praktikum.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {


    private final By emailInput = By.xpath("//input[@name='email']");
    private final By resetButton = By.xpath("//button[text()='Восстановить']");
    private final By loginLink = By.xpath("//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Вводим email: {email}")
    public void enterEmail(String email) {
        type(emailInput, email);
    }

    @Step("Нажимаем кнопку 'Восстановить'")
    public void clickReset() {
        click(resetButton);
    }

    @Step("Переходим по ссылке 'Войти'")
    public LoginPage clickLoginLink() {
        click(loginLink);
        return new LoginPage(driver);
    }
}