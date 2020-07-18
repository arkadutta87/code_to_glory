package org.codechef.july_challenge;

import java.util.Scanner;

public class ChefCardGame {

  public static void main(String[] args) {

    int testCases = 0;

    Scanner scanner = new Scanner(System.in);
    testCases = scanner.nextInt();

    for (int i = 0; i < testCases; i++) {
      int plays = scanner.nextInt();

      int chefPoints = 0;
      int mortyPoints = 0;

      for (int j = 0; j < plays; j++) {
        int chefCard = scanner.nextInt();
        int mortyCard = scanner.nextInt();

        int pointChef = points(chefCard);
        int pointMonty = points(mortyCard);

        if (pointChef > pointMonty) {
          chefPoints += 1;
        }
        else if (pointChef < pointMonty) {
          mortyPoints += 1;
        }
        else {
          chefPoints += 1;
          mortyPoints += 1;
        }
      }

      if (chefPoints > mortyPoints) {
        System.out.println("0 " + chefPoints);
      }
      else if (chefPoints < mortyPoints) {
        System.out.println("1 " + mortyPoints);
      }
      else {
        System.out.println("2 " + chefPoints);
      }
    }

  }

  private static int points(int card) {
    int sum = 0;
    int divisor = 10;

    while (card > 0) {
      int modulo = card % divisor;
      card = card / divisor;
      sum += modulo;
    }

    return sum;
  }
}
