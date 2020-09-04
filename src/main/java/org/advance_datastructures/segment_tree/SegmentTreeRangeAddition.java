package org.advance_datastructures.segment_tree;

import java.util.Arrays;

public class SegmentTreeRangeAddition {

  public static void main(String[] args) {

    int[] array = {1, 3, 5, 7, 9, 11};
    SegmentTreeRangeAddition adder = new SegmentTreeRangeAddition();
    int[] segmentTree = adder.buildSegementTree(array);
    Arrays.stream(segmentTree).forEach(System.out::println);
  }

  //Builds the segment tree from the input array : Logic is that of sum of elements within a range
  public int[] buildSegementTree(int[] array) {
    int sizeOfSegmentTree = calculateSizeOfSegementTree(array.length);
    int[] segementTree = new int[sizeOfSegmentTree];

    buildSegmentTreeRecursively(array, segementTree, 0, array.length - 1, 0);
    return segementTree;
  }

  private void buildSegmentTreeRecursively(int[] array, int[] segementTree, int low, int high, int position) {
    //finalization case
    if (low == high) {
      segementTree[position] = array[low];
    }
    else {
      int mid = (low + high) / 2;
      //build left sub-tree
      buildSegmentTreeRecursively(array, segementTree, low, mid, 2 * position + 1);
      // build right sub-tree
      buildSegmentTreeRecursively(array, segementTree, mid + 1, high, 2 * position + 2);
      //now populate the segment tree at the position
      segementTree[position] = segementTree[2 * position + 1] + segementTree[2 * position + 2];
    }
  }

  private int calculateSizeOfSegementTree(int arraySize) {
    return 2 * (int) Math.pow(2, (int) Math.ceil(Math.log(arraySize) / Math.log(2))) - 1;
  }
}
