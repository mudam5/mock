package com.myapp.logsystem.persister;
public class ErrorPersister extends BasePersister {
   public ErrorPersister(String filePath) {
       super(filePath);
   }
   @Override
   public void persist(String log) {
       writeToFile("[ERROR] " + log);
   }
}
