package myapp.logsystem;

import myapp.logsystem.listener.LogListener;

import myapp.logsystem.persister.*;

import myapp.logsystem.collector.LogCollector;

import myapp.logsystem.analyser.LogAnalyser;

public class MainApplication {

    public static void main(String[] args) {

        LogListener listener = new LogListener();

        // Register persisters

        listener.registerPersister("INFO", new InfoPersister());

        listener.registerPersister("WARN", new WarningPersister());

        listener.registerPersister("DEBUG", new DebugPersister());

        listener.registerPersister("ERROR", new ErrorPersister());

        // Push logs

        listener.onLog("INFO", "Application started");

        listener.onLog("DEBUG", "Debugging connection issue");

        listener.onLog("WARN", "Low disk space");

        listener.onLog("ERROR", "NullPointerException occurred");

        // Collect logs

        LogCollector collector = new LogCollector(listener);

        collector.collect();

        // Analyse logs

        LogAnalyser analyser = new LogAnalyser(listener);

        System.out.println(analyser.analyse());

    }

}
 
