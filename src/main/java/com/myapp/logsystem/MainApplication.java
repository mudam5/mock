package com.myapp.logsystem;

import com.myapp.logsystem.listener.LogListener;

import com.myapp.logsystem.persister.*;

public class MainApplication {

    public static void main(String[] args) {

        LogListener listener = new LogListener();

        // Register persisters for each log type

        listener.registerPersister("INFO", new InfoPersister("logs/info.log"));

        listener.registerPersister("ERROR", new ErrorPersister("logs/error.log"));

        listener.registerPersister("WARNING", new WarningPersister("logs/warning.log"));

        listener.registerPersister("DEBUG", new DebugPersister("logs/debug.log"));

        // Test logs

        listener.onLog("INFO", "System started successfully.");

        listener.onLog("ERROR", "Unable to connect to database.");

        listener.onLog("WARNING", "Disk space is running low.");

        listener.onLog("DEBUG", "Checking configuration values...");

    }

}
 
