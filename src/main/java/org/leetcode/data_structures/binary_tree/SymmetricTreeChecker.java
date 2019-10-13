package org.leetcode.data_structures.binary_tree;

public class SymmetricTreeChecker {

  public boolean isSymmetric(TreeNode root) {
    return checker(root, root);
  }

  private boolean checker(TreeNode node1, TreeNode node2){
    if(node1 == null || node2 == null)
      return node1 == node2;

    if(node1.val!= node2.val)
      return false;

    return checker(node1.left, node2.right) && checker(node1.right, node2.left);
  }
}
