package org.unknown.backtracking.subsets;

import java.util.Scanner;

public class SubSetApplication {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    System.out.println("Kindly enter the number of elements of the set for which you need to print sub-sets");

    int elements = scan.nextInt();

    String[] set = new String[elements];

    for (int i = 0; i < set.length; i++) {
      set[i] = scan.next();
    }

    System.out.println("The Subset will be printed below  -----> ");

    SubSetPrinter subSetPrinter = new SubSetPrinterImpl();
    subSetPrinter.printSubsets(set);

  }
}
