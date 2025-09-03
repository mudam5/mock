package com.myapp.logsystem.persister;
public class ErrorPersister extends BasePersister {
   public ErrorPersister() {
       super("logs/error.log");  // Writes into logs/error.log
   }
}
