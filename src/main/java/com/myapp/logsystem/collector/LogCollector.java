package myapp.logsystem.collector;
import myapp.logsystem.listener.LogListener;
public class LogCollector {
   private final LogListener listener;
   public LogCollector(LogListener listener) {
       this.listener = listener;
   }
   public String collect() {
       return listener.getLatestLog();
   }
}

