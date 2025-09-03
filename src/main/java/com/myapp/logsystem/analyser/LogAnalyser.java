package myapp.logsystem.analyser;

import myapp.logsystem.listener.LogListener;

public class LogAnalyser {

    private LogListener listener;

    public LogAnalyser(LogListener listener) {

        this.listener = listener;

    }

    // Analyse latest log

    public String analyse() {

        String log = listener.getLatestLog();

        if (log == null) return "No logs to analyse";

        if (log.contains("ERROR")) return "Error detected: " + log;

        if (log.contains("WARN")) return "Warning detected: " + log;

        if (log.contains("DEBUG")) return "Debug log: " + log;

        return "Info log: " + log;

    }

}
 
