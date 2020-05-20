package org.leetcode.design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LoggerRateLimiter {

  private Map<String, Integer> lastPrintedTime;

  /**
   * Initialize your data structure here.
   */
  public LoggerRateLimiter() {
    this.lastPrintedTime = new LinkedHashMap<>();
  }

  /**
   * Returns true if the message should be printed in the given timestamp, otherwise returns false. If this method returns false, the
   * message will not be printed. The timestamp is in seconds granularity.
   */
  public boolean shouldPrintMessage(int timestamp, String message) {
    Integer lastTimeStamp = lastPrintedTime.get(message);
    if (lastTimeStamp == null) {
      lastPrintedTime.put(message, timestamp);
      return true;
    }
    else {
      if (timestamp - lastTimeStamp.intValue() >= 10) {
        lastPrintedTime.put(message, timestamp);
        return true;
      }
    }

    return false;
  }
}