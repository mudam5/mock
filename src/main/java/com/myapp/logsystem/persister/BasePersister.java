package com.myapp.logsystem.persister;
import java.io.FileWriter;
import java.io.IOException;
public abstract class BasePersister {
   protected String filePath;
   public BasePersister(String filePath) {
       this.filePath = filePath;
   }
   // Abstract method
   public abstract void persist(String log);
   // Helper method to write logs to file
   protected void writeToFile(String log) {
       try (FileWriter writer = new FileWriter(filePath, true)) {
           writer.write(log + System.lineSeparator());
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
