package org.leetcode.graphs_trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphValidTreeTest {

    @Test
    void numOfProvinces_Success_Case_1() {

        GraphValidTree solution = new GraphValidTree();
        int[][] grid = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 4}
        };

        assertTrue(solution.validTree(5, grid));
    }

    @Test
    void numOfProvinces_Success_Case_2() {

        GraphValidTree solution = new GraphValidTree();
        int[][] grid = {
                {0, 1},
                {1, 2},
                {2, 3},
                {1, 3},
                {1, 4}
        };

        assertFalse(solution.validTree(5, grid));
    }

}