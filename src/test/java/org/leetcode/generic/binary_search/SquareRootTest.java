package org.leetcode.generic.binary_search;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SquareRootTest {

  @Test
  public void testSquareRootPositiveCase() {
    int value = 9;

    SquareRoot squareRoot = new SquareRoot();
    int sqrt = squareRoot.mySqrt(value);
    Assertions.assertEquals(3, sqrt);

    sqrt = squareRoot.mySqrt(4);
    Assertions.assertEquals(2, sqrt);

    sqrt = squareRoot.mySqrt(2);
    Assertions.assertEquals(1, sqrt);

    sqrt = squareRoot.mySqrt(8);
    Assertions.assertEquals(2, sqrt);

    sqrt = squareRoot.mySqrt(32);
    Assertions.assertEquals(5, sqrt);

    sqrt = squareRoot.mySqrt(2147395599);
    Assertions.assertEquals(46339, sqrt);

  }

  @Test
  public void testSquareRootNegativeNumbers() {
    int value = -9;

    SquareRoot squareRoot = new SquareRoot();
    int sqrt = squareRoot.mySqrt(value);
    Assertions.assertEquals(-9, sqrt);
  }

  @Test
  public void testSquareRootPartInteger() {
    int value = 20;

    SquareRoot squareRoot = new SquareRoot();
    int sqrt = squareRoot.mySqrt(value);
    Assertions.assertEquals(4, sqrt);

  }

  @Test
  public void testSquareRootZeroCase() {
    int value = 0;

    SquareRoot squareRoot = new SquareRoot();
    int sqrt = squareRoot.mySqrt(value);
    Assertions.assertEquals(0, sqrt);

    sqrt = squareRoot.mySqrt(1);
    Assertions.assertEquals(1, sqrt);

  }


}
