package com.myapp.logsystem.collector;
import com.myapp.logsystem.listener.LogListener;
public class LogCollector {
   private final LogListener listener;
   public LogCollector(LogListener listener) {
       this.listener = listener;
   }
   public void collect(String log) {
       listener.onLog(log);
   }
}
