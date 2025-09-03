package myapp.logsystem.persister;
public class InfoPersister extends BasePersister {
   public void persist(String log) {
       writeToFile("logs/info.log", log);
   }
}
