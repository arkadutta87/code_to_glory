package org.leetcode.graphs_trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfProvincesTest {

    @Test
    void numOfProvinces_Success_Case_1() {

        NumberOfProvinces solution = new NumberOfProvinces();
        int[][] grid = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1},
        };

        assertEquals(2, solution.findCircleNum(grid));
    }

    @Test
    void numOfProvinces_Success_Case_2() {

        NumberOfProvinces solution = new NumberOfProvinces();
        int[][] grid = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
        };

        assertEquals(3, solution.findCircleNum(grid));
    }
}
