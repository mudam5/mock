package myapp.logsystem.persister;
public class DebugPersister extends BasePersister {
   public void persist(String log) {
       writeToFile("logs/debug.log", log);
   }
}
