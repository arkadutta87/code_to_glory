package org.constraint_programming.choco;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

public class ChefAndWeddingArrangements {

  public static void main(String[] args) {

    Model model = new Model("Chef and Wedding Arrangements");
    int numberGuests = 5;

    int[] guests = new int[]{5, 1, 3, 3, 3};

    IntVar[] boundaries = model.intVarArray("boundaries", numberGuests, 0, 5, false);

    //Constraint 1
    boundaries[0].gt(0).post();
    for (int i = 0; i < numberGuests; i++) {
      for (int j = i + 1; j < numberGuests; j++) {
        model.or(boundaries[j].eq(0).boolVar(), boundaries[j].gt(boundaries[i]).boolVar()).post();
      }
    }

    IntVar[] conflicts = new IntVar[numberGuests];

//    for (int i = 0; i < numberGuests ; i++){
//      int boundaryVal = model.distance()
//
//      for()
//    }


  }
}
