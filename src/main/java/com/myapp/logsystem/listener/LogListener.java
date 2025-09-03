package com.myapp.logsystem.listener;

import com.myapp.logsystem.persister.BasePersister;

import java.util.HashMap;

import java.util.Map;

public class LogListener {

    private final Map<String, BasePersister> persisters = new HashMap<>();

    // Register different persisters (Info, Error, Warning, Debug, etc.)

    public void registerPersister(String level, BasePersister persister) {

        persisters.put(level.toUpperCase(), persister);

    }

    // Handle incoming log messages

    public void onLog(String level, String message) {

        BasePersister persister = persisters.get(level.toUpperCase());

        if (persister != null) {

            persister.persist(message);

        } else {

            System.out.println("[UNHANDLED] " + message);

        }

    }

}
 
