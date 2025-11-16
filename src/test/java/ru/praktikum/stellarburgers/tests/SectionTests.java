package ru.praktikum.stellarburgers.tests;

import org.junit.Test;
import ru.praktikum.stellarburgers.pages.HomePage;

import static org.junit.Assert.assertTrue;

public class SectionTests extends BaseTest {

    @Test
    public void checkBunsSection() {
        HomePage home = new HomePage(driver);
        home.openMainPage();
        home.clickSauces();  // переключаемся, чтобы тест был точнее
        home.clickBuns();
        assertTrue(home.isOnMainPage());
    }

    @Test
    public void checkSaucesSection() {
        HomePage home = new HomePage(driver);
        home.openMainPage();
        home.clickSauces();
        assertTrue(home.isOnMainPage());
    }

    @Test
    public void checkFillingsSection() {
        HomePage home = new HomePage(driver);
        home.openMainPage();
        home.clickFillings();
        assertTrue(home.isOnMainPage());
    }
}