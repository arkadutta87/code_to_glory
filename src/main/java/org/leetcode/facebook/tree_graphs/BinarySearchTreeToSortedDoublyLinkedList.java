package org.leetcode.facebook.tree_graphs;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeToSortedDoublyLinkedList {

  class Node {

    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val, Node _left, Node _right) {
      val = _val;
      left = _left;
      right = _right;
    }
  }

  public Node treeToDoublyList(Node root) {
    if (root == null) {
      return null;
    }

    List<Node> inOrderList = new ArrayList<Node>();

    buildTheList(root, inOrderList);
    int size = inOrderList.size();
    for (int i = 0; i < size; i++) {
      Node currentNode = inOrderList.get(i);
      if (i == 0) {
        currentNode.left = inOrderList.get(size - 1);
      }
      //end pointer case
      if (i == size - 1) {
        currentNode.right = inOrderList.get(0);
      }

      //next pointer
      if (i <= size - 2) {
        currentNode.right = inOrderList.get(i + 1);
      }

      //prev pointer
      if (i >= 1) {
        currentNode.left = inOrderList.get(i - 1);
      }
    }

    return inOrderList.get(0);
  }

  private void buildTheList(Node node, List<Node> list) {
    if (node == null) {
      return;
    }

    buildTheList(node.left, list);
    list.add(node);
    buildTheList(node.right, list);
  }
}
