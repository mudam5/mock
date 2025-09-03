package myapp.logsystem.persister;
import java.io.FileWriter;
import java.io.IOException;
public abstract class BasePersister {
   protected String filePath;
   public BasePersister(String filePath) {
       this.filePath = filePath;
   }
   public void persist(String message) {
       try (FileWriter fw = new FileWriter(filePath, true)) {
           fw.write(message + System.lineSeparator());
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}

