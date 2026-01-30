package org.leetcode.dynamic_programming;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class HouseRobberTest {

    @Test
    public void testPositiveCase() {
        HouseRobber robber = new HouseRobber();

        Assertions.assertEquals(robber.rob(new int[]{1, 2, 3, 1}),  4);
        Assertions.assertEquals(robber.rob(new int[]{2, 7, 9, 3, 1}), 12);
    }
}
