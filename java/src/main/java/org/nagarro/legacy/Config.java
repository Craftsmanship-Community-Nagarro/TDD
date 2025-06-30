package org.nagarro.legacy;

/**
 * Configuration class for the legacy invoice management system
 */
public class Config {
    private String databaseUrl;
    private int maxConnections;
    private int timeoutMillis;
    private boolean enableLogging;
    private String logLevel;

    public Config() {
        // Default configuration values
        this.databaseUrl = "jdbc:h2:mem:testdb";
        this.maxConnections = 10;
        this.timeoutMillis = 5000;
        this.enableLogging = true;
        this.logLevel = "INFO";
    }

    public Config(String databaseUrl, int maxConnections, int timeoutMillis, boolean enableLogging, String logLevel) {
        this.databaseUrl = databaseUrl;
        this.maxConnections = maxConnections;
        this.timeoutMillis = timeoutMillis;
        this.enableLogging = enableLogging;
        this.logLevel = logLevel;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public int getTimeoutMillis() {
        return timeoutMillis;
    }

    public void setTimeoutMillis(int timeoutMillis) {
        this.timeoutMillis = timeoutMillis;
    }

    public boolean isEnableLogging() {
        return enableLogging;
    }

    public void setEnableLogging(boolean enableLogging) {
        this.enableLogging = enableLogging;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }
}
