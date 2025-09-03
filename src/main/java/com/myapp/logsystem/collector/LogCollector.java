package myapp.logsystem.collector;
import myapp.logsystem.listener.LogListener;
public class LogCollector {
   private LogListener listener;
   public LogCollector(LogListener listener) {
       this.listener = listener;
   }
   public void collect() {
       String log = listener.getLatestLog();  // ✅ now compiles
       if (log != null) {
           System.out.println("Collected log: " + log);
       }
   }
}

