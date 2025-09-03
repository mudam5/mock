package myapp.logsystem;

import myapp.logsystem.listener.LogListener;

import myapp.logsystem.persister.*;

public class MainApplication {

    public static void main(String[] args) {

        System.out.println("🚀 Log Processing System Started...");

        // Create persisters

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

        // Generate some test logs

        listener.onLog("INFO", "System is starting up...");

        listener.onLog("DEBUG", "Debugging connection pool.");

        listener.onLog("WARNING", "Low memory warning.");

        listener.onLog("ERROR", "Database connection failed!");

        System.out.println("✅ Logs written under /var/log/logsystem/");

    }

}
 
