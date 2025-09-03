package com.myapp.logsystem.persister;
public class WarningPersister extends BasePersister {
   public WarningPersister() {
       super("logs/warning.log");  // Writes into logs/warning.log
   }
}
