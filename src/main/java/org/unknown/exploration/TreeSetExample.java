package org.unknown.exploration;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetExample {

  public static void main(String[] args) {
    Set<Integer> random = new HashSet<Integer>();
    for (int i = 0; i < 10; i++) {
      random.add( i);
    }

    System.out.println("Initial Set: " + random);
    TreeSet<Integer> sorted = new TreeSet<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
      }
    });
    sorted.addAll(random);

    SortedSet<Integer> integers = sorted.tailSet(6, false);
    System.out.println("Sorted Set: " + sorted);
    System.out.println("Tail Set: " + integers);
  }
}
