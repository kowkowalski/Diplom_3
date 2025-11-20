package ru.praktikum.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private final String BASE_URL = "https://stellarburgers.education-services.ru/";

    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");

    private final By bunsTab = By.xpath("//span[text()='Булки']/parent::div");
    private final By saucesTab = By.xpath("//span[text()='Соусы']/parent::div");
    private final By fillingsTab = By.xpath("//span[text()='Начинки']/parent::div");

    private final By activeBunsTab = By.xpath("//div[contains(@class,'tab_tab_type_current')][.//span[text()='Булки']]");
    private final By activeSaucesTab = By.xpath("//div[contains(@class,'tab_tab_type_current')][.//span[text()='Соусы']]");
    private final By activeFillingsTab = By.xpath("//div[contains(@class,'tab_tab_type_current')][.//span[text()='Начинки']]");

    private final By mainConstructorHeader = By.xpath("//h1[text()='Соберите бургер']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Открываем главную страницу")
    public void openMainPage() {
        driver.get(BASE_URL);

        // Ждём загрузку главной страницы
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainConstructorHeader));
    }

    @Step("Проверяем, что открыта главная страница")
    public boolean isOnMainPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(mainConstructorHeader));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Нажимаем кнопку 'Войти в аккаунт'")
    public LoginPage clickLoginButton() {
        click(loginButton);
        return new LoginPage(driver);
    }

    @Step("Переходим в личный кабинет через кнопку 'Личный Кабинет'")
    public LoginPage clickPersonalAccount() {
        click(personalAccountButton);
        return new LoginPage(driver);
    }

    @Step("Открываем раздел 'Булки'")
    public void clickBuns() {
        click(bunsTab);
    }

    @Step("Открываем раздел 'Соусы'")
    public void clickSauces() {
        click(saucesTab);
    }

    @Step("Открываем раздел 'Начинки'")
    public void clickFillings() {
        click(fillingsTab);
    }

    @Step("Проверяем, что активен таб 'Булки'")
    public boolean isBunsTabActive() {
        return isVisible(activeBunsTab);
    }

    @Step("Проверяем, что активен таб 'Соусы'")
    public boolean isSaucesTabActive() {
        return isVisible(activeSaucesTab);
    }

    @Step("Проверяем, что активен таб 'Начинки'")
    public boolean isFillingsTabActive() {
        return isVisible(activeFillingsTab);
    }
}