package org.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationGeneratorV2 {

  public static void main(String[] args) {
    PermutationGeneratorV2 permutationGenerator = new PermutationGeneratorV2();
    int[] input = {1, 2, 3, 4, 5};
    permutationGenerator.permute(input);

  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> permutations = new ArrayList<>();
    int[] solution = new int[nums.length];

    generatePermutation(solution, -1, nums, permutations);
//    System.out.println("Number of permuations : " + permutations.size());
//    for (List<Integer> permutationInstance : permutations) {
//      System.out.println(permutationInstance);
//    }
    return permutations;
  }

  private void generatePermutation(int[] solution, int k, int[] input, List<List<Integer>> output) {
    if (isSolution(k, input)) {
      processSolution(solution, output);
    }
    else {
      List<Integer> candidates = generateCandidates(solution, k, input);
      k++;

      for (int cand : candidates) {
        solution[k] = cand;
        generatePermutation(solution, k, input, output);
      }
    }
  }

  private List<Integer> generateCandidates(int[] solution, int k, int[] input) {
    Set<Integer> itemsSelected = new HashSet<>();
    for (int i = 0; i <= k; i++) {
      itemsSelected.add(solution[i]);
    }
    List<Integer> candidates = new ArrayList<>();
    for (int a : input) {
      if (!itemsSelected.contains(a)) {
        candidates.add(a);
      }
    }

    return candidates;
  }

  private boolean isSolution(int k, int[] input) {
    return k == input.length - 1;
  }

  private void processSolution(int[] solution, List<List<Integer>> output) {
    List<Integer> permutationInstance = new ArrayList<>();
    for (int a : solution) {
      permutationInstance.add(a);
    }
    output.add(permutationInstance);
  }
}
