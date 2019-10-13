package org.leetcode.algorithm.recursion;

public class StringReversal {

  public static void main(String[] args) {

    String str = "arkadutta";

    StringReversal reversalUtil = new StringReversal();
    reversalUtil.printReverse(str.toCharArray());

  }

  public void printReverse(char [] str) {
    helper(0, str);
  }

  public void reverseString(char[] s) {
    helper2(0, s);
  }

  private void helper2(int index, char[] str){
    if(str == null || index >= str.length){
      return;
    }

    int length = str.length-1;
    char ch = str[index];
    helper2(index+1, str);

    str[length - index] = ch;
  }

  private void helper(int index, char[] str){

    if(str == null || index >= str.length){
      return;
    }

    helper(index+1, str);
    System.out.print(str[index]);
  }

}
