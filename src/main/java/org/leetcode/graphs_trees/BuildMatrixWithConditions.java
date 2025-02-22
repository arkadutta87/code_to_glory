package org.leetcode.graphs_trees;

/*
You are given a positive integer k. You are also given:

a 2D integer array rowConditions of size n where rowConditions[i] = [abovei, belowi], and
a 2D integer array colConditions of size m where colConditions[i] = [lefti, righti].
The two arrays contain integers from 1 to k.

You have to build a k x k matrix that contains each of the numbers from 1 to k exactly once. The remaining cells should have the value 0.

The matrix should also satisfy the following conditions:

The number abovei should appear in a row that is strictly above the row at which the number belowi appears for all i from 0 to n - 1.
The number lefti should appear in a column that is strictly left of the column at which the number righti appears for all i from 0 to m - 1.
Return any matrix that satisfies the conditions. If no answer exists, return an empty matrix.

===============================
Input: k = 3, rowConditions = [[1,2],[3,2]], colConditions = [[2,1],[3,2]]
Output: [[3,0,0],[0,0,1],[0,2,0]]
Explanation: The diagram above shows a valid example of a matrix that satisfies all the conditions.
The row conditions are the following:
- Number 1 is in row 1, and number 2 is in row 2, so 1 is above 2 in the matrix.
- Number 3 is in row 0, and number 2 is in row 2, so 3 is above 2 in the matrix.
The column conditions are the following:
- Number 2 is in column 1, and number 1 is in column 2, so 2 is left of 1 in the matrix.
- Number 3 is in column 0, and number 2 is in column 1, so 3 is left of 2 in the matrix.
Note that there may be multiple correct answers.

================================

Input: k = 3, rowConditions = [[1,2],[2,3],[3,1],[2,3]], colConditions = [[2,1]]
Output: []
Explanation: From the first two conditions, 3 has to be below 1 but the third conditions needs 3 to be above 1 to be satisfied.
No matrix can satisfy all the conditions, so we return the empty matrix.
 */

import java.util.*;

public class BuildMatrixWithConditions {

    private static class NodeData {

        private int inDegree;
        private Set<Integer> associatedNodes;


        public NodeData() {
            this.inDegree = 0;
            associatedNodes = new HashSet<>();
        }

        public void addNode(int node) {
            associatedNodes.add(node);
        }

        public void decrementInDegree() {
            this.inDegree -= 1;
        }

        public void incrementInDegree() {
            this.inDegree += 1;
        }

        public int getInDegree() {
            return inDegree;
        }

        public Set<Integer> getAssociatedNodes() {
            return associatedNodes;
        }
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        //build the topological order for row

        List<Integer> rowSortOrder = createTopologicalSort(rowConditions, k);
        if (rowSortOrder.size() != k) {
            return new int[][]{};
        }

        List<Integer> columnSortOrder = createTopologicalSort(colConditions, k);
        if (columnSortOrder.size() != k) {
            return new int[][]{};
        }

        Map<Integer, int[]> elementOrder = new HashMap<>();
        int i = 0;
        for (int row : rowSortOrder) {
            int[] places = elementOrder.computeIfAbsent(row, no -> new int[]{0, 0});
            places[0] = i++;
        }

        int j = 0;
        for (int col : columnSortOrder) {
            int[] places = elementOrder.computeIfAbsent(col, no -> new int[]{0, 0});
            places[1] = j++;
        }

        int[][] matrix = new int[k][k];
        for (Map.Entry<Integer, int[]> entry : elementOrder.entrySet()) {
            Integer element = entry.getKey();
            int[] positions = entry.getValue();

            matrix[positions[0]][positions[1]] = element;
        }

        return matrix;
    }

    private static List<Integer> createTopologicalSort(int[][] conditions, int k) {
        Map<Integer, NodeData> graph = new HashMap<>();

        for (int[] condition : conditions) {
            int firstNode = condition[0];
            int laterNode = condition[1];

            NodeData dataFirst = graph.computeIfAbsent(firstNode, nd -> new NodeData());

            if(!dataFirst.getAssociatedNodes().contains(laterNode)) {
                dataFirst.addNode(laterNode);
                NodeData dataLater = graph.computeIfAbsent(laterNode, bd -> new NodeData());
                dataLater.incrementInDegree();
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1 ; i <= k; i++) {
            NodeData nodeData = graph.getOrDefault(i, new NodeData());
            if (nodeData.getInDegree() == 0) {
                queue.add(i);
            }
        }

        List<Integer> sortOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer element = queue.poll();
            sortOrder.add(element);

            NodeData elementData = graph.getOrDefault(element, new NodeData());
            for (Integer edges : elementData.getAssociatedNodes()) {
                NodeData nodeData = graph.getOrDefault(edges, new NodeData());

                if (nodeData.getInDegree() > 0) {
                    nodeData.decrementInDegree();
                    if (nodeData.getInDegree() == 0) {
                        queue.add(edges);
                    }
                }
            }
        }
        return sortOrder;
    }

}
