package com.myapp.logsystem.persister;
public class InfoPersister extends BasePersister {
   public InfoPersister() {
       super("logs/info.log");  // Writes into logs/info.log
   }
}
