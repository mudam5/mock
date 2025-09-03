package myapp.logsystem.listener;

import myapp.logsystem.persister.BasePersister;

import java.util.*;

import java.util.concurrent.BlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class LogListener {

    private BlockingQueue<String> logQueue = new LinkedBlockingQueue<>();

    private Map<String, BasePersister> persisters = new HashMap<>();

    // Add persister for a specific log level

    public void registerPersister(String level, BasePersister persister) {

        persisters.put(level.toUpperCase(), persister);

    }

    // Handle log entry (called from MainApplication / generators)

    public void onLog(String level, String message) {

        String log = "[" + level.toUpperCase() + "] " + message;

        logQueue.offer(log);

        // Send to persister if available

        BasePersister p = persisters.get(level.toUpperCase());

        if (p != null) {

            p.persist(log);

        }

    }

    // Get latest log (used by collector/analyser)

    public String getLatestLog() {

        return logQueue.poll();

    }

}
 
    
