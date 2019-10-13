package org.leetcode.data_structures.binary_tree;

public class MaximumDepthOfBinaryTree {

  public int maxDepth(TreeNode root) {
    return returnMaxDepth(root);
  }

  private int returnMaxDepth(TreeNode node){
    if(node == null){
      return 0;
    }

    int leftSubTreeDepth = returnMaxDepth(node.left);
    int rightSubTreeDepth = returnMaxDepth(node.right);

    return Math.max(leftSubTreeDepth, rightSubTreeDepth) + 1;
  }
}
