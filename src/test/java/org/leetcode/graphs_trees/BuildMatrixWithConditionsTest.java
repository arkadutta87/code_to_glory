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

    @Test
    void success_Case_3() {
        BuildMatrixWithConditions solution = new BuildMatrixWithConditions();
        assertArrayEquals(new int[][]{
                {0, 0, 0, 0, 0, 0, 7, 0},
                {0, 6, 0, 0, 0, 0, 0, 0},
                {0, 0, 5, 0, 0, 0, 0, 0},
                {0, 0, 0, 4, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 3, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 0}
        },
                solution.buildMatrix(8,
                new int[][]{
                        {1, 2},
                        {7, 3},
                        {4, 3},
                        {5, 8},
                        {7, 8},
                        {8, 2},
                        {5, 8},
                        {3, 2},
                        {1, 3},
                        {7, 6},
                        {4, 3},
                        {7, 4},
                        {4, 8},
                        {7, 3},
                        {7, 5}
                },
                new int[][]{
                        {5, 7},
                        {2, 7},
                        {4, 3},
                        {6, 7},
                        {4, 3},
                        {2, 3},
                        {6, 2}
                }));
    }

}