package org.leetcode.graphs_trees;

import javafx.util.Pair;

/*
Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST. If the given node has no in-order successor in the tree, return null.

The successor of a node p is the node with the smallest key greater than p.val.

================

Input: root = [2,1,3], p = 1
Output: 2


==============

Input: root = [5,3,6,2,4,null,null,1], p = 6
Output: null
 */

public class InOrderSuccessorInBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        while(root != null){
            if(p.val >= root.val){
                root = root.right;
            }else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }
}
