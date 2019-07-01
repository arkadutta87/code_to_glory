package org.interviewbit.sorting.contract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.interviewbit.sorting.contract.implementation.InsertionSorter;
import org.interviewbit.sorting.contract.implementation.MergeSorter;
import org.interviewbit.sorting.contract.implementation.QuickSorter;

public class SorterClient {

  public static void main(String[] args) {

    insertionSortClient();
    mergeSortClient();
    quickSortClient();
  }

  private static Double[] getAnUnsortedArray() {
    Double[] array = {7.7, 2.0, 1.0, 6.0, 8.0, 5.0, 7.1, 3.0, 4d, 25d, 7.1, 19d, 6d, 16d, 11d, 10d};

    return array;
  }

  private static void insertionSortClient() {

    Double[] array = getAnUnsortedArray();

    List<Double> list = Arrays.asList(array);

    Sorter sorter = new InsertionSorter();
    sorter.sort(list);

    System.out.println("\nList after Insertion sorting : -> ");
    printTheArray(list);
  }

  private static void mergeSortClient() {

    Double[] array = getAnUnsortedArray();

    List<Double> list = new ArrayList<>();
    for (double a : array) {
      list.add(a);
    }

    Sorter sorter = new MergeSorter();
    sorter.sort(list);

    System.out.println("\nList after Merge sorting : -> ");
    printTheArray(list);
  }

  private static void quickSortClient() {

    Double[] array = getAnUnsortedArray();

    List<Double> list = Arrays.asList(array);

    Sorter sorter = new QuickSorter();
    sorter.sort(list);

    System.out.println("\nList after Quick sorting : -> ");
    printTheArray(list);
  }

  private static void printTheArray(List<Double> list) {

    for (Double a : list) {
      System.out.print(" " + a);
    }
  }
}
