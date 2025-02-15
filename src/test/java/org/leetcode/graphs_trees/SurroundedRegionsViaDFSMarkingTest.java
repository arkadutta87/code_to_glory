package org.leetcode.graphs_trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurroundedRegionsViaDFSMarkingTest {

    @Test
    void surroundRegions_Success_Case_1() {

        SurroundedRegionsViaDFSMarking solution = new SurroundedRegionsViaDFSMarking();
        char[][] grid = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        char[][] expected = {
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        solution.solve(grid);
        assertArrayEquals(expected, grid);
    }

    @Test
    void surroundRegions_Success_Case_2() {

        SurroundedRegionsViaDFSMarking solution = new SurroundedRegionsViaDFSMarking();
        char[][] grid = {
                {'X'}
        };

        char[][] expected = {
                {'X'}
        };

        solution.solve(grid);
        assertArrayEquals(expected, grid);
    }

}