package org.leetcode.graphs_trees;

public class NumberOfIslandsViaDFSMarking {

    public int numIslands(char[][] grid) {
        var rowCount = grid.length;
        var columnCount = grid[0].length;

        var numberOfIslands = 0;

        for (var i = 0; i < rowCount; i++) {
            for (var j = 0; j < columnCount; j++) {
                var currentElement = grid[i][j];

                if (currentElement == '1') {
                    dfsMarking(i, j, grid);
                    numberOfIslands += 1;
                }
            }
        }

        return numberOfIslands;
    }

    private void dfsMarking(int i, int j, char[][] grid) {
        var rowCount = grid.length;
        var columnCount = grid[0].length;

        if (i >= rowCount || j >= columnCount || i < 0 || j < 0 || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        dfsMarking(i + 1, j, grid);
        dfsMarking(i, j + 1, grid);
        dfsMarking(i - 1, j, grid);
        dfsMarking(i, j - 1, grid);
    }
}
