package org.leetcode.graphs_trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPathExistsInGraphTest {

    @Test
    void success_Case_1() {

        FindPathExistsInGraph solution = new FindPathExistsInGraph();
        int[][] grid = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 4}
        };

        assertTrue(solution.validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
    }

    @Test
    void success_Case_2() {

        FindPathExistsInGraph solution = new FindPathExistsInGraph();
        int[][] grid = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 4}
        };

        assertFalse(solution.validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
    }

}