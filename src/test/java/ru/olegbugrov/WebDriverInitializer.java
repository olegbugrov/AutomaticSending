package ru.olegbugrov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverInitializer {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected WebDriverInitializer() {
//        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
//        this.driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
//        chromeOptions.addArguments("--no-sandbox");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 10);
    }
}
