package myapp.logsystem.listener;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class LogListener {
   private BlockingQueue<String> logQueue = new LinkedBlockingQueue<>();
   // Add log entry (called by generator/collector)
   public void onLogReceived(String log) {
       logQueue.offer(log);
   }
   // Fetch latest log (called by LogCollector)
   public String getLatestLog() {
       return logQueue.poll(); // returns and removes the head, or null if empty
   }
}

    
