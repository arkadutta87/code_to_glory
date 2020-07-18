package org.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSetGenerator {

  public static void main(String[] args) {
    SubSetGenerator subSetGenerator = new SubSetGenerator();
    List<List<Integer>> subsets = subSetGenerator.subsets(new int[]{2, 4, 8, 16});

    System.out.println("Number of subsets : "+ subsets.size());
//    for (List<Integer> subSet : subsets) {
//      System.out.println(subSet);
//    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> superSet = new ArrayList<>();
    boolean[] solution = new boolean[nums.length];

    generateSuperSet(solution, -1, nums, superSet);
    return superSet;
  }

  private void generateSuperSet(boolean[] solution, int index, int[] input, List<List<Integer>> output) {
    if (isSolution(index, input)) {
      processSolution(solution, input, output);
    }
    else {
      boolean[] candidates = generateCandidates();
      index++;

      for (int i = 0; i < candidates.length; i++) {
        solution[index] = candidates[i];
        generateSuperSet(solution, index, input, output);
      }
    }
  }

  private boolean[] generateCandidates() {
    return new boolean[]{false, true};
  }

  private boolean isSolution(int index, int[] input) {
    return index == input.length - 1;
  }

  private void processSolution(boolean[] solution, int[] input, List<List<Integer>> output) {

    List<Integer> combination = new ArrayList<>();
    for (int i = 0; i < solution.length; i++) {
      if (solution[i]) {
        combination.add(input[i]);
      }
    }

    output.add(combination);
  }
}
