package org.leetcode.graphs_trees;

/*
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.



Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]



Example 2:

Input: board = [["X"]]

Output: [["X"]]
 */

public class SurroundedRegionsViaDFSMarking {

    public void solve(char[][] board) {

        var rowCount = board.length;
        var columnCount = board[0].length;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {


                var currentElement = board[i][j];

                if (currentElement == 'O') {
                    dfsMarking(i, j, board);
                }
            }
        }
    }

    private void dfsMarking(int i, int j, char[][] board) {
        var rowCount = board.length;
        var columnCount = board[0].length;


        if (i >= (rowCount - 1) || i <= 0 || j <= 0 || j >= (columnCount - 1) || board[i][j] == 'X') {
            return;
        }

        board[i][j] = 'X';

        dfsMarking(i, j + 1, board);
        dfsMarking(i, j - 1, board);
        dfsMarking(i + 1, j, board);
        dfsMarking(i - 1, j, board);
    }
}
