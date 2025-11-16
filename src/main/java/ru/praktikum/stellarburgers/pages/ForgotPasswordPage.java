package ru.praktikum.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {

    private final By emailInput = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By resetButton = By.xpath("//button[text()='Восстановить']");
    private final By loginLink = By.xpath("//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        type(emailInput, email);
    }

    public void clickReset() {
        click(resetButton);
    }

    public LoginPage clickLoginLink() {
        click(loginLink);
        return new LoginPage(driver);
    }
}