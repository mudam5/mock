package com.myapp.logsystem.persister;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Abstract base class for log persistors.
 */
public abstract class BasePersister {

    private final String logFilePath;

    public BasePersister(String fileName) {
        // Create a local "logs" directory inside project folder
        String logDir = "./logs";
        try {
            Files.createDirectories(Paths.get(logDir));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.logFilePath = logDir + "/" + fileName;
    }

    protected void writeToFile(String logLevel, String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath, true))) {
            writer.write("[" + logLevel + "] " + message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void persist(String message);
}
