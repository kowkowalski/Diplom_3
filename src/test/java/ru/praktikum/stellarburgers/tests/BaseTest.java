package ru.praktikum.stellarburgers.tests;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import ru.praktikum.stellarburgers.api.UserApiClient;
import ru.praktikum.stellarburgers.api.UserGenerator;
import ru.praktikum.stellarburgers.utils.WebDriverFactory;

public abstract class BaseTest {

    protected WebDriver driver;

    protected String email;
    protected String password;
    protected String name;
    protected String accessToken;

    @Before
    public void setUp() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();


        email = UserGenerator.randomEmail();
        password = UserGenerator.randomPassword();
        name = UserGenerator.randomName();

        accessToken = UserApiClient.createUser(email, password, name);


        String browser = System.getProperty("browser", "chrome");
        driver = WebDriverFactory.create(browser);
        driver.manage().window().setSize(new Dimension(1280, 1024));
    }

    @After
    public void tearDown() {

        if (accessToken != null) {
            UserApiClient.deleteUser(accessToken);
        }

        if (driver != null) {
            driver.quit();
        }
    }
}