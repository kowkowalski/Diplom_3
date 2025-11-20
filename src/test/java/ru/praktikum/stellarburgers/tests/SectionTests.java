package ru.praktikum.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.stellarburgers.pages.HomePage;

import static org.junit.Assert.assertTrue;

public class SectionTests extends BaseTest {

    @Test
    @DisplayName("Проверка вкладки «Булки»")
    @Description("Переходим в раздел Соусы → обратно в Булки → проверяем активность таба.")
    public void checkBunsSection() {
        HomePage home = new HomePage(driver);
        home.openMainPage();

        home.clickSauces();
        home.clickBuns();

        assertTrue(home.isBunsTabActive());
    }

    @Test
    @DisplayName("Проверка вкладки «Соусы»")
    @Description("Открываем Соусы и проверяем активный таб.")
    public void checkSaucesSection() {
        HomePage home = new HomePage(driver);
        home.openMainPage();

        home.clickSauces();

        assertTrue(home.isSaucesTabActive());
    }

    @Test
    @DisplayName("Проверка вкладки «Начинки»")
    @Description("Переходим в Начинки и проверяем активность.")
    public void checkFillingsSection() {
        HomePage home = new HomePage(driver);
        home.openMainPage();

        home.clickFillings();

        assertTrue(home.isFillingsTabActive());
    }
}