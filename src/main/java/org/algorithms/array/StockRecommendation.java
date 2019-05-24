package org.algorithms.array;

import javafx.util.Pair;

/*
Write a program that takes an array denoting the daily stock price,
and returns the maximum profit that could be made by buying and then selling one share of that stock.
 */

public class StockRecommendation {

  public static void main(String[] args) {

    int[] array = {310,315,275,295,260,270,290,230,255,250};

    StockRecommendation stockRecommendation = new StockRecommendation();
    Pair<Integer, Integer> integerIntegerPair = stockRecommendation.indexOfBuyAndSellStock(array);

    if(integerIntegerPair.getKey() != -1){
      System.out.println("Buy Index : " + integerIntegerPair.getKey() + " , Sell Index : "+ integerIntegerPair.getValue()
                        + ", and the max profit: " + (array[integerIntegerPair.getValue()] - array[integerIntegerPair.getKey()]) );
    }else{
      System.out.println("Making profit not possible");
    }


  }

  private Pair<Integer, Integer> indexOfBuyAndSellStock(int[] array) {

    Pair<Integer, Integer> buyAndSellPoint = null;
    int maxProfit = 0, min = Integer.MAX_VALUE;
    int buyIndex = 0, sellIndex = 0;

    int i = 0;
    int minPoint = 0;
    for (int aStockPrice : array) {
      if (min > aStockPrice) {
        min = aStockPrice;
        minPoint = i;
      }

      if (maxProfit < (aStockPrice - min)) {
        maxProfit = aStockPrice - min;
        buyIndex = minPoint;
        sellIndex = i;
      }
      ++i;
    }

    if (maxProfit == 0) {
      buyAndSellPoint = new Pair<>(-1, -1);
    }
    else {
      buyAndSellPoint = new Pair<>(buyIndex, sellIndex);
    }

    return buyAndSellPoint;
  }
}
