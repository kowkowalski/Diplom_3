package ru.praktikum.stellarburgers.tests;

import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import ru.praktikum.stellarburgers.utils.WebDriverFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public abstract class BaseTest {

    protected WebDriver driver;

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            try {
                if (driver == null) return;
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File dest = new File("target/screenshots/" + description.getMethodName() + ".png");
                dest.getParentFile().mkdirs();
                Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception ignored) {}
        }
    };

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = WebDriverFactory.create(browser);
        driver.manage().window().setSize(new Dimension(1280, 1024));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}