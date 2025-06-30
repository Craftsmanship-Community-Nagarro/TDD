package org.nagarro.legacy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Simple logger implementation for the legacy system
 */
public class Logger {
    private String name;
    private LogLevel level;

    public enum LogLevel {
        DEBUG, INFO, WARN, ERROR
    }

    public Logger(String name) {
        this.name = name;
        this.level = LogLevel.INFO;
    }

    public Logger(String name, LogLevel level) {
        this.name = name;
        this.level = level;
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void error(String message, Throwable throwable) {
        log(LogLevel.ERROR, message + " - Exception: " + throwable.getMessage());
    }

    private void log(LogLevel logLevel, String message) {
        if (logLevel.ordinal() >= this.level.ordinal()) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            System.out.println(String.format("[%s] %s [%s] - %s",
                    timestamp, logLevel, name, message));
        }
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public LogLevel getLevel() {
        return level;
    }
}
