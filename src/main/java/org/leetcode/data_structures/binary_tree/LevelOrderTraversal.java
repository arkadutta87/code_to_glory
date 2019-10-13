package org.leetcode.data_structures.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> elementsInLevelOrderTraversal = new ArrayList<>();

    Queue<TreeNode> queue = new LinkedList<>();

    if(root != null){
      int elementsInLevel = 1;
      queue.add(root);

      while(!queue.isEmpty()){
        List<Integer> innerList = new ArrayList<>();
        int temp = 0;
        for(int i =0 ; i< elementsInLevel ; i++){
          TreeNode node = queue.poll();
          innerList.add(node.val);

          if(node.left != null){
            queue.add(node.left);
            temp++;
          }

          if(node.right != null){
            queue.add(node.right);
            temp++;
          }
        }
        elementsInLevelOrderTraversal.add(innerList);
        elementsInLevel = temp;
      }
    }

    return elementsInLevelOrderTraversal;
  }
}
