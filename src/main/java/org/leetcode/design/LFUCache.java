package org.leetcode.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache {

  //Implement the Doubly LinkedList First -- This should work as a queue - FIFO - add to tail part remove from head part
  //This DLL should check for all corner cases

  class Data {

    int value;
    int key;
    int frequency;

    public Data(int key, int value, int frequency) {
      this.key = key;
      this.value = value;
      this.frequency = frequency;
    }
  }

  private int maxKeys;
  private int currentKeys;
  private Map<Integer, Node<Data>> cache;
  private TreeMap<Integer, DoublyLinkedListQueue> frequencyMap;

  public LFUCache(int maxKeys) {
    this.maxKeys = maxKeys;
    this.currentKeys = 0;
    cache = new HashMap<>();
    frequencyMap = new TreeMap<>();
  }

  public void put(int key, int value) {
    if(maxKeys == 0){
      return;
    }

    if (currentKeys < maxKeys) {
      if(!cache.containsKey(key)){
        currentKeys++;
      }

      persistPair(key, value);


    }
    else {
      //need to remove one LFU and if tie LRU
      if(!cache.containsKey(key)){
        removeAKeyAsPerLogic();
      }

      persistPair(key, value);

    }
  }

  private void persistPair(int key, int value) {
    Node<Data> dataNode = cache.get(key);
    if (dataNode == null) {
      Data data = new Data(key, value, 1);
      dataNode = new Node<>(data);

      //now just link the data node
      link(dataNode, dataNode.dataPart.frequency);
      //Add to the real cache
      cache.put(key, dataNode);
    }
    else {
      //data node was present

      //update the value - in case of update
      dataNode.dataPart.value = value;
      unLink(dataNode, dataNode.dataPart.frequency);
      dataNode.dataPart.frequency += 1;
      link(dataNode, dataNode.dataPart.frequency);
    }
  }

  private void removeAKeyAsPerLogic() {
    Map.Entry<Integer, DoublyLinkedListQueue> integerDoublyLinkedListQueueEntry = frequencyMap.firstEntry();
    int keyToRemove = integerDoublyLinkedListQueueEntry.getKey();
    DoublyLinkedListQueue ddl = integerDoublyLinkedListQueueEntry.getValue();

    Node<Data> removedNode = ddl.dequeu();
    if (ddl.isEmpty()) {
      frequencyMap.remove(keyToRemove);
    }

    cache.remove(removedNode.dataPart.key);

  }

  public int get(int key) {
    Node<Data> dataNode = cache.get(key);
    if (dataNode == null) {
      return -1;
    }

    //move around the Node - First unlink from the last frequency
    // Second add to the new frequency
    unLink(dataNode, dataNode.dataPart.frequency);
    dataNode.dataPart.frequency += 1;
    link(dataNode, dataNode.dataPart.frequency);


    return dataNode.dataPart.value;
  }

  private void unLink(Node<Data> node, int frequency) {
    if (frequencyMap.containsKey(frequency)) {
      DoublyLinkedListQueue doublyLinkedListQueue = frequencyMap.get(frequency);
      doublyLinkedListQueue.unlink(node);

      if(doublyLinkedListQueue.isEmpty()){
        frequencyMap.remove(frequency);
      }
    }
  }

  private void link(Node<Data> node, int frequency) {
    DoublyLinkedListQueue doublyLinkedListQueue = frequencyMap.computeIfAbsent(frequency, k -> new DoublyLinkedListQueue());
    doublyLinkedListQueue.enqueue(node);
  }


  public class Node<T> {

    T dataPart;
    Node<T> prev;
    Node<T> next;

    public Node(T dataPart) {
      this.dataPart = dataPart;
    }
  }


  //Generic Implementation
  public class DoublyLinkedListQueue {


    Node head;
    Node tail;

    public DoublyLinkedListQueue() {
      this.head = new Node(null);
      this.tail = new Node(null);

      //head.prev = null && tail.next = null - This is automatically done as per code
      //the below pointer declaration makes adding a new node a breeze - should use this approach - simple easy understandable code
      head.next = tail;
      tail.prev = head;

    }

    public boolean isEmpty() {
      if (head.next == tail && tail.prev == head) {
        return true;
      }

      return false;
    }

    // Add to the head part
    public <T> boolean enqueue(Node<T> node) {
      node.next = head.next;
      node.prev = head;
      head.next = node;

      // TODO:ARKA : Reverse Pointer not correctly set
      node.next.prev = node;

      return true;
    }

    public <T> boolean unlink(Node<T> node) {
      if (node.prev != null && node.next != null) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return true;
      }

      return false;
    }

    //Do this from the tail part
    public <T> Node<T> dequeu() {
      Node<T> node = null;
      if (tail.prev != head) {
        node = tail.prev;
        unlink(node);
      }
      return node;
    }

  }

  public static void main(String[] args) {

//    LFUCache cache = new LFUCache(2);
//    cache.put(1,1);
//    cache.put(2,2);
//    System.out.println(cache.get(1));
//    cache.put(3,3);
//    System.out.println(cache.get(2));
//    System.out.println(cache.get(3));
//    cache.put(4,4);
//    System.out.println(cache.get(1));
//    System.out.println(cache.get(3));
//    System.out.println(cache.get(4));

//    cache.put(3,1);
//    cache.put(2,1);
//    cache.put(2,2);
//    cache.put(4,4);
//    System.out.println(cache.get(2));


//    LFUCache cache = new LFUCache(0);
//    cache.put(0,0);
//    System.out.println(cache.get(0));

    /*
    ["LFUCache","put","put","get","put","put","get"]
    [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
     */

    LFUCache cache = new LFUCache(2);
    cache.put(2,1);
    cache.put(2,2);
    System.out.println(cache.get(2));
    cache.put(1,1);
    cache.put(4,1);
    System.out.println(cache.get(2));

  }

}
