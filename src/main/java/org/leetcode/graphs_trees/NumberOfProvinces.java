package org.leetcode.graphs_trees;

/*
There are n cities. Some of them are connected, while some are not.
 If city a is connected directly with city b, and city b is connected directly with city c,
 then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1
if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.


----------------------------------

Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2


---------------------------------

Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3

 */

import java.util.HashSet;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {

        var noOfElements = isConnected.length;

        var vertex = new int[noOfElements];
        var rank = new int[noOfElements];

        for (var i = 0; i < noOfElements; i++) {
            vertex[i] = i;
            rank[i] = 1;
        }

        for (var i = 0; i < noOfElements; i++) {
            for (var j = i + 1; j < noOfElements; j++) {
                if (isConnected[i][j] == 1) {
                    unionByRank(i, j, vertex, rank);
                }
            }
        }

        // find connected components
        var provincesCount = 0;
        var componentVertexes = new HashSet<>();

        for (var i = 0; i < noOfElements; i++) {
            var head = findVertex(i, vertex);
            if (!componentVertexes.contains(head)) {
                provincesCount += 1;
                componentVertexes.add(head);
            }
        }
        return provincesCount;
    }

    private void unionByRank(int node1, int node2, int[] vertex, int[] rank) {
        var vertexOfNode1 = findVertex(node1, vertex);
        var vertexOfNode2 = findVertex(node2, vertex);


        if (vertexOfNode1 != vertexOfNode2) {
            //find the rank of the nodes
            var rankOfNode1 = rank[vertexOfNode1];
            var rankOfNode2 = rank[vertexOfNode2];

            if (rankOfNode1 > rankOfNode2) {
                vertex[vertexOfNode2] = vertexOfNode1;
            } else if (rankOfNode2 > rankOfNode1) {
                vertex[vertexOfNode1] = vertexOfNode2;
            } else {
                vertex[vertexOfNode1] = vertexOfNode2;
                rank[vertexOfNode2] += 1;
            }
        }
    }

    private int findVertex(int node, int[] vertex) {
        var vertedNode = vertex[node];

        if (vertedNode == node) {
            return vertedNode;
        }

        return vertex[node] = findVertex(vertedNode, vertex);
    }
}
