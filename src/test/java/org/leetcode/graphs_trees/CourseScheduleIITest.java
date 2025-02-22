package org.leetcode.graphs_trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CourseScheduleIITest {

    @Test
    void success_Case_1() {
        CourseScheduleII solution = new CourseScheduleII();
        int[][] grid = {
                {1,0}
        };

        assertArrayEquals(new int[]{0,1}, solution.findOrder(2, grid));
    }

    @Test
    void success_Case_2() {
        CourseScheduleII solution = new CourseScheduleII();
        int[][] grid = {
                {1,0},{2,0},{3,1},{3,2}
        };

        assertArrayEquals(new int[]{0,1,2,3}, solution.findOrder(4, grid));
    }

    @Test
    void success_Case_3() {
        CourseScheduleII solution = new CourseScheduleII();
        int[][] grid = {
        };

        assertArrayEquals(new int[]{0}, solution.findOrder(1, grid));
    }

    @Test
    void success_Case_4() {
        CourseScheduleII solution = new CourseScheduleII();
        int[][] grid = {
                {0,1},{1,0}
        };

        assertArrayEquals(new int[]{}, solution.findOrder(2, grid));
    }

}