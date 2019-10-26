package org.leetcode.design;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MaxStackV2 {

  DoubleLinkedListStack<Integer> doubleLinkedListStackImpl;
  TreeMap<Integer, List<DoublyLinkedListNode<Integer>>> treeMap;

  public MaxStackV2(){
    doubleLinkedListStackImpl = new DoubleLinkedListStack<>();
    treeMap = new TreeMap<>();
  }

  //Push element x onto stack.
  public void push(int x){
    DoublyLinkedListNode<Integer> node = new DoublyLinkedListNode<>(x);

    List<DoublyLinkedListNode<Integer>> list = treeMap.computeIfAbsent(x, k -> new ArrayList<DoublyLinkedListNode<Integer>>());
    list.add(node);
    doubleLinkedListStackImpl.insert(node);
  }

  //Remove the element on top of the stack and return it.
  public int pop(){

    DoublyLinkedListNode<Integer> topNode = doubleLinkedListStackImpl.pop();
    Integer data = topNode.data;

    List<DoublyLinkedListNode<Integer>> list = treeMap.get(data);
    list.remove(list.size() -1);

    if(list.isEmpty()){
      treeMap.remove(data);
    }

    return data;
  }

  //Get the element on the top.
  public int top(){
    DoublyLinkedListNode<Integer> peek = doubleLinkedListStackImpl.peek();

    return peek.data;
  }

  //Retrieve the maximum element in the stack.
  public int peekMax(){
    return treeMap.lastKey();
  }

  //Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
  public int popMax(){
    int maxElement = peekMax();
    List<DoublyLinkedListNode<Integer>> list = treeMap.get(maxElement);

    DoublyLinkedListNode<Integer> nodeToRemove = list.remove(list.size() - 1);
    doubleLinkedListStackImpl.unlink(nodeToRemove);

    if(list.isEmpty()){
      treeMap.remove(maxElement);
    }

    return maxElement;
  }

  //Definition of Node
  class DoublyLinkedListNode<T> {

    T data;
    DoublyLinkedListNode<T> next;
    DoublyLinkedListNode<T> prev;

    public DoublyLinkedListNode(T data){
      this.data = data;
    }

  }

  //Implement The DoubleLinkedList
  class DoubleLinkedListStack<T>{
    DoublyLinkedListNode<T> head;
    DoublyLinkedListNode<T> tail;

    public DoubleLinkedListStack(){
      head = new DoublyLinkedListNode<>(null);
      tail = new DoublyLinkedListNode<>(null);

      //point head and tail to each other
      head.next = tail;
      tail.prev = head;
    }

    public void insert(DoublyLinkedListNode node){

      //Node pointers
      node.next = tail;
      node.prev = tail.prev;

      //other pointers
      tail.prev.next = node;
      tail.prev = node;
    }

    public DoublyLinkedListNode<T> unlink(DoublyLinkedListNode<T> node){
      node.prev.next = node.next;
      node.next.prev = node.prev;

      return node;
    }

    public DoublyLinkedListNode<T> pop(){
      return unlink(tail.prev);
    }

    public DoublyLinkedListNode<T> peek(){
      return tail.prev;
    }
  }

  public static void main(String[] args) {
    MaxStackV2 stack = new MaxStackV2();
    stack.push(5);
//    stack.push(1);
//    stack.push(5);
    System.out.println(stack.top()); //-> 5
    System.out.println(stack.popMax()); //-> 5
//    System.out.println(stack.top()); //-> 1
//    System.out.println(stack.peekMax()); //-> 5 -> 1
//    System.out.println(stack.pop()); //-> 1
//    System.out.println(stack.top()); //-> 5

  }

}
