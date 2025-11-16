package ru.praktikum.stellarburgers.pages;

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

    protected boolean isVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    protected void click(By locator) {

        for (int i = 0; i < 4; i++) {
            try {
                WebElement element = waitClickable(locator);


                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView({block: 'center'});", element
                );


                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -200);");

                Thread.sleep(200);

                wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
                return;

            } catch (Exception ignored) {
                if (i == 3) throw new RuntimeException("Не удалось кликнуть: " + locator);
            }
        }
    }

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