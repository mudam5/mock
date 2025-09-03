package com.myapp.logsystem.listener;
import java.util.concurrent.BlockingQueue;
public class LogListener {
   private final BlockingQueue<String> logQueue;
   public LogListener(BlockingQueue<String> logQueue) {
       this.logQueue = logQueue;
   }
   public void onLog(String log) {
       logQueue.offer(log);
   }
}
