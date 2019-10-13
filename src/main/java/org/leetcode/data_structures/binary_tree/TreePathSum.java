package org.leetcode.data_structures.binary_tree;

public class TreePathSum {

  public boolean hasPathSum(TreeNode root, int sum) {
      if(root == null){
        return false;
      }

      return hasAPathEqualToSum(root, sum);
  }

  private boolean hasAPathEqualToSum(TreeNode node, int sum){

    if(node.left == null &&
        node.right == null){
      return sum - node.val == 0;
    }

    boolean result = false;

    if(node.left != null){
      result |= hasAPathEqualToSum(node.left, sum - node.val);
    }

    if(node.right != null){
      result |= hasAPathEqualToSum(node.right, sum - node.val);
    }

    return result;

  }
}
