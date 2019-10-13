package org.leetcode.data_structures.binary_tree;

public class InvertBinaryTree {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }

    invertTreeRecursive(root);

    return root;
  }

  private void invertTreeRecursive(TreeNode node) {
    if (node.left != null || node.right != null) {
      TreeNode lChild = node.left;
      TreeNode rChild = node.right;

      if (lChild != null) {
        invertTreeRecursive(lChild);
      }

      if (rChild != null) {
        invertTreeRecursive(rChild);
      }

      TreeNode temp = node.right;
      node.right = node.left;
      node.left = temp;
    }
  }
}

