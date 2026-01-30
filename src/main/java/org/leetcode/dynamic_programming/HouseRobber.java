package org.leetcode.dynamic_programming;

import java.util.HashMap;

public class HouseRobber {

    public int rob(int[] nums) {
        HashMap<Integer, Integer> memoization = new HashMap<>();
        return maximiseRobbery(nums, -1, memoization);
    }

    private int maximiseRobbery(int[] nums, int currentHouse, HashMap<Integer, Integer> memoization) {

        if (currentHouse >= nums.length) {
            return 0;
        }

        if (memoization.containsKey(currentHouse)) {
            return memoization.get(currentHouse);
        }

        int houseIndex1, houseIndex2 = 0;

        if (currentHouse == -1) {
            houseIndex1 = 0;
            houseIndex2 = 1;
        } else {
            houseIndex1 = currentHouse + 2;
            houseIndex2 = currentHouse + 3;
        }

        memoization.put(currentHouse, (currentHouse == -1 ? 0 : nums[currentHouse]) +
                Math.max(maximiseRobbery(nums, houseIndex1, memoization), maximiseRobbery(nums, houseIndex2, memoization)));

        return memoization.get(currentHouse);
    }

    public static void main(String[] args) {
        HouseRobber robber = new HouseRobber();
        System.out.println(robber.rob(new int[]{1, 2, 3, 1}));
        System.out.println(robber.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
