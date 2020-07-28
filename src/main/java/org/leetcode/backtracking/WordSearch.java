package org.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class WordSearch {

  public static void main(String[] args) {
    WordSearch wordSearch = new WordSearch();
    char[][] board = new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
    System.out.println(wordSearch.exist(board, "ABCCED"));
    System.out.println(wordSearch.exist(board, "SEE"));
    System.out.println(wordSearch.exist(board, "ABCB"));
    System.out.println(wordSearch.exist(board, "ESEECF"));
    System.out.println(wordSearch.exist(board, "ESEECS"));

    System.out.println("**********************");
    //////
    board = new char[][]{
        {'C', 'A', 'A'},
        {'A', 'A', 'A'},
        {'B', 'C', 'D'}
    };
    System.out.println(wordSearch.exist(board, "AAB"));
    System.out.println(wordSearch.exist(board, "AAA"));
    System.out.println(wordSearch.exist(board, "AAAA"));
    System.out.println(wordSearch.exist(board, "AAAAB"));
    System.out.println(wordSearch.exist(board, "AAAABA"));
    System.out.println(wordSearch.exist(board, "AAAABC"));
    System.out.println(wordSearch.exist(board, "AAAABCA"));

  }

  private static class Tuple<K, V> {

    private K first;
    private V second;

    public Tuple(K first, V second) {
      this.first = first;
      this.second = second;
    }

    public K getFirst() {
      return first;
    }

    public V getSecond() {
      return second;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (!(o instanceof Tuple))
        return false;
      Tuple<?, ?> tuple = (Tuple<?, ?>) o;
      return Objects.equals(first, tuple.first) &&
          Objects.equals(second, tuple.second);
    }

    @Override
    public int hashCode() {
      return Objects.hash(first, second);
    }
  }

  public boolean exist(char[][] board, String word) {
    List<Tuple<Integer, Integer>> solution = new ArrayList<>();
    Set<Tuple<Integer, Integer>> traversedCells = new LinkedHashSet<>();

    return findWord(solution, -1, board, word, traversedCells);
  }

  private boolean findWord(List<Tuple<Integer, Integer>> solution,
                           int currentIndex,
                           char[][] board,
                           String word,
                           Set<Tuple<Integer, Integer>> traversedCells) {

    if (isSolution(currentIndex, word)) {
      return true;
    }
    else {
      List<Tuple<Integer, Integer>> candidates = generateCandidates(solution, currentIndex, board, word, traversedCells);
      currentIndex++;

      for (Tuple<Integer, Integer> candidate : candidates) {
        solution.add(currentIndex, candidate);
        traversedCells.add(candidate);
        boolean result = findWord(solution, currentIndex, board, word, traversedCells);
        if (result) {
          return true;
        }
        else {
          traversedCells.remove(candidate);
        }
      }
    }

    return false;
  }

  private List<Tuple<Integer, Integer>> generateCandidates(List<Tuple<Integer, Integer>> solution,
                                                           int currentIndex,
                                                           char[][] board,
                                                           String word,
                                                           Set<Tuple<Integer, Integer>> traversedCells) {
    List<Tuple<Integer, Integer>> candidates = new ArrayList<>();

    if (currentIndex < 0) {
      populateCandidatesBaseCase(board, word, candidates);
    }
    else {
      Tuple<Integer, Integer> currentCell = solution.get(currentIndex);
      List<Tuple<Integer, Integer>> increments = increments();

      for (Tuple<Integer, Integer> increment : increments) {
        Tuple<Integer, Integer> newCell = new Tuple<>(currentCell.getFirst() + increment.getFirst(),
                                                      currentCell.getSecond() + increment.getSecond());

        if (!traversedCells.contains(newCell) && (newCell.getFirst() >= 0 && newCell.getFirst() <= board.length - 1) &&
            (newCell.getSecond() >= 0 && newCell.getSecond() <= board[currentCell.getFirst()].length - 1)) {

          if (board[newCell.getFirst()][newCell.getSecond()] == word.charAt(currentIndex + 1)) {
            candidates.add(newCell);
          }
        }
      }

    }

    return candidates;
  }

  private List<Tuple<Integer, Integer>> increments() {
    List<Tuple<Integer, Integer>> increments = new ArrayList<>();

    increments.add(new Tuple<Integer, Integer>(0, 1));
    increments.add(new Tuple<Integer, Integer>(0, -1));
    increments.add(new Tuple<Integer, Integer>(1, 0));
    increments.add(new Tuple<Integer, Integer>(-1, 0));

    return increments;
  }

  private void populateCandidatesBaseCase(char[][] board, String word, List<Tuple<Integer, Integer>> candidates) {
    char ch = word.charAt(0);

    for (int i = 0; i < board.length; i++) {
      char[] row = board[i];
      for (int j = 0; j < row.length; j++) {
        if (row[j] == ch) {
          candidates.add(new Tuple<>(i, j));
        }
      }
    }
  }

  private boolean isSolution(int currentIndex, String word) {
    return currentIndex == word.length() - 1;
  }
}
