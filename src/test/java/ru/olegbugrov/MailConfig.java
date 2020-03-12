package ru.olegbugrov;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class MailConfig {
    private static MailConfig mailConfig;
    private static Map<String, String> account;


    private MailConfig() throws IOException {
        try (FileInputStream fis = new FileInputStream("src/main/resources/account.properties")){
            Properties property = new Properties();
            property.load(fis);
            account = new HashMap<>();
            account.put("loginMail", property.getProperty("loginMail"));
            account.put("passwordMail", property.getProperty("passwordMail"));
            account.put("loginGmail", property.getProperty("loginGmail"));
            account.put("passwordGmail", property.getProperty("passwordGmail"));

        } catch (FileNotFoundException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }


    public static MailConfig getInstance() throws IOException {
        if (mailConfig == null) {
            mailConfig = new MailConfig();
            return mailConfig;
        }
        return mailConfig;
    }

    public static String getAccountName(String name) {
        return account.get(name);
    }

    public static String getAccountPass(String pass) {
        return account.get(pass);
    }
}