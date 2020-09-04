package org.codechef.august_challenge;

import java.util.Scanner;

public class ChefLinearChess {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int testCases = scanner.nextInt();

    for(int i= 0; i < testCases ; i ++){
      int playersNumber = scanner.nextInt();
      int chefPosition = scanner.nextInt();

      int playerWinPosition = -1;
      int max = Integer.MAX_VALUE;

      for(int k = 0 ; k < playersNumber ; k++){
        int position = scanner.nextInt();

        if(position <= chefPosition ){
          if(chefPosition % position == 0 ){
            int steps = chefPosition / position;

            if(steps < max){
              max = steps;
              playerWinPosition = position;
            }
          }
        }
      }

      System.out.println(playerWinPosition);
    }
  }
}
