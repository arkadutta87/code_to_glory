package org.leetcode.graphs_trees;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/*
Given an m x n 2D binary grid, which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1



Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/

public class NumberOfIslandsViaUnionFind {

    public static final char ZERO = '0';
    public static final char ONE = '1';

    private static class SymmetricPair<K, V> extends Pair<K, V> {

        public SymmetricPair(K k, V v) {
            super(k, v);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SymmetricPair<?, ?> pair = (SymmetricPair<?, ?>) o;
            // Check if (first, second) equals (second, first)
            return (Objects.equals(getKey(), pair.getKey()) && Objects.equals(getValue(), pair.getValue())) ||
                    (Objects.equals(getKey(), pair.getValue()) && Objects.equals(getValue(), pair.getKey()));
        }

        @Override
        public int hashCode() {
            // Order-independent hash code: a + b will be the same as b + a
            return Objects.hash(getKey()) + Objects.hash(getValue());
        }
    }

    private Set<SymmetricPair<Integer, Integer>> pairs;
    private int[] vertexArray;

    public int numIslands(char[][] grid) {
        var rowCount = grid.length;
        var columnCount = grid[0].length;

        pairs = new HashSet<>();
        vertexArray = new int[rowCount * columnCount];

        generateConnectedPairs(grid, rowCount, columnCount);

        //Implement the union find algorithm to find pairs.
        //create the connected components
        for (var pair : pairs) {
            union(pair.getKey(), pair.getValue());
        }


        Set<Integer> connectedComponentsVertexes = new HashSet<>();
        for (int element : vertexArray) {
            if (element >= 0) {
                int vertex = findVertex(element);
                connectedComponentsVertexes.add(vertex);
            }
        }
        return connectedComponentsVertexes.size();
    }

    private void union(int elementA, int elementB) {
        final var vertexA = findVertex(elementA);
        final var vertexB = findVertex(elementB);

        if (vertexA != vertexB) {
            vertexArray[vertexB] = vertexA;
        }
    }

    private int findVertex(int element) {
        var intermediateVertex = vertexArray[element];
        if (intermediateVertex == element || intermediateVertex == -1) {
            return intermediateVertex;
        } else {
            return findVertex(intermediateVertex);
        }
    }

    private void generateConnectedPairs(char[][] grid, int rowCount, int columnCount) {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                final var currentElement = grid[i][j];
                final var index = i * columnCount + j;

                if (currentElement == ZERO) {
                    vertexArray[index] = -1;
                    continue;
                }

                vertexArray[index] = index;
                //go right
                if (j < columnCount - 1) {
                    final var newCol = j + 1;

                    if (grid[i][newCol] == ONE) {
                        final var rightElementIndex = i * columnCount + newCol;
                        pairs.add(new SymmetricPair<>(index, rightElementIndex));
                    }
                }

                //go down
                if (i < rowCount - 1) {
                    final var newRow = i + 1;

                    if (grid[newRow][j] == '1') {
                        final var downElementIndex = newRow * columnCount + j;
                        pairs.add(new SymmetricPair<>(index, downElementIndex));
                    }
                }
            }
        }
    }
}
