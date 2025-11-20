package ru.praktikum.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    private final By profileHeader = By.xpath("//a[@href='/account/profile']");
    private final By logoutButton = By.xpath("//button[text()='Выход']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверяем, что заголовок профиля отображается")
    public boolean isProfileHeaderVisible() {
        return isVisible(profileHeader);
    }

    @Step("Выходим из аккаунта")
    public void logout() {
        click(logoutButton);
    }

    @Step("Ожидаем загрузку страницы профиля")
    public void waitForProfilePage() {
        waitVisible(profileHeader);
    }
}