package ru.praktikum.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final String BASE_URL = "https://stellarburgers.education-services.ru/";

    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By bunsTab = By.xpath("//span[text()='Булки']");
    private final By saucesTab = By.xpath("//span[text()='Соусы']");
    private final By fillingsTab = By.xpath("//span[text()='Начинки']");
    private final By mainConstructorHeader = By.xpath("//h1[text()='Соберите бургер']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        driver.get(BASE_URL);
    }

    public boolean isOnMainPage() {
        return isVisible(mainConstructorHeader);
    }

    public LoginPage clickLoginButton() {
        click(loginButton);
        return new LoginPage(driver);
    }


    public LoginPage clickPersonalAccount() {
        click(personalAccountButton);
        return new LoginPage(driver);
    }

    public void clickBuns() {
        click(bunsTab);
    }

    public void clickSauces() {
        click(saucesTab);
    }

    public void clickFillings() {
        click(fillingsTab);
    }
}