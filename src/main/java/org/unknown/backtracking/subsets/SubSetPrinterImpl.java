package org.unknown.backtracking.subsets;

public class SubSetPrinterImpl implements SubSetPrinter {

  public void printSubsets(String[] data) {
    boolean[] subSetInstance = new boolean[data.length];

    generateSubSets(subSetInstance, 0, data);
  }

  private void generateSubSets(boolean[] subSetArray, int k, String[] data) {
    if (isArrayASolution(subSetArray, k, data)) {
      processSubset(subSetArray, data);
    }
    else {
      boolean[] possibleSolutions = generatePossibleSolutions(subSetArray, k, data);
      for (boolean aBool : possibleSolutions) {
        subSetArray[k] = aBool;
        generateSubSets(subSetArray, k + 1, data);
      }
    }
  }

  private boolean isArrayASolution(boolean[] subSetArray, int k, String[] data) {
    return k == data.length;
  }

  private void processSubset(boolean[] subSetArray, String[] data) {

    System.out.print("{");
    for (int i = 0; i < subSetArray.length; i++) {
      if (subSetArray[i]) {
        System.out.print(" " + data[i] + " ");
      }
    }
    System.out.println("}");
  }

  private boolean[] generatePossibleSolutions(boolean[] subSetArray, int k, String[] data) {
    boolean[] possibleSolutions = new boolean[2];
    possibleSolutions[0] = true;
    possibleSolutions[1] = false;

    return possibleSolutions;
  }
}
