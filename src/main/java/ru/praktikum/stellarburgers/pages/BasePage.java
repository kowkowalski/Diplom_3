package ru.praktikum.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    @Step("Проверяем, что элемент отображается: {locator}")
    protected boolean isVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Кликаем по элементу: {locator}")
    protected void click(By locator) {
        try {
            WebElement element = waitClickable(locator);

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

            waitClickable(locator).click();

        } catch (Exception e) {
            throw new RuntimeException("Не удалось кликнуть по элементу: " + locator, e);
        }
    }

    @Step("Вводим текст '{text}' в поле: {locator}")
    protected void type(By locator, String text) {
        WebElement element;
        try {
            element = waitVisible(locator);
            element.clear();
        } catch (StaleElementReferenceException e) {
            element = waitVisible(locator);
            element.clear();
        }
        element.sendKeys(text);
    }
}