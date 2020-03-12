package ru.olegbugrov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverInitializer {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected WebDriverInitializer() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
        this.driver = new FirefoxDriver();
        this.wait = new WebDriverWait(driver, 10);
    }
}
