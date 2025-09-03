package com.myapp.logsystem.persister;
public class DebugPersister extends BasePersister {
   public DebugPersister() {
       super("logs/debug.log");  // Writes into logs/debug.log
   }
}
