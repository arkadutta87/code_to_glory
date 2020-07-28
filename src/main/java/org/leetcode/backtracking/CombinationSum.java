package org.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

  public static void main(String[] args) {
    CombinationSum combinationSum = new CombinationSum();
    List<List<Integer>> combinations = combinationSum.combinationSum(new int[]{2, 3, 5}, 8);

    for (List<Integer> combination : combinations) {
      System.out.println(combination);
    }
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> combinations = new ArrayList<>();

    List<Integer> solution = new ArrayList<>();
    Arrays.sort(candidates);

    generateCombinations(solution, -1, candidates, target, combinations);

    return combinations;
  }

  private void generateCombinations(List<Integer> solution, int currentIndex, int[] candidates, int target, List<List<Integer>> output) {
    int sum = getSum(solution, currentIndex);

    if (isPartSolutionValid(solution, currentIndex, candidates, target, sum)) {
      if (isSolution(sum, target)) {
        processSolution(solution, currentIndex, output);
      }
      else {
        int lastValue = currentIndex < 0 ? -1 : solution.get(currentIndex);
        List<Integer> possibleCandidates = generateCandidates(sum, lastValue, candidates, target);
        currentIndex++;
        for (int aCandidate : possibleCandidates) {
          solution.add(currentIndex, aCandidate);
          generateCombinations(solution, currentIndex, candidates, target, output);
        }
      }
    }
  }

  private List<Integer> generateCandidates(int sum, int lastValue, int[] candidates, int target) {
    List<Integer> possibleCandidates = new ArrayList<>();

    int diff = target - sum;
    int lastValueIndex = 0;

    if (lastValue > 0) {
      lastValueIndex = Arrays.binarySearch(candidates, lastValue);
    }

    for (int i = lastValueIndex; i < candidates.length; i++) {
      if (candidates[i] <= diff) {
        possibleCandidates.add(candidates[i]);
      }
    }

    return possibleCandidates;
  }

  private boolean isSolution(int sum, int target) {
    return sum == target;
  }

  private void processSolution(List<Integer> solution, int currentIndex, List<List<Integer>> output) {
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i <= currentIndex; i++) {
      result.add(solution.get(i));
    }

    output.add(result);
  }

  private boolean isPartSolutionValid(List<Integer> solution, int currentIndex, int[] candidates, int target, int sum) {
    if (currentIndex < 0) {
      return true;
    }

    int latestValue = solution.get(currentIndex);

    if (sum < target) {
      int diff = target - sum;

      if (diff < latestValue) {
        return false;
      }
    }

    return true;
  }

  private int getSum(List<Integer> solution, int currentIndex) {
    int sum = 0;
    for (int i = 0; i <= currentIndex; i++) {
      sum += solution.get(i);
    }
    return sum;
  }
}
