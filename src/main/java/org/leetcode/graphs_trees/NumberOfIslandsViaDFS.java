package org.leetcode.graphs_trees;

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


import javafx.util.Pair;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;

public class NumberOfIslandsViaDFS {

    private static final char ONE = '1';

    private Stack<Pair<Integer, Integer>> traverseStack;
    private Set<Set<Pair<Integer, Integer>>> islands;

    public int numIslands(char[][] grid) {

        traverseStack = new Stack<>();
        islands = new HashSet<>();

        final var numRows = grid.length;
        final var numCols = grid[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                final var element = grid[i][j];
                final var currentCell = new Pair<>(i, j);

                if (element == ONE && islands.stream().noneMatch(set -> set.contains(currentCell))) {
                    traverseStack.add(currentCell);
                    DFS(grid);
                }
            }
        }


        return islands.size();
    }

    private void DFS(char[][] grid) {
        while (!traverseStack.isEmpty()) {
            final var startElement = traverseStack.pop();

            Optional<Set<Pair<Integer, Integer>>> islandCurrentOptional = islands.stream().filter(island -> island.contains(startElement))
                    .findFirst();

            Set<Pair<Integer, Integer>> island = new HashSet<>();
            if (islandCurrentOptional.isEmpty()) {
                island.add(startElement);
                islands.add(island);

            } else {
                island = islandCurrentOptional.get();
            }

            Set<Pair<Integer, Integer>> validPairs = generateValidBlocks(grid, startElement, island);
            for (Pair<Integer, Integer> aPair : validPairs) {
                island.add(aPair);
                traverseStack.add(aPair);
            }
        }
    }


    private Set<Pair<Integer, Integer>> generateValidBlocks(char[][] grid,
                                                            Pair<Integer, Integer> currentElement,
                                                            Set<Pair<Integer, Integer>> currentIsland) {
        HashSet<Pair<Integer, Integer>> pairs = new HashSet<>();

        int rows = grid.length;
        int columns = grid[0].length;

        int row = currentElement.getKey();
        int column = currentElement.getValue();

        //generate left - check validity
        int leftRow = row;
        int leftColumn = column - 1;
        Pair<Integer, Integer> leftBlock = new Pair<>(leftRow, leftColumn);

        if (leftColumn >= 0 && isValid(leftRow, leftColumn, leftBlock, currentIsland, grid)) {
            pairs.add(leftBlock);
        }

        //generate right - check validity
        int rightRow = row;
        int rightColumn = column + 1;
        Pair<Integer, Integer> rightBlock = new Pair<>(rightRow, rightColumn);

        if (rightColumn <= columns - 1 && isValid(rightRow, rightColumn, rightBlock, currentIsland, grid)) {
            pairs.add(rightBlock);
        }

        //generate up - check validity
        int upRow = row - 1;
        int upColumn = column;
        Pair<Integer, Integer> upBlock = new Pair<>(upRow, upColumn);

        if (upRow >= 0 && isValid(upRow, upColumn, upBlock, currentIsland, grid)) {
            pairs.add(upBlock);
        }


        //generate down - check validity
        int downRow = row + 1;
        int downColumn = column;
        Pair<Integer, Integer> downBlock = new Pair<>(downRow, downColumn);

        if (downRow <= rows - 1 && isValid(downRow, downColumn, downBlock, currentIsland, grid)) {
            pairs.add(downBlock);
        }

        return pairs;
    }

    private static boolean isValid(int newRow, int newColumn, Pair<Integer, Integer> leftBlock,
                                   Set<Pair<Integer, Integer>> currentIsland, char[][] grid) {
        return grid[newRow][newColumn] == ONE && !currentIsland.contains(leftBlock);
    }
}
