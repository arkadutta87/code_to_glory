package org.leetcode.dynamic_programming;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DeleteAndEarnTest {

    @Test
    public void testPositiveCase() {
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();

        Assertions.assertEquals(deleteAndEarn.deleteAndEarn(new int[]{3, 4, 2}), 6);
        Assertions.assertEquals(deleteAndEarn.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}), 9);
        Assertions.assertEquals(deleteAndEarn.deleteAndEarn(new int[]{8, 3, 4, 7, 6, 6, 9, 2, 5, 8, 2, 4, 9, 5, 9, 1, 5, 7, 1, 4}), 61);
        Assertions.assertEquals(deleteAndEarn.deleteAndEarn(new int[]{1, 8, 5, 9, 6, 9, 4, 1, 7, 3, 3, 6, 3, 3, 8, 2, 6, 3, 2, 2, 1, 2, 9, 8, 7, 1, 1, 10, 6, 7, 3, 9, 6, 10, 5, 4, 10, 1, 6, 7, 4, 7, 4, 1, 9, 5, 1, 5, 7, 5}), 138);
        Assertions.assertEquals(deleteAndEarn.deleteAndEarn(new int[]{8, 6, 1, 7, 5, 8, 9, 5, 1, 1, 7, 3, 5, 8, 5, 2, 9, 6, 9, 10, 10, 10, 4, 4, 8, 8, 4, 3, 6, 7, 4, 5, 1, 7, 1, 5, 1, 6, 7, 9, 6, 4, 8, 7, 9, 7, 8, 2, 9, 5}), 150);
    }
}
