package org.leetcode.dynamic_programming;

import java.util.*;

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> rewardMap = new HashMap<>();

        for (int num : nums) {
            rewardMap.put(num, rewardMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> uniqueNumbers = new ArrayList<>(rewardMap.keySet());
        Collections.sort(uniqueNumbers);
        return recursiveDeleteAndEarn(uniqueNumbers.size() - 1, uniqueNumbers, new HashMap<Integer, Integer>(), rewardMap);
    }

    private int recursiveDeleteAndEarn(int currentIndex, List<Integer> uniqueNumbers, Map<Integer, Integer> memoizationMap,
                                       Map<Integer, Integer> rewardMap) {
        if (currentIndex < 0) {
            return 0;
        }

        if (currentIndex == 0) {
            int num = uniqueNumbers.get(0);
            return rewardMap.get(num) * num;
        }

        if (memoizationMap.containsKey(currentIndex)) {
            return memoizationMap.get(currentIndex);
        }

        int currentElement = uniqueNumbers.get(currentIndex);
        int nextLowerElement = uniqueNumbers.get(currentIndex - 1);

        if(currentElement - nextLowerElement == 1){
            memoizationMap.put(currentIndex, Math.max(recursiveDeleteAndEarn(currentIndex - 2, uniqueNumbers,
                            memoizationMap, rewardMap) + currentElement * rewardMap.get(uniqueNumbers.get(currentIndex)),
                    recursiveDeleteAndEarn(currentIndex - 1, uniqueNumbers, memoizationMap, rewardMap)));
        }else{
            memoizationMap.put(currentIndex, recursiveDeleteAndEarn(currentIndex - 1, uniqueNumbers, memoizationMap, rewardMap)
                    + currentElement * rewardMap.get(uniqueNumbers.get(currentIndex)));
        }

        return memoizationMap.get(currentIndex);
    }

    public static void main(String[] args) {

        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        System.out.println(deleteAndEarn.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(deleteAndEarn.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println(deleteAndEarn.deleteAndEarn(new int[]{8, 3, 4, 7, 6, 6, 9, 2, 5, 8, 2, 4, 9, 5, 9, 1, 5, 7, 1, 4}));
        System.out.println(deleteAndEarn.deleteAndEarn(new int[]{1, 8, 5, 9, 6, 9, 4, 1, 7, 3, 3, 6, 3, 3, 8, 2, 6, 3, 2, 2, 1, 2, 9, 8, 7, 1, 1, 10, 6, 7, 3, 9, 6, 10, 5, 4, 10, 1, 6, 7, 4, 7, 4, 1, 9, 5, 1, 5, 7, 5}));
        System.out.println(deleteAndEarn.deleteAndEarn(new int[]{8, 6, 1, 7, 5, 8, 9, 5, 1, 1, 7, 3, 5, 8, 5, 2, 9, 6, 9, 10, 10, 10, 4, 4, 8, 8, 4, 3, 6, 7, 4, 5, 1, 7, 1, 5, 1, 6, 7, 9, 6, 4, 8, 7, 9, 7, 8, 2, 9, 5}));
    }
}
