package by.smirnov.interfaces;

public interface Log {

    void error(String message, Throwable e);

    void info(String message);
}
