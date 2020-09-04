package org.constraint_programming.choco;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.util.tools.ArrayUtils;

public class FeedEngineCardPositioning {

  public static void main(String[] args) {
    Model model = new Model("Card Positioning");

    int n = 10;
    int positions = 10;
    int floatingStart = 2 ;
    int floatingEnd = 5;

    /*
    TODO :
    C0 -> floating position -> 1
    C1 -> floating position -> 2
    C2 -> floating position => 3
    C3 -> floating position => 4
    C4 ->sequential
    C5 -> position -> 2
    C6 -> sequential
    C7 -> sequential
    C8 -> sequential
    C9 -> sequential
        1    2    3    4    5    6
    [  C0 , C5 , C1 , C3 , C2 , C4 ]
       1   2   3   4   5   6   7   8   9   10
    [ C0  C5  C1  C3  C2  C4  C6  C7  C8   C9 ]
    [ C0  C5  C1  C4  C2  C6  C3  C7  C8   C9 ] => correct =>

     */

    //cards[1,2,3 ,4,5, 6] => postion [1,2,3,4,5,6]

    //n 3 -. C1, C2 and C3
    //position[0] = C1; position[1] = C2; position[2] = C3;
    IntVar[] cards = model.intVarArray("cards", n, 1, positions, false);

    for(int i = floatingStart ; i <= floatingEnd ; i++){
      for (int j = i+1 ;  j <= floatingEnd ; j++){
        cards[i].sub(cards[j]).abs().gt(1).post();
      }
    }

    //constraint for position cards with priority
    cards[0].ge(2).post();
    cards[1].ge(4).post();



    int[] scalarMultiplier = ArrayUtils.array(1, n);
    model.allDifferent(cards).post();

    IntVar cost = model.intVar("cost", 1, 999999, false);
    model.scalar(cards, scalarMultiplier, "=", cost).post();
    model.setObjective(Model.MAXIMIZE, cost);

    Solver solver = model.getSolver();
    System.out.println(solver.findAllOptimalSolutions(cost, true));
    solver.printStatistics();

    /*
    TODO :
     positional cards;
     floating position cards(difference between each other has to be >= 2) => lets say C1 -> 2 C2 min pos -> 4 not 3 i.e Mod(pos[C[i]] -
     pos[C[j]]) > 1
     normal sequential cards;
     */

  }
}
