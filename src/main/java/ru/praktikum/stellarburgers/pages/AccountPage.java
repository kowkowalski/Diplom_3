package ru.praktikum.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    private final By profileHeader = By.xpath("//a[@href='/account/profile']");
    private final By logoutButton = By.xpath("//button[text()='Выход']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProfileHeaderVisible() {
        return isVisible(profileHeader);
    }

    public void logout() {
        click(logoutButton);
    }

    public void waitForProfilePage() {
        waitVisible(profileHeader);
    }
}