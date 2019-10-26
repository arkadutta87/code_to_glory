package org.leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  int capacity;
  int currentCapacity;
  Map<Integer, Node> cache;
  DoubleLinkedList linkedList;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    currentCapacity = 0;
    cache = new HashMap<>();

    linkedList = new DoubleLinkedList();
  }

  //Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
  public int get(int key) {
    if (cache.containsKey(key)) {
      Node node = cache.get(key);

      //restructure the cache to put this to the top of the List
      linkedList.unLink(node);
      linkedList.enQueue(node);

      return node.val;
    }

    return -1;
  }

  //Set or insert the value if the key is not already present.
  // When the cache reached its capacity,
  // it should invalidate the least recently used item before inserting a new item.
  public void put(int key, int value) {

    Node node = new Node(key,value);
    //Case 1 : Move the node to the top
    if (cache.containsKey(key)) {
      Node nodePresent = cache.get(key);
      linkedList.unLink(nodePresent);
      linkedList.enQueue(node);

      cache.put(key,node);
    }
    else {
      //Case 2 : Key not present
      cache.put(key, node);
      if (currentCapacity < capacity) {
        // Add directly the new node;
        linkedList.enQueue(node);
        currentCapacity++;
      }
      else {
        Node nodeToRemove = linkedList.deQueue();
        linkedList.enQueue(node);

        cache.remove(nodeToRemove.key);
      }
    }

  }

  //Define the DLL Node
  class Node {

    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key,int val) {
      this.key = key;
      this.val = val;
    }
  }

  //Implement the DoubleLinkedList
  class DoubleLinkedList {

    Node head;
    Node tail;

    public DoubleLinkedList() {

      //initilize the head and the tail
      head = new Node(0, 0);
      tail = new Node(0, 0);

      //Now point head to tail and tail to head
      head.next = tail;
      tail.prev = head;
    }

    //this adds to the tail section
    public void enQueue(Node node) {
      node.next = tail;
      node.prev = tail.prev;

      //other pointers
      tail.prev.next = node;
      tail.prev = node;
    }

    public Node unLink(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;

      return node;
    }

    //This removes from the head section
    public Node deQueue() {
      Node removeThisOne = head.next;
      return unLink(removeThisOne);
    }
  }

  public static void main(String[] args) {
//    LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//    cache.put(1, 1);
//    cache.put(2, 2);
//    System.out.println(cache.get(1));       // returns 1
//    cache.put(3, 3);    // evicts key 2
//    System.out.println(cache.get(2));       // returns -1 (not found)
//    cache.put(4, 4);    // evicts key 1
//    System.out.println(cache.get(1));       // returns -1 (not found)
//    System.out.println(cache.get(3));       // returns 3
//    System.out.println(cache.get(4));       // returns 4

    LRUCache cache = new LRUCache( 2 /* capacity */ );
    cache.put(2, 1);
    cache.put(2, 2);
    System.out.println(cache.get(2));
    cache.put(1, 1);
    cache.put(4, 1);
    System.out.println(cache.get(2));
//    System.out.println(cache.get(3));



  }
}
