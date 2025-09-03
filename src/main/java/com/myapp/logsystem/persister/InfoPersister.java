package com.myapp.logsystem.persister;
public class InfoPersister extends BasePersister {
   public InfoPersister(String filePath) {
       super(filePath);
   }
   @Override
   public void persist(String log) {
       writeToFile("[INFO] " + log);
   }
}
