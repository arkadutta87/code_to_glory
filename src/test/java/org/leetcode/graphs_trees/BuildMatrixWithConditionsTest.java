package org.leetcode.graphs_trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildMatrixWithConditionsTest {

    @Test
    void success_Case_1() {
        BuildMatrixWithConditions solution = new BuildMatrixWithConditions();
        assertArrayEquals(new int[][]{{0,0,1},{3,0,0},{0,2,0}}, solution.buildMatrix(3,
                new int[][]{{1, 2}, {3, 2}},
                new int[][]{{2, 1}, {3, 2}}));
    }


    @Test
    void success_Case_2() {
        BuildMatrixWithConditions solution = new BuildMatrixWithConditions();
        assertArrayEquals(new int[][]{}, solution.buildMatrix(3,
                new int[][]{{1, 2}, {2, 3}, {3, 1}, {2, 3}},
                new int[][]{{2, 1}}));
    }
}