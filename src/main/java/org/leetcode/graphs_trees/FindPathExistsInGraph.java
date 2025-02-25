package org.leetcode.graphs_trees;

/*
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a
bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.


====================================================

Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2


========================================================

Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.

=============================================

Constraints:

1 <= n <= 2 * 105
0 <= edges.length <= 2 * 105
edges[i].length == 2
0 <= ui, vi <= n - 1
ui != vi
0 <= source, destination <= n - 1
There are no duplicate edges.
There are no self edges.

 */

import java.util.HashSet;
import java.util.Set;

public class FindPathExistsInGraph {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];

            graph[i][j] = 1;
            graph[j][i] = 1;
        }

        Set<Integer> visitedNodes = new HashSet<>();
        return dfs(source, visitedNodes, graph, destination);
    }

    private boolean dfs(int node, Set<Integer> visitedNodes, int[][] graph, int end) {

        if (node == end) {
            return true;
        }
        if (visitedNodes.contains(node)) {
            return false;
        }

        boolean destinationFound = false;

        for (int j = 0; j < graph.length; j++) {

            if (!destinationFound) {
                visitedNodes.add(node);

                if (graph[node][j] == 1) {

                    if (!visitedNodes.contains(j)) {
                        graph[node][j] = 0; // we have visited it
                        destinationFound = dfs(j, visitedNodes, graph, end);
                    }

                }
            }
        }

        return destinationFound;
    }
}
