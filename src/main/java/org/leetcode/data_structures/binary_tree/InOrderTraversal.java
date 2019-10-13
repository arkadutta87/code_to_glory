package org.leetcode.data_structures.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> elements = new ArrayList<>();

    traverseInOrder(root, elements);

    return elements;
  }

  private void traverseInOrder(TreeNode node, List<Integer> elements){
    if(node != null){
      traverseInOrder(node.left, elements);
      elements.add(node.val);
      traverseInOrder(node.right, elements);


    }
  }
}
