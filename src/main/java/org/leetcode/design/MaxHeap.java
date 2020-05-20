package org.leetcode.design;

public class MaxHeap<T> {

  private HeapNode[] heap;
  private int currentLocation;
  private int heapSize;

  public static class HeapNode<T> {

    public T data;
    public long weight;

    public HeapNode(T data, long weight) {
      this.data = data;
      this.weight = weight;
    }

  }

  public int size() {
    return currentLocation + 1;
  }

  public boolean isEmpty() {
    return size() == 0 ? true : false;
  }

  public MaxHeap(int heapSize) {
    this.heapSize = heapSize;
    this.currentLocation = -1;
    this.heap = new HeapNode[heapSize];
  }

  public <T> boolean insertData(HeapNode node) {
    //insert the node to the last location
    if ((currentLocation + 1) >= heapSize) {
      return false;
    }

    heap[++currentLocation] = node;

    //now check with its parent - if its greater than parent
    int parentIndex = -1;
    int childIndex = currentLocation;
    while ((parentIndex = (childIndex - 1) / 2) >= 0) {
      HeapNode parent = heap[parentIndex];
      if (node.weight > parent.weight) {
        //swap the nodes
        heap[childIndex] = parent;
        heap[parentIndex] = node;

        childIndex = parentIndex;
      }
      else {
        break;
      }
    }

    return true;
  }

  public <T> HeapNode<T> peekMax() {
    return currentLocation == -1 ? null : heap[0];
  }

  public <T> HeapNode<T> deleteMax() {
    if (currentLocation < 0) {
      return null;
    }

    HeapNode max = heap[0];
    //swap root with the last element
    heap[0] = heap[currentLocation--];

    //heapify
    int index = 0;
    int lchildIndex = 2 * index + 1;
    int rchildIndex = 2 * index + 2;

    while (lchildIndex <= currentLocation) {
      HeapNode node = heap[index];
      HeapNode lchild = heap[lchildIndex];

      if (node.weight < lchild.weight) {
        //check lesser between lchild and rchild
        int indexToReplace = lchildIndex;
        if (rchildIndex <= currentLocation) {
          if (heap[rchildIndex].weight > heap[lchildIndex].weight) {
            indexToReplace = rchildIndex;
          }
        }

        heap[index] = heap[indexToReplace];
        heap[indexToReplace] = node;

        index = indexToReplace;
      }
      else {
        //check if node is less than rchild
        if (rchildIndex <= currentLocation) {
          HeapNode rchild = heap[rchildIndex];
          if (node.weight < rchild.weight) {
            //replace with rchild
            heap[index] = heap[rchildIndex];
            heap[rchildIndex] = node;
            index = rchildIndex;
          }
          else {
            break;
          }
        }
        else {
          break;
        }
      }

      lchildIndex = 2 * index + 1;
      rchildIndex = 2 * index + 2;
    }

    return max;
  }

}
