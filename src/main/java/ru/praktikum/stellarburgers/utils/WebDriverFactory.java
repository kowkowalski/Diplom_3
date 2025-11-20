package ru.praktikum.stellarburgers.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    public static WebDriver create(String browser) {

        // ---- Yandex Browser ----
        if ("yandex".equalsIgnoreCase(browser)) {

            // Путь к бинарнику Yandex Browser
            String yandexBinary = "/Applications/Yandex.app/Contents/MacOS/Yandex";

            ChromeOptions options = new ChromeOptions();
            options.setBinary(yandexBinary);

            // WebDriverManager подбирает ChromeDriver версии 140
            WebDriverManager.chromedriver()
                    .browserVersion("140") // твой Яндекс основан на Chromium 140
                    .setup();

            return new ChromeDriver(options);
        }

        // ---- Google Chrome ----
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}