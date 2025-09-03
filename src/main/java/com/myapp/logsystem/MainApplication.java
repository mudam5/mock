package myapp.logsystem;

import myapp.logsystem.collector.LogCollector;

import myapp.logsystem.generator.LogGenerator;

import myapp.logsystem.listener.LogListener;

import myapp.logsystem.persister.DebugPersister;

import myapp.logsystem.persister.ErrorPersister;

import myapp.logsystem.persister.InfoPersister;

import myapp.logsystem.persister.WarningPersister;

import myapp.logsystem.analyser.LogAnalyser;

public class MainApplication {

    public static void main(String[] args) {

        System.out.println("🚀 Log Processing System Started...");

        // Create persisters (writing to /var/log/logsystem/*.log)

        InfoPersister infoPersister = new InfoPersister();

        WarningPersister warningPersister = new WarningPersister();

        DebugPersister debugPersister = new DebugPersister();

        ErrorPersister errorPersister = new ErrorPersister();

        // Listener

        LogListener listener = new LogListener();

        listener.registerPersister("INFO", infoPersister);

        listener.registerPersister("WARNING", warningPersister);

        listener.registerPersister("DEBUG", debugPersister);

        listener.registerPersister("ERROR", errorPersister);

        // Collector

        LogCollector collector = new LogCollector(listener);

        // Generator

        LogGenerator generator = new LogGenerator(collector);

        generator.generateSampleLogs();

        // Analyser

        LogAnalyser analyser = new LogAnalyser();

        analyser.analyse("/var/log/logsystem/info.log");

        System.out.println("✅ Logs generated and persisted to /var/log/logsystem/");

    }

}
 
