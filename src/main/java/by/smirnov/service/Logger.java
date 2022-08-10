package by.smirnov.service;

import by.smirnov.interfaces.Log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static by.smirnov.constants.Wordings.LOG_ERROR_FORMAT;
import static by.smirnov.constants.Wordings.LOG_INFO_FORMAT;
import static by.smirnov.util.PathGetter.getPath;

public enum Logger implements Log {

    LOG_INSTANCE;

    private static volatile Logger logger;

    public static final String LOG_TXT = "log.txt";


    public static Logger getLogInstance() {
        return LOG_INSTANCE;
    }

    public void log(String message) {
        String path = getPath(Logger.class, LOG_TXT);
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.println(message);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public void error(String message, Throwable e) {
        String errorMessage = String.format(LOG_ERROR_FORMAT, message, ResManager.getDate(), e.getClass().getSimpleName(), e.getMessage());
        log(errorMessage);
    }

    @Override
    public void info(String message) {
        log(String.format(LOG_INFO_FORMAT, message, ResManager.getDate()));
    }
}
