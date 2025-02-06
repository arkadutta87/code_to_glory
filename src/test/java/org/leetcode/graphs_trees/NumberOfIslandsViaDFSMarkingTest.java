package org.leetcode.graphs_trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfIslandsViaDFSMarkingTest {

    @Test
    void numIslands_Success_Case_1() {

        NumberOfIslandsViaDFSMarking solution = new NumberOfIslandsViaDFSMarking();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    void numIslands_Success_Case_2() {

        NumberOfIslandsViaDFSMarking solution = new NumberOfIslandsViaDFSMarking();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        assertEquals(3, solution.numIslands(grid));
    }
}