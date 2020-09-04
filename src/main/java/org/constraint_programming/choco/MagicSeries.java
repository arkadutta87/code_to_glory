package org.constraint_programming.choco;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.BoolVar;
import org.chocosolver.solver.variables.IntVar;

public class MagicSeries {

  public static void main(String[] args) {
    int n = 7;
    IntVar[] x;

    Model model = new Model("Magic Series");
    int[] values = new int[n];
    for(int k = 0 ; k < n ; k++){
      values[k] = 1;
    }

    x = model.intVarArray("x" ,n , 0, n-1, false );

    //Defining the constraints
    for(int i = 0 ; i < n ; i++){
      BoolVar[] innerVariables = new BoolVar[n];
      for(int j = 0 ; j < n ; j++){
        innerVariables[j] = model.boolVar();

//        model.ifOnlyIf(model.arithm(x[j], "=", i), model.arithm(innerVariables[j], "=" , 1));
        model.arithm(x[j], "=", i).reifyWith(innerVariables[j]);
      }
      model.scalar(innerVariables, values, "=" , x[i]).post();
    }

    Solver solver = model.getSolver();

//    solver.showSolutions();
//    solver.findSolution();
//    solver.solve();
//    System.out.println(solver.findAllSolutions());

//    while (solver.solve()){
//      System.out.println("\n************************\n");
      System.out.println(solver.findSolution());

//      System.out.println("\n====================\n");
//      for(int k = 0 ; k <  n ; k++){
//        System.out.println("series[" + k + "] : "+ x[k]);
//      }
//    }

    System.out.println("Total Number of Solutions : "+ solver.getSolutionCount());
    solver.printStatistics();



  }
}
