package com.mycompany.logsystem.collector;
import com.mycompany.logsystem.listener.LogListener;
public class LogCollector {
   private final LogListener listener;
   public LogCollector(LogListener listener) {
       this.listener = listener;
   }
   public String collect() {
       return listener.getLatestLog();
   }
}
