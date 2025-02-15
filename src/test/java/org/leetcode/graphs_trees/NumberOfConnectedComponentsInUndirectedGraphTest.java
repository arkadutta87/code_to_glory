package org.leetcode.graphs_trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfConnectedComponentsInUndirectedGraphTest {

    @Test
    void numOfProvinces_Success_Case_1() {

        NumberOfConnectedComponentsInUndirectedGraph solution = new NumberOfConnectedComponentsInUndirectedGraph();
        int[][] grid = {
                {0, 1},
                {1, 2},
                {3, 4}
        };

        assertEquals(2, solution.countComponents(5, grid));
    }

    @Test
    void numOfProvinces_Success_Case_2() {

        NumberOfConnectedComponentsInUndirectedGraph solution = new NumberOfConnectedComponentsInUndirectedGraph();
        int[][] grid = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4}
        };

        assertEquals(1, solution.countComponents(5, grid));
    }

}