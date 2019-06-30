package org.dynamic_programming;

import java.util.Arrays;
import java.util.List;

public class GridToInfiniteStepsOptimal {

  public static void main(String[] args) {

    List<Integer> A = Arrays.asList(-7, -13);
    List<Integer> B = Arrays.asList(1, -5);

    GridToInfiniteStepsRecursiveApproach pathFinder = new GridToInfiniteStepsRecursiveApproach();
    System.out.println(pathFinder.coverPoints(A, B));
  }


  public int coverPoints(List<Integer> A, List<Integer> B) {
    int steps = 0;

    for(int i = 0 ; i < A.size() -1; i++){
      steps += Math.max(Math.abs(A.get(i) - A.get(i+1)), Math.abs(B.get(i) - B.get(i+1)));
    }

    return steps;
  }


}
