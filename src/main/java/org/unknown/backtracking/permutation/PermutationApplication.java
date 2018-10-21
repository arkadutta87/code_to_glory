package org.unknown.backtracking.permutation;

import java.util.Scanner;

public class PermutationApplication {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    System.out.println("Kindly enter the number of elements of the set for which you need to print permutations");

    int elements = scan.nextInt();

    String[] set = new String[elements];

    for (int i = 0; i < set.length; i++) {
      set[i] = scan.next();
    }

    System.out.println("The Permutations will be printed below  -----> ");

    PermutationEngine permutationEngine = new PermutationEngine();
    permutationEngine.generatePermutations(set);

  }
}
