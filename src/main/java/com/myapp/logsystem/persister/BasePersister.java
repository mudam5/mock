package myapp.logsystem.persister;
import java.io.FileWriter;
import java.io.IOException;
public abstract class BasePersister {
   protected void writeToFile(String filename, String log) {
       try (FileWriter writer = new FileWriter(filename, true)) {
           writer.write(log + "\n");
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}

