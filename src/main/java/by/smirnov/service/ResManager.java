package by.smirnov.service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

import static by.smirnov.constants.Patterns.DATE_PATTERN;
import static by.smirnov.constants.Patterns.TIME_PATTERN;
import static by.smirnov.constants.Wordings.BASENAME;
import static by.smirnov.constants.Wordings.CHANGE_LOCAL;
import static java.lang.System.out;

public enum ResManager {
    INSTANCE;
    public ResourceBundle resourceBundle;


    ResManager() {
        resourceBundle = ResourceBundle.getBundle(BASENAME, Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        Printer printer = new Printer(out);
        resourceBundle = ResourceBundle.getBundle(BASENAME, locale);
        printer.println(getString((CHANGE_LOCAL)));
    }

    public String getString(String key){
        return resourceBundle.getString(key);
    }

    public static String getDate() {
        ZonedDateTime now = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN, Locale.getDefault());
        return now.format(formatter);
    }

    public static String getTime() {
        ZonedDateTime now = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_PATTERN, Locale.getDefault());
        return now.format(formatter);
    }

}
