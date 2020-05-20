package org.leetcode.design;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MaxHeapTest {

  @Test
  public void testPositiveCase(){
    MaxHeap maxHeap = new MaxHeap(5);

    Assertions.assertEquals(maxHeap.peekMax(), null);
    Assertions.assertEquals(maxHeap.insertData(new MaxHeap.HeapNode<Integer>(6,6)), true);
    Assertions.assertEquals(maxHeap.insertData(new MaxHeap.HeapNode<Integer>(8,8)), true);
    Assertions.assertEquals(maxHeap.insertData(new MaxHeap.HeapNode<Integer>(2,2)), true);
    Assertions.assertEquals(maxHeap.insertData(new MaxHeap.HeapNode<Integer>(7,7)), true);
    Assertions.assertEquals(maxHeap.insertData(new MaxHeap.HeapNode<Integer>(5,5)), true);
    Assertions.assertEquals(maxHeap.insertData(new MaxHeap.HeapNode<Integer>(4,4)), false);

    Assertions.assertEquals(maxHeap.peekMax().weight, 8);
    Assertions.assertEquals(maxHeap.deleteMax().weight,8 );
    Assertions.assertEquals(maxHeap.deleteMax().weight,7 );
    Assertions.assertEquals(maxHeap.deleteMax().weight,6 );
    Assertions.assertEquals(maxHeap.deleteMax().weight,5 );
    Assertions.assertEquals(maxHeap.insertData(new MaxHeap.HeapNode(9,9)), true);
    Assertions.assertEquals(maxHeap.peekMax().weight, 9);
    Assertions.assertEquals(maxHeap.size(), 2);

  }
}
