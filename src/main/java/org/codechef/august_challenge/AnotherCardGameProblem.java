package org.codechef.august_challenge;

import java.util.Scanner;

public class AnotherCardGameProblem {

  public static void main(String[] args) throws java.lang.Exception {
    Scanner scanner = new Scanner(System.in);

    int testCases = scanner.nextInt();

    for (int i = 0; i < testCases; i++) {
      int finalPowerChef = scanner.nextInt();
      int finalPowerRick = scanner.nextInt();

      int chefInteger = digitsFinalPower(finalPowerChef);
      int rickInteger = digitsFinalPower(finalPowerRick);

      if (chefInteger < rickInteger) {
        System.out.println(0 + " " + chefInteger);
      }
      else {
        System.out.println(1 + " " + rickInteger);
      }
    }
  }

  private static int digitsFinalPower(int power) {
    int digits = 0;
    digits += power / 9;

    if (power % 9 != 0) {
      digits += 1;
    }

    return digits;
  }
}
