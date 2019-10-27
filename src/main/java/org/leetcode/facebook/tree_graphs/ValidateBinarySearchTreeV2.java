package org.leetcode.facebook.tree_graphs;

public class ValidateBinarySearchTreeV2 {

  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }

  private boolean helper(TreeNode node, Integer lowerLimit, Integer upperLimit) {
    if (node == null) {
      return true;
    }

    if (lowerLimit != null && (lowerLimit >= node.val)) {
      return false;
    }
    if (upperLimit != null && (node.val >= upperLimit)) {
      return false;
    }

    return helper(node.left, lowerLimit, node.val) && helper(node.right, node.val, upperLimit);
  }
}
