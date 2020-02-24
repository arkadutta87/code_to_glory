package org.leetcode.generic.binary_search;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BinarySearchSortedArrayTest {

  @Test
  public void testBinarySearchWithNumberPresent() {
    int[] sortedArray = {-1, 0, 3, 5, 9, 12};

    BinarySearchSortedArray binarySearcher = new BinarySearchSortedArray();
    int index = binarySearcher.search(sortedArray, 9);
    Assertions.assertEquals(4, index);

  }

  @Test
  public void testBinarySearchWithNumberAbsentLeftBoundary() {
    int[] sortedArray = {-1, 0, 3, 5, 9, 12};

    BinarySearchSortedArray binarySearcher = new BinarySearchSortedArray();
    int index = binarySearcher.search(sortedArray, -2);
    Assertions.assertEquals(-1, index);

  }

  @Test
  public void testBinarySearchWithNumberAbsentRigthBoundary() {
    int[] sortedArray = {-1, 0, 3, 5, 9, 12};

    BinarySearchSortedArray binarySearcher = new BinarySearchSortedArray();
    int index = binarySearcher.search(sortedArray, 13);
    Assertions.assertEquals(-1, index);

  }

  @Test
  public void testBinarySearchWithNumberAbsent() {
    int[] sortedArray = {-1, 0, 3, 5, 9, 12};

    BinarySearchSortedArray binarySearcher = new BinarySearchSortedArray();
    int index = binarySearcher.search(sortedArray, 13);
    Assertions.assertEquals(-1, index);

  }

  @Test
  public void testBinarySearchEmptyArray() {
    int[] sortedArray = {};

    BinarySearchSortedArray binarySearcher = new BinarySearchSortedArray();
    int index = binarySearcher.search(sortedArray, 13);
    Assertions.assertEquals(-1, index);

  }



}
