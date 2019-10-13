package org.leetcode.data_structures.binary_tree;

public class UniValSubTreeCounter {

  public int countUnivalSubtrees(TreeNode root) {
    int[] count = {0};

    if(root == null){
      return count[0];
    }
    isUniValSubTree(root, count);

    return count[0];
  }

  private boolean isUniValSubTree(TreeNode node, int[] count){
    if(node.left == null &&
        node.right == null){
      count[0]++;
      return true;
    }

    boolean isUniVal = true;

    if(node.left != null){
      isUniVal &= isUniValSubTree(node.left, count);
    }

    if(node.right != null){
      isUniVal &= isUniValSubTree(node.right, count);
    }

    if(isUniVal){
      boolean flag = true;
      if(node.left != null){
        flag &= (node.left.val == node.val);
      }

      if(node.right != null){
        flag &= (node.right.val == node.val);
      }

      if(flag){
        count[0]++;
        return true;
      }else{
        return false;
      }
    }

    return false;
  }
}
