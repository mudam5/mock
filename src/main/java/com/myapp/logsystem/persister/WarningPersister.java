package myapp.logsystem.persister;
public class WarningPersister extends BasePersister {
   public WarningPersister() {
       super("/var/log/logsystem/warning.log");  // ✅ passes file path
   }
}
