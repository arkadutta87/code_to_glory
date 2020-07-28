package org.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSetGeneratorII {

  public static void main(String[] args) {
    SubSetGeneratorII subSetGenerator = new SubSetGeneratorII();
    List<List<Integer>> subsets = subSetGenerator.subsetsWithDup(new int[]{1, 2, 2});

    for(List<Integer> subSet : subsets){
      System.out.println(subSet);
    }
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Set<List<Integer>> superSet = new HashSet<>();
    boolean[] solution = new boolean[nums.length];

    generateSuperSet(solution, -1, nums, superSet);
    return new ArrayList<>(superSet);
  }

  private void generateSuperSet(boolean[] solution, int index, int[] input, Set<List<Integer>> output) {
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

  private void processSolution(boolean[] solution, int[] input, Set<List<Integer>> output) {

    List<Integer> combination = new ArrayList<>();
    for (int i = 0; i < solution.length; i++) {
      if (solution[i]) {
        combination.add(input[i]);
      }
    }

    output.add(combination);
  }
}
