package org.leetcode.facebook.tree_graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.omg.CORBA.INTERNAL;

public class LowestCommonAncestorBinaryTree {

  class Record {

    TreeNode node;
    TreeNode parent;
    int depth;

    public Record(TreeNode node, TreeNode parent, int depth) {
      this.node = node;
      this.parent = parent;
      this.depth = depth;
    }

  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    Map<Integer, TreeNode> childToParentMap = new HashMap<>();

    Integer d1 = null, d2 = null;
    Queue<Record> bfsQueue = new LinkedList<>();

    bfsQueue.add(new Record(root, null, 0));

    while (!bfsQueue.isEmpty()) {
      Record data = bfsQueue.remove();

      if (d1 != null && d2 != null) {
        break;
      }

      //See if this node is p
      if (data.node.val == p.val) {
        d1 = data.depth;
      }

      //See if this node is q
      if (data.node.val == q.val) {
        d2 = data.depth;
      }

      //populate the childToParentMap
      if (data.parent != null) {
        childToParentMap.put(data.node.val, data.parent);
      }

      //Now add the left child and right child
      TreeNode node = data.node;
      if (node.left != null) {
        bfsQueue.add(new Record(node.left, node, data.depth + 1));
      }

      if (node.right != null) {
        bfsQueue.add(new Record(node.right, node, data.depth + 1));
      }

    }

    TreeNode deeperNode = null;
    TreeNode otherNode = null;

    if (d1 <= d2) {
      deeperNode = q;
      otherNode = p;
    }
    else {
      deeperNode = p;
      otherNode = q;
    }
    System.out.println("The Starting Node : " + deeperNode.val);

    for (int i = 0; i < Math.abs(d1 - d2); i++) {
      deeperNode = childToParentMap.get(deeperNode.val);
      System.out.println("The parent : "+ deeperNode.val);
    }


    while(deeperNode != otherNode){
      deeperNode = childToParentMap.get(deeperNode.val);
      otherNode = childToParentMap.get(otherNode.val);
    }

    return deeperNode;

  }
}
