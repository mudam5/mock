package myapp.logsystem.persister;
public class ErrorPersister extends BasePersister {
   public void persist(String log) {
       writeToFile("logs/error.log", log);
   }
}
