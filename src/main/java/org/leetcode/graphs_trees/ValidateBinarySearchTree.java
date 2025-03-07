package org.leetcode.graphs_trees;

public class ValidateBinarySearchTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isSubTreeValid(root.left, Long.MIN_VALUE, root.val)
                 && isSubTreeValid(root.right, root.val, Long.MAX_VALUE);
    }

    private boolean isSubTreeValid(TreeNode node, long min, long max){
        if(node == null){
            return true;
        }

        if(!( min < node.val &&  node.val < max)){
            return false;
        }

        return isSubTreeValid(node.left, min, node.val)
                && isSubTreeValid(node.right, Math.max(node.val, min), Math.max(node.val, max));
    }
}
