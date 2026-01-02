package org.example.creational.singleton;

import java.time.Instant;

public class Logger {
    private Logger() {}

    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }

    public void log(String message) {
        System.out.println(Instant.now() + " LOG: " + message);
    }
}
