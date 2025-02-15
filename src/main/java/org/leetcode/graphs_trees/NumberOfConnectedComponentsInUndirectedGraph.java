package org.leetcode.graphs_trees;

/*
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi]
indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.

====================

Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2


===================

Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1
 */

import java.util.HashSet;

public class NumberOfConnectedComponentsInUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        var vertex = new int[n];
        var rank = new int[n];

        for (var i = 0; i < n; i++) {
            vertex[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            unionViaRank(node1, node2, vertex, rank);
        }

        var components = new HashSet<Integer>();
        for (var i = 0; i < n; i++) {
            var headNode = find(i, vertex);
            components.add(headNode);
        }
        return components.size();
    }

    private void unionViaRank(int node1, int node2, int[] vertex, int[] rank) {
        int headNode1 = find(node1, vertex);
        int headNode2 = find(node2, vertex);

        if (headNode1 == headNode2) {
            return ;
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
    }

    private int find(int node, int[] vertex) {
        var headNode = vertex[node];

        if(headNode == node){
            return headNode;
        }

        return vertex[node] = find(headNode, vertex);
    }
}
