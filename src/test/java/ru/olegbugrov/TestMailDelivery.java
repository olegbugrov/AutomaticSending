package ru.olegbugrov;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;
import java.sql.Timestamp;

public class TestMailDelivery extends WebDriverInitializer {

    @Before
    public void testStart() throws IOException {
        MailConfig.getInstance();
    }

    @After
    public void testClose() {
        driver.quit();
    }

    @Test
    public void testSendingFromMail() throws InterruptedException {
        driver.get("http://mail.ru/");
        driver.findElement(By.id("mailbox:saveauth")).click();
        driver.findElement(By.id("mailbox:login"))
                .sendKeys(MailConfig.getAccountName("loginMail"));
        driver.findElement(By.id("mailbox:submit")).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mailbox:password")));
        driver.findElement(By.id("mailbox:password"))
                .sendKeys(MailConfig.getAccountPass("passwordMail"));
        driver.findElement(By.id("mailbox:submit")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class=\"sidebar__compose-btn-box\"]")));
        SubjectLetterGenerator letterGenerator = new SubjectLetterGenerator();
        for(int idx = 0; idx < letterGenerator.getNumLetters(); idx++) {
        driver.findElement(By.cssSelector("[class=\"compose-button__wrapper\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class=\"container--H9L5q size_s_compressed--2c-eV\"]")));
        driver.findElement(By.cssSelector("[class=\"container--H9L5q size_s_compressed--2c-eV\"]"))
                .sendKeys(MailConfig.getAccountName("loginGmail") + "@gmail.com");
        driver.findElement(By.name("Subject"))
                .sendKeys(letterGenerator.getSubjectByIdx(idx));
        driver.findElement(By.name("Subject")).sendKeys(Keys.TAB, Keys.TAB, new Timestamp(System.currentTimeMillis()).toString());
        String selectCtrlEnter = Keys.chord(Keys.CONTROL, Keys.ENTER);
        driver.findElement(By.cssSelector("[class=\"button2 button2_base button2_primary button2_compact button2_hover-support js-shortcut\"]"))
                .click();
        Thread.sleep(30000);
        }
    }

    @Test
    public void testResponseLetter() {
        driver.get("http://gmail.com/");
        driver.findElement(By.id("identifierId"))
                .sendKeys(MailConfig.getAccountName("loginGmail") + "@gmail.com", Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"aso_search_form_anchor\"]/button[2]")).click();
        driver.findElement(By.id(":nm")).sendKeys("Test - 3", Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(":1")));
        driver.findElement(By.id(":xf")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(":wm")));
        driver.findElement(By.id(":wm")).sendKeys(Keys.TAB, Keys.ENTER);
    }
}
