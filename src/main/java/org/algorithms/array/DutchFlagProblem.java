package org.algorithms.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DutchFlagProblem {

  public static void main(String[] args) {
    List<COLOR> colors = Arrays.asList(new COLOR[]{COLOR.WHITE, COLOR.BLUE, COLOR.WHITE, COLOR.RED, COLOR.RED, COLOR.BLUE, COLOR.RED});
    DutchFlagProblem solver = new DutchFlagProblem();
    solver.arrangeInOrderOfEnum(colors, 3);

    for(COLOR aColor : colors){
      System.out.print(aColor.name() + " ");
    }

  }

  private void arrangeInOrderOfEnum(List<COLOR> list , int pivotIndex){
    /*
     Break the array into four parts in the following order
     smaller elements, same elements , unassociated, greater elements
      */

    int smaller = 0  , equal= 0;
    int larger = list.size()  ;

    COLOR pivotElement = list.get(pivotIndex);
    while(equal < larger){
      COLOR element = list.get(equal);
      if(element.ordinal() < pivotElement.ordinal()){
        Collections.swap(list,smaller++, equal++ );
      }else if (element.ordinal() == pivotElement.ordinal()){
        equal++;
      }else{
        Collections.swap(list, equal, --larger);
      }
    }

  }

  public static enum COLOR {
    RED, WHITE , BLUE
  }
}
