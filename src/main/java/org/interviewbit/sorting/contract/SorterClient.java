package org.interviewbit.sorting.contract;

import java.util.ArrayList;
import java.util.List;

import org.interviewbit.sorting.contract.implementation.InsertionSorter;
import org.interviewbit.sorting.contract.implementation.MergeSorter;

public class SorterClient {

  public static void main(String[] args) {

    insertionSortClient();
    mergeSortClient();
  }

  private static double[] getAnUnsortedArray() {
    double[] array = {7.7, 2, 1, 6, 8, 5, 7.1, 3, 4, 25, 19, 16, 11, 10};

    return array;
  }

  private static void insertionSortClient() {

    double[] array = getAnUnsortedArray();

    List<Double> list = new ArrayList<>();
    for (double a : array) {
      list.add(a);
    }

    Sorter sorter = new InsertionSorter();
    sorter.sort(list);

    System.out.println("\nList after Insertion sorting : -> ");
    printTheArray(list);
  }

  private static void mergeSortClient() {

    double[] array = getAnUnsortedArray();

    List<Double> list = new ArrayList<>();
    for (double a : array) {
      list.add(a);
    }

    Sorter sorter = new MergeSorter();  
    sorter.sort(list);

    System.out.println("\nList after Merge sorting : -> ");
    printTheArray(list);
  }

  private static void printTheArray(List<Double> list) {

    for (Double a : list) {
      System.out.print(" " + a);
    }
  }
}
