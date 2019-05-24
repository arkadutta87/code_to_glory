package org.algorithms.array;

/*
Write code to arrange an array such that
all even move to the start and all odds at the end.
 */
public class ArrangeEvenOddArray {

  public static void main(String[] args) {
    int[] array = new int[]{7,2,2,3,4,5,8,8};

    ArrangeEvenOddArray evenOddArranger = new ArrangeEvenOddArray();
    evenOddArranger.arrangeEvenFirstOddNext(array);

    for(int ele :array){
      System.out.print(ele + " " );
    }

  }

  private void arrangeEvenFirstOddNext(int[] array) {
    int evenNext = 0, oddNext = array.length - 1;

    while (evenNext < oddNext) {
      //element even - increase the counter
      if (array[evenNext] % 2 == 0) {
        evenNext += 1;
      }
      else {
        //element odd push to end
        int temp = array[evenNext];
        array[evenNext] = array[oddNext];
        array[oddNext] = temp;
        oddNext--;
      }
    }

  }
}
