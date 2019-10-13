package org.leetcode.data_structures.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversalIterative {

  public List<Integer> preorderTraversal(TreeNode root){
    List<Integer> elementsInPreOrder = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while(!stack.isEmpty()){
      TreeNode node = stack.pop();

      if(node != null){
        elementsInPreOrder.add(node.val);
        stack.push(node.right);
        stack.push(node.left);
      }
    }

    return elementsInPreOrder;
  }
}
