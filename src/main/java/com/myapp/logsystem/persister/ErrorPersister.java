package myapp.logsystem.persister;
public class ErrorPersister extends BasePersister {
   public ErrorPersister() {
       super("/var/log/logsystem/error.log");  // ✅ passes file path
   }
}
