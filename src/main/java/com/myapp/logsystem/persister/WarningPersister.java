package myapp.logsystem.persister;
public class WarningPersister extends BasePersister {
   public void persist(String log) {
       writeToFile("logs/warning.log", log);
   }
}
