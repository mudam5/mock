package myapp.logsystem.persister;
public class InfoPersister extends BasePersister {
   public InfoPersister() {
       super("/var/log/logsystem/info.log");  // ✅ passes file path
   }
}
