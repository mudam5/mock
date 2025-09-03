package com.myapp.logsystem;

import com.myapp.logsystem.listener.LogListener;

import com.myapp.logsystem.analyser.LogAnalyser;

import com.myapp.logsystem.collector.LogCollector;

import java.io.FileWriter;

import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Paths;

import java.util.concurrent.ArrayBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class MainApplication {

    public static void main(String[] args) throws Exception {

        // Ensure logs directory exists

        Files.createDirectories(Paths.get("logs"));

        // Queue for passing logs

        BlockingQueue<String> logQueue = new ArrayBlockingQueue<>(100);

        // Listener will push logs into queue

        LogListener listener = new LogListener(logQueue);

        // Components

        LogAnalyser analyser = new LogAnalyser(listener);

        LogCollector collector = new LogCollector(listener);

        // Thread for persisting logs

        Thread persisterThread = new Thread(() -> {

            try (FileWriter writer = new FileWriter("logs/app.log", true)) {

                while (true) {

                    String log = logQueue.take(); // wait until a log arrives

                    writer.write(log + System.lineSeparator());

                    writer.flush();

                }

            } catch (IOException | InterruptedException e) {

                e.printStackTrace();

            }

        });

        persisterThread.setDaemon(true); // exit when main exits

        persisterThread.start();

        // Simulate logs

        collector.collect("INFO - Application started");

        collector.collect("DEBUG - Debugging mode enabled");

        collector.collect("WARN - Low memory warning");

        collector.collect("ERROR - Something went wrong");

        // Analyse logs

        analyser.analyse("INFO - User login success");

        analyser.analyse("DEBUG - Debug details");

        analyser.analyse("WARN - Disk almost full");

        analyser.analyse("ERROR - Database connection failed");

        System.out.println("Logs are being written into logs/app.log");

    }

}
 
