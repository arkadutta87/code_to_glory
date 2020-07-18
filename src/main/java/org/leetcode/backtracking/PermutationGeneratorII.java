package org.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PermutationGeneratorII {

  public static void main(String[] args) {
    PermutationGeneratorII permutationGenerator = new PermutationGeneratorII();
    int[] input = {1, 1, 2 ,2};
    List<List<Integer>> permutations = permutationGenerator.permuteUnique(input);

    System.out.println("Number of permutations : " + permutations.size());

    for(List<Integer> aPermutation : permutations){
      System.out.println(aPermutation);
    }
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    Set<List<Integer>> permutations = new LinkedHashSet<>();
    int[] solutionToIndex = new int[nums.length];

    generatePermutation(solutionToIndex, -1, nums, permutations);

    List<List<Integer>> result = new ArrayList<>(permutations);
    return result;
  }

  private void generatePermutation(int[] solutionToIndex, int k, int[] input, Set<List<Integer>> output) {
    if (isSolution(k, input)) {
      processSolution(solutionToIndex, output, input);
    }
    else {
      List<Integer> candidatesIndexes = generateCandidates(solutionToIndex, k, input);
      k++;

      for (int cand : candidatesIndexes) {
        solutionToIndex[k] = cand;
        generatePermutation(solutionToIndex, k, input, output);
      }
    }
  }

  private List<Integer> generateCandidates(int[] solution, int k, int[] input) {
    Set<Integer> itemsSelected = new HashSet<>();
    for (int i = 0; i <= k; i++) {
      itemsSelected.add(solution[i]);
    }
    List<Integer> candidates = new ArrayList<>();
    for (int i = 0; i < input.length; i++) {
      if (!itemsSelected.contains(i + 1)) {
        candidates.add(i + 1);
      }
    }

    return candidates;
  }

  private boolean isSolution(int k, int[] input) {
    return k == input.length - 1;
  }

  private void processSolution(int[] solution, Set<List<Integer>> output, int[] input) {
    List<Integer> permutationInstance = new ArrayList<>();
    for (int index : solution) {
      permutationInstance.add(input[index - 1]);
    }
    output.add(permutationInstance);
  }
}
