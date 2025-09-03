package myapp.logsystem.analyser;

import myapp.logsystem.collector.LogCollector;

import myapp.logsystem.persister.*;

public class LogAnalyser implements Runnable {

    private final LogCollector collector;

    public LogAnalyser(LogCollector collector) {

        this.collector = collector;

    }

    @Override

    public void run() {

        InfoPersister info = new InfoPersister();

        WarningPersister warn = new WarningPersister();

        DebugPersister debug = new DebugPersister();

        ErrorPersister error = new ErrorPersister();

        while (true) {

            String log = collector.collect();

            if (log == null) continue;

            if (log.startsWith("INFO")) info.persist(log);

            else if (log.startsWith("WARNING")) warn.persist(log);

            else if (log.startsWith("DEBUG")) debug.persist(log);

            else if (log.startsWith("ERROR")) error.persist(log);

        }

    }

}
 
