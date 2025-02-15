package org.leetcode.graphs_trees;

/*
 You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a
 list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between
 nodes ai and bi in the graph.

Return true if the edges of the given graph make up a valid tree, and false otherwise.

==========================
Example - 1 =>
Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
Output: true


============================
Example - 2 =>
Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
Output: false

=============================
 */

import java.util.HashSet;

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {

        var vertex = new int[n];
        var rank = new int[n];

        for (var i = 0; i < n; i++) {
            vertex[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            var success = unionViaRank(node1, node2, vertex, rank);
            if (!success) {
                return false;
            }
        }

        var components = new HashSet<Integer>();
        for (var i = 0; i < n; i++) {
            var headNode = find(i, vertex);
            components.add(headNode);
        }
        return components.size() == 1;
    }

    private boolean unionViaRank(int node1, int node2, int[] vertex, int[] rank) {
        int headNode1 = find(node1, vertex);
        int headNode2 = find(node2, vertex);

        if (headNode1 == headNode2) {
            return false;
        }

        int rank1 = rank[headNode1];
        int rank2 = rank[headNode2];

        if (rank1 > rank2) {
            vertex[headNode2] = headNode1;
        } else if (rank2 > rank1) {
            vertex[headNode1] = headNode2;
        } else {
            vertex[headNode2] = headNode1;
            rank[headNode1] += 1;
        }

        return true;
    }

    private int find(int node, int[] vertex) {
        var headNode = vertex[node];

        if(headNode == node){
            return headNode;
        }

        return vertex[node] = find(headNode, vertex);
    }
}
