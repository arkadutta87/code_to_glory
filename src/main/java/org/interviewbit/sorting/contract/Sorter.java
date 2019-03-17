package org.interviewbit.sorting.contract;

import java.util.List;

public interface Sorter {

  <T extends Comparable<? super T>> void sort(List<T> list);

}
