package org.codechef.july_challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class AdaKing {

  private static class Pair<K,V>{
    private K key;
    private V value;

    public Pair(K key, V value){
      this.key = key;
      this.value = value;
    }

    public K getKey(){
      return key;
    }

    public V getValue(){
      return value;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (!(o instanceof Pair))
        return false;
      Pair<?, ?> pair = (Pair<?, ?>) o;
      return Objects.equals(key, pair.key) &&
          Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(key, value);
    }

    @Override
    public String toString() {
      return "Pair{" +
          "key=" + key +
          ", value=" + value +
          '}';
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int testCases = scanner.nextInt();

    for (int i = 0; i < testCases; i++) {
      char[][] chessBoard = generateChessBoard();
      int k = scanner.nextInt();

      int count = 0 ;
      int row = 0;
      int column = 0;

      Pair<Integer, Integer> position = new Pair<>(row,column);
      Queue<Pair<Integer, Integer>> moves = new LinkedList<>();

      Set<Pair<Integer, Integer>> movesDone = new HashSet<>();

      moves.add(position);
      chessBoard[row][column] = 'O';

      while(count < k){
        Pair<Integer, Integer> pos = moves.remove();
        movesDone.add(pos);

        count+= 1;

        int r = pos.getKey();
        int c = pos.getValue();


        List<Pair<Integer, Integer>> increments = legitMoves();

        for(Pair<Integer,Integer> increment : increments){
          int rowIncrement =increment.getKey();
          int columnIncrement = increment.getValue();

          int newRow = r + rowIncrement;
          int newColumn = c + columnIncrement;

          Pair<Integer, Integer> newPosition = new Pair<>(newRow, newColumn);
          if(!movesDone.contains(newPosition)){
            //check the row validity and column validity

            int rowPosition = newPosition.getKey();
            int columnPosition = newPosition.getValue();
            if((rowPosition >= 0 && rowPosition <= 7)  && (columnPosition >= 0 && columnPosition <= 7)){
              moves.add(newPosition);
              movesDone.add(newPosition);

            }
          }
        }

      }

      while(!moves.isEmpty()){
        Pair<Integer, Integer> block = moves.remove();
        chessBoard[block.getKey()][ block.getValue()] = 'X';
      }

      printChessBorad(chessBoard);
    }

  }

  private static List<Pair<Integer,Integer>> legitMoves(){
    List<Pair<Integer,Integer>> increments = new ArrayList<>();

    increments.add(new Pair<>(1,0));
    increments.add(new Pair<>(-1,0));
    increments.add(new Pair<>(0,1));
    increments.add(new Pair<>(0 , -1));
    increments.add(new Pair<>(1,1));
    increments.add(new Pair<>(1,-1));
    increments.add(new Pair<>(-1,1));
    increments.add(new Pair<>(-1,-1));

    return increments;
  }

  private static void printChessBorad(char[][] board){
    for(int i = 0 ; i < board.length ; i ++){
      System.out.println(board[i]);
    }
  }


  private static char[][] generateChessBoard(){
    char[][] chessBoard = {
        {'.','.','.','.','.','.','.','.'},
        {'.','.','.','.','.','.','.','.'},
        {'.','.','.','.','.','.','.','.'},
        {'.','.','.','.','.','.','.','.'},
        {'.','.','.','.','.','.','.','.'},
        {'.','.','.','.','.','.','.','.'},
        {'.','.','.','.','.','.','.','.'},
        {'.','.','.','.','.','.','.','.'}
    };
    return chessBoard;
  }
}
