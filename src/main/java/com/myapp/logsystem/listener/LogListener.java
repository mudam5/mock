package myapp.logsystem.listener;

import java.util.HashMap;

import java.util.Map;

import myapp.logsystem.persister.BasePersister;

public class LogListener {

    private final Map<String, BasePersister> persisters = new HashMap<>();

    // Register persisters for log levels

    public void registerPersister(String level, BasePersister persister) {

        persisters.put(level, persister);

    }

    // Process incoming log message

    public void onLog(String level, String message) {

        BasePersister persister = persisters.get(level);

        if (persister != null) {

            persister.persist(message);

        } else {

            System.out.println("⚠️ No persister registered for level: " + level + " | Message: " + message);

        }

    }

}
 
