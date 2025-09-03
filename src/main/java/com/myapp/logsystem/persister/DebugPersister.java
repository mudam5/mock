package com.myapp.logsystem.persister;
public class DebugPersister extends BasePersister {
   public DebugPersister(String filePath) {
       super(filePath);
   }
   @Override
   public void persist(String message) {
       writeToFile("[DEBUG] " + message);
   }
}
