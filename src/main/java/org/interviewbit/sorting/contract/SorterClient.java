package org.interviewbit.sorting.contract;

import java.util.ArrayList;
import java.util.List;

import org.interviewbit.sorting.contract.implementation.InsertionSorter;

public class SorterClient {

  public static void main(String[] args) {

    double[] array = {7.7, 2, 1, 6, 8, 5, 7.1, 3, 4, 25, 19, 16, 11, 10};

    List<Double> list = new ArrayList<>();
    for (double a : array) {
      list.add(a);
    }

    Sorter sorter = new InsertionSorter();
    sorter.sort(list);

    System.out.println("List after sorting : -> ");
    for (Double a : list) {
      System.out.print(" " + a);
    }

  }
}
