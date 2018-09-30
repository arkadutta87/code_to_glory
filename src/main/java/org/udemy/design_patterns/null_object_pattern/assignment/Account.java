package org.udemy.design_patterns.null_object_pattern.assignment;

public class Account {

  private Log log;

  public Account(Log log){
    this.log = log;
  }

  public void someOperation() throws Exception{
    int c = log.getRecordCount();

    log.logInfo("Performing and operation");
    if(c+1 != log.getRecordCount()){
      throw  new Exception();
    }

    if(log.getRecordCount() >= log.getRecordLimit()){
      throw new Exception();
    }
  }
}
