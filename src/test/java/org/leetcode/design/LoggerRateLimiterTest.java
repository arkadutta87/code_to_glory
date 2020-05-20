package org.leetcode.design;

    import org.junit.Test;
    import org.junit.jupiter.api.Assertions;

public class LoggerRateLimiterTest {

  @Test
  public void testPositiveCase() {
    LoggerRateLimiter logger = new LoggerRateLimiter();

    Assertions.assertEquals(logger.shouldPrintMessage(1, "foo"), true);
    Assertions.assertEquals(logger.shouldPrintMessage(2, "bar"), true);
    Assertions.assertEquals(logger.shouldPrintMessage(3, "foo"), false);
    Assertions.assertEquals(logger.shouldPrintMessage(8, "bar"), false);
    Assertions.assertEquals(logger.shouldPrintMessage(10, "foo"), false);
    Assertions.assertEquals(logger.shouldPrintMessage(11, "foo"), true);
  }
}
