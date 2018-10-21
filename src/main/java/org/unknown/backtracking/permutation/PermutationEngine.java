package org.unknown.backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

import javax.jnlp.IntegrationService;

public class PermutationEngine {

  public void generatePermutations(String[] array) {

    int[] probableSolution = new int[array.length];
    producePermutation(probableSolution, 0, array);
  }

  private void producePermutation(int[] solution, int k, String[] array) {
    if (isASolution(solution, k, array)) {
      printTheSolution(solution, array);
    }
    else {
      int[] candidates = generateCandidates(solution, k, array);
      for (int i = 0; i < candidates.length; i++) {
        solution[k] = candidates[i];
        producePermutation(solution, k + 1, array);
      }
    }
  }

  private int[] generateCandidates(int[] solution, int k, String[] array) {
    List<Integer> candidates = new ArrayList<>();

    int vector = 0;
    for(int i = 0 ; i < k ; i ++){
      vector |= (1 << solution[i]);
    }

    for (int i = 0; i < array.length; i++) {
      if ((vector & (1 << i)) == 0) {
        candidates.add(i);
      }
    }

    int[] cands = new int[candidates.size()];
    for (int i = 0; i < candidates.size(); i++) {
      cands[i] = candidates.get(i);
    }
    return cands;
  }

  private boolean isASolution(int[] solution, int k, String[] array) {
    return k == array.length;
  }

  private void printTheSolution(int[] solution, String[] array) {
    System.out.print("{");

    for (int index : solution) {
      System.out.print(" " + array[index] + " ");
    }

    System.out.println("}");
  }


}
