package com.mycompany.logsystem;
import com.mycompany.logsystem.generator.LogGenerator;
import com.mycompany.logsystem.listener.LogListener;
import com.mycompany.logsystem.collector.LogCollector;
import com.mycompany.logsystem.analyser.LogAnalyser;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class MainApplication {
   public static void main(String[] args) throws InterruptedException {
       BlockingQueue<String> queue = new LinkedBlockingQueue<>();
       LogGenerator generator = new LogGenerator(queue);
       LogListener listener = new LogListener(queue);
       LogCollector collector = new LogCollector(listener);
       LogAnalyser analyser = new LogAnalyser(collector);
       Thread generatorThread = new Thread(generator);
       Thread listenerThread = new Thread(listener);
       Thread analyserThread = new Thread(analyser);
       generatorThread.start();
       listenerThread.start();
       analyserThread.start();
       generatorThread.join();
       listenerThread.join();
       analyserThread.join();
       System.out.println("Log Processing System finished execution.");
   }
}
