package org.leetcode.facebook.tree_graphs;

public class BinaryTreeMaximumPathSum {

  private int sum ;

  public int maxPathSum(TreeNode root) {
    sum = Integer.MIN_VALUE;

    contributionOfNode(root);
    return sum;
  }

  private int contributionOfNode(TreeNode node){

    if(node == null){
      return 0;
    }

    int leftContribution = contributionOfNode(node.left);
    int rightContribution = contributionOfNode(node.right);

    //check whether considering this node can increase the max path sum

    int maxSum = node.val + leftContribution + rightContribution;

    if(maxSum > sum){
      sum = maxSum;
    }

    int contribution  = node.val + Math.max(leftContribution , rightContribution);
    if(contribution < 0){
      return 0;
    }else{
      return contribution;
    }

  }
}
