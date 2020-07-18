package org.codechef.july_challenge;

import java.util.Scanner;

public class ChefStrings {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    long testCases = scanner.nextLong();

    for (long i = 0; i < testCases; i++) {
      long numberMoves = scanner.nextLong();
      long skips = 0;

      if (numberMoves > 0) {
        long first = scanner.nextLong();
        for (long k = 1; k < numberMoves; k++) {
          long second = scanner.nextLong();
          skips += Math.abs(second - first) - 1;
          first = second;
        }
      }

      System.out.println(skips);
    }
  }
}
