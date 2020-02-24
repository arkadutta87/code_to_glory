package org.leetcode.design;

import java.util.Stack;


public class BSTIterator {

  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right ;

    public TreeNode(int x){
      this.val = x;
    }
  }

  private Stack<TreeNode> internalDSToIterate;

  public BSTIterator(TreeNode root){
    internalDSToIterate = new Stack<>();

    if(root != null){
      insertTheLeftTreeIterative(root);
    }
  }

//  private void insertTheLeftTree(TreeNode node){
//    if(node != null){
//      internalDSToIterate.push(node);
//      insertTheLeftTree(node.left);
//    }
//  }

  private void insertTheLeftTreeIterative(TreeNode node){
    while(node != null){
      internalDSToIterate.push(node);
      node = node.left;
    }
  }

  public int next(){
    TreeNode pop = internalDSToIterate.pop();
    if(pop.right != null){
      insertTheLeftTreeIterative(pop.right);
    }

    return pop.val;
  }

  public boolean hasNext(){
    return !internalDSToIterate.isEmpty();
  }
}
