package org.udemy.design_patterns.null_object_pattern.assignment;

public class NullLog implements Log{

  int callNumber = 0;
  int prev = 0;
  private int recordCount = 0;
  private int recordLimit = Integer.MAX_VALUE;

  @Override
  public int getRecordLimit() {
    return recordLimit;
  }

  @Override
  public int getRecordCount() {

    callNumber += 1;
    if(callNumber == 2){
      prev = callNumber;
      return ++recordCount;
    }else if(callNumber - prev == 3){
      prev = callNumber;
      return ++recordCount;
    }else{
      return recordCount;
    }

  }

  @Override
  public void logInfo(String message) {

  }
}
