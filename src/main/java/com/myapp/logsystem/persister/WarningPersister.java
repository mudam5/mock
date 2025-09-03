package com.myapp.logsystem.persister;
public class WarningPersister extends BasePersister {
   public WarningPersister(String filePath) {
       super(filePath);
   }
   @Override
   public void persist(String message) {
       writeToFile("[WARNING] " + message);
   }
}
