package org.leetcode.facebook.tree_graphs;

public class BSTTOSortedDoublyLinkedListV2 {

  Node first = null;
  Node last = null;

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
      return root;
    }

    helper(root);

    first.left = last;
    last.right = first;

    return first;

  }

  private void helper(Node node) {
    if (node != null) {

      //traverse the left tree
      helper(node.left);

      if (last != null) {
        node.left = last;
        last.right = node;

      }
      else {
        first = node;
      }

      last = node;
      //traverse the right tree
      helper(node.right);
    }
  }


}
