package org.leetcode.data_structures.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostOrderTraversal {

  public List<Integer> postorderTraversal(TreeNode root) {

    List<Integer> elements = new ArrayList<>();
    traversePostOrder(root, elements);
    return elements;
  }

  private void traversePostOrder(TreeNode node, List<Integer> elements){
    if(Objects.nonNull(node)){
      traversePostOrder(node.left, elements);
      traversePostOrder(node.right, elements);

      elements.add(node.val);
    }
  }
}
