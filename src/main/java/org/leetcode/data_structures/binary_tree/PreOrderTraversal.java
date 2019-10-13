package org.leetcode.data_structures.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {

  public List<Integer> preorderTraversal(TreeNode root){
    List<Integer> elements = new ArrayList<>();

    traversePreOrder(root, elements);

    return elements;
  }

  private void traversePreOrder(TreeNode node, List<Integer> elements){
    if(node != null){
      elements.add(node.val);
      traversePreOrder(node.left, elements);
      traversePreOrder(node.right, elements);
    }
  }
}
