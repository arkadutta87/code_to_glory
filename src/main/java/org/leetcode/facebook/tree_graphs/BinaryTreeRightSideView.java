package org.leetcode.facebook.tree_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeRightSideView {

  int maxDepth ;

  public List<Integer> rightSideView(TreeNode root) {
    maxDepth = 0;

    Map<Integer, Integer> rightSideView = new HashMap<>();

    rightSideViewLogic(root, 0, rightSideView);

    List<Integer> finalResult = new ArrayList<>();
    for(int i = 0 ; i <= maxDepth ; i++){
      if(rightSideView.get(i) != null) {
        finalResult.add(rightSideView.get(i));
      }
    }

    return finalResult;

  }

  private void rightSideViewLogic(TreeNode node, int index, Map<Integer, Integer> rightSideView) {

    if (node == null) {
      return;
    }

    if(index > maxDepth){
      maxDepth = index;
    }

    rightSideView.put(index, node.val);
    //do the left tree traversal
    rightSideViewLogic(node.left, index + 1, rightSideView);

    //do the right tree traversal
    rightSideViewLogic(node.right, index + 1, rightSideView);

  }


}
