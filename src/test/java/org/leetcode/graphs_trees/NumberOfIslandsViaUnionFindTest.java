package org.leetcode.graphs_trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfIslandsViaUnionFindTest {

    @Test
    void numIslands_Success_Case_1() {

        NumberOfIslandsViaUnionFind solution = new NumberOfIslandsViaUnionFind();
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

        NumberOfIslandsViaUnionFind solution = new NumberOfIslandsViaUnionFind();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        assertEquals(3, solution.numIslands(grid));
    }
}
