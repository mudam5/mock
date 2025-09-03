package myapp.logsystem.persister;
public class DebugPersister extends BasePersister {
   public DebugPersister() {
       super("/var/log/logsystem/debug.log");  // ✅ passes file path
   }
}
