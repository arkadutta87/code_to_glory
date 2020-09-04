package org.codechef.august_challenge;

import java.util.Scanner;

public class DarthForces {

  public static void main(String[] args) throws java.lang.Exception{

    Scanner scanner = new Scanner(System.in);

    int testCases = scanner.nextInt();

    for(int i = 0 ; i < testCases ; i++){
      int darthHealth = scanner.nextInt();
      int saberPower = scanner.nextInt();

      int stepPowerZero = (int)( Math.log(saberPower) / Math.log(2) ) + 1;

      int darthHealthFinal = (int)(darthHealth - saberPower * (2 - (1/Math.pow(2, stepPowerZero))));

      if(darthHealthFinal <= 0 ){
        System.out.println(1);
      }else {
        System.out.println(0);
      }
    }
  }
}
