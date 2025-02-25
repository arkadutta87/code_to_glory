package org.leetcode.graphs_trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParallelCoursesTest {

    @Test
    void success_Case_1() {
        ParallelCourses solution = new ParallelCourses();
        assertEquals(2, solution.minimumSemesters(3,
                new int[][]{{1,3},{2,3}}));
    }

    @Test
    void success_Case_2() {
        ParallelCourses solution = new ParallelCourses();
        assertEquals(-1, solution.minimumSemesters(3,
                new int[][]{{1,2},{2,3},{3,1}}));
    }

    @Test
    void success_Case_3() {
        ParallelCourses solution = new ParallelCourses();
        assertEquals(4, solution.minimumSemesters(5,
                new int[][]{{1,2},{3,4},{4,5},{5,2}}));
    }
}