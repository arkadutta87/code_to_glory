package org.constraint_programming.choco;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class FeedEngineCardPositioningV2 {

  public static void main(String[] args) {
    Model model = new Model("FE Card Position V2");

    int positions = 10;

    /*
    C0 => gap
    C1 => gap
    C2 => gap
    C3 => sequential
    C4 => sequential
    C5 => seq
    C6 => seq
    C7 => seq
    C8 => 3 => hard => gap card
    C9 => 3 => preferred
     */
    // 1   2    3   4   5   6   7   8   9    10
    //C0, C9 , C8 , C7, C6, C1, C3, C2 , C4, C5

    // C3 ,C9 ,C8 , C4 , C0 , C5 , C1 , C6 , C2 ,C7
    int startFloating = 0;//gap cards
    int endFloating = 2;

    int startPosition = endFloating + 1;
    int endPosition = 7;


    IntVar[] cards = model.intVarArray("cards", positions,  1, positions , false );

    //Constraint - 1
    model.allDifferent(cards).post();

    //Constraint -2
    for(int k = startPosition ; k <= endPosition ; k++){
      for (int i = k+1; i <= endPosition ; i++){
        cards[k].lt(cards[i]).post();
      }
    }

    //Constraint - 3
    for(int k = startFloating ; k <= endFloating ; k++){
      for (int i = k+1; i <= endFloating ; i++){
        cards[k].lt(cards[i]).post();
      }
    }

    //Constraint - 4
    for(int i = startFloating ; i <= endFloating ; i++){
      for(int k = i+1 ; k <= endFloating ; k++){
        cards[i].sub(cards[k]).abs().gt(1).post();
      }
    }

    //Constraint - 5
//    cards[9].gt(cards[8]).post();//make this eq for hard constraint. => this gurantees the positioning\
    int position1 = 3;
    int position2 = 5;


    IntVar[] distanceDecisionVaribles = new IntVar[1];

    cards[8].eq(position1).post();
//    cards[9].ge(position1).post();
    distanceDecisionVaribles[0] = cards[9].sub(position1).abs().intVar();

//    cards[6].eq(position2).post();
//    distanceDecisionVaribles[0] = cards[7].sub(position2).abs().intVar();

    //Non Sequential gap card
    int positionalGapCard = 8;
    for(int i = startFloating ; i <= endFloating ; i++){
      cards[positionalGapCard].sub(cards[i]).abs().gt(1).post();
    }


    Solver solver = model.getSolver();
    Solution lexOptimalSolution = solver.findLexOptimalSolution(distanceDecisionVaribles, false);


    System.out.println(lexOptimalSolution);
    for(int m = 0; m < positions ; m++){
      System.out.println("Cards["+ m + "]:"+lexOptimalSolution.getIntVal(cards[m]));
    }

//    solver.printStatistics();



  }
}
