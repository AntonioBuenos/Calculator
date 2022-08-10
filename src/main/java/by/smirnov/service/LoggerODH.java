package by.smirnov.service;

import by.smirnov.ConsoleRunner;
import by.smirnov.interfaces.Log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static by.smirnov.constants.Wordings.*;
import static by.smirnov.util.PathGetter.getPath;

public class LoggerODH implements Log {

    private LoggerODH() {
    }
    private static class OnDemandHolder{
        public static final LoggerODH loggerODH = new LoggerODH();
    }

    public static LoggerODH getLogInstance() {
        return OnDemandHolder.loggerODH;
    }

    public void log(String message) {
        String path = getPath(ConsoleRunner.class, LOG_TXT);
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.println(message);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public void error(String message, Throwable e) {
        String errorMessage = String.format
                (LOG_ERROR_FORMAT, message, ResManager.getDate(), e.getClass().getSimpleName(), e.getMessage());
        log(errorMessage);
    }

    @Override
    public void info(String message) {
        log(String.format(LOG_INFO_FORMAT, message, ResManager.getDate()));
    }
}
