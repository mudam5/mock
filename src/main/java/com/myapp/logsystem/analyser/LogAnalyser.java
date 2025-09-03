package com.myapp.logsystem.analyser;

import com.myapp.logsystem.listener.LogListener;

public class LogAnalyser {

    private final LogListener listener;

    public LogAnalyser(LogListener listener) {

        this.listener = listener;

    }

    public void analyse(String log) {

        if (log.contains("ERROR")) {

            listener.onLog("ERROR detected: " + log);

        } else if (log.contains("WARN")) {

            listener.onLog("WARNING detected: " + log);

        } else if (log.contains("INFO")) {

            listener.onLog("INFO detected: " + log);

        } else if (log.contains("DEBUG")) {

            listener.onLog("DEBUG detected: " + log);

        }

    }

}
 
