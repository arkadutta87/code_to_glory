package org.leetcode.graphs_trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EarliestMomentWhenEveryoneBecomesFriendsTest {

    @Test
    void success_Case_1() {
        EarliestMomentWhenEveryoneBecomesFriends solution = new EarliestMomentWhenEveryoneBecomesFriends();
        int[][] grid = {
                {20190101, 0, 1},
                {20190104, 3, 4},
                {20190107, 2, 3},
                {20190211, 1, 5},
                {20190224, 2, 4},
                {20190301, 0, 3},
                {20190312, 1, 2},
                {20190322, 4, 5}
        };

        assertEquals(20190301, solution.earliestAcq(grid, 6));
    }


    @Test
    void success_Case_2() {
        EarliestMomentWhenEveryoneBecomesFriends solution = new EarliestMomentWhenEveryoneBecomesFriends();
        int[][] grid = {
                {0,2,0},{1,0,1},{3,0,3},{4,1,2},{7,3,1}
        };

        assertEquals(3, solution.earliestAcq(grid, 4));
    }
}