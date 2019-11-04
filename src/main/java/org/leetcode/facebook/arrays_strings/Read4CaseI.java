package org.leetcode.facebook.arrays_strings;

public class Read4CaseI {

  public static void main(String[] args) {

    char[] chArray = new char[]{'a', 'b', 'c'};

    System.out.println(new String(chArray));


  }

  private int read4(char[] buf){
    return 0;
  }

  public int read(char[] buf, int n) {

    int index = -1;
    char[] internalBuffer = new char[4];

    int read = 0;

    //Now handle the case of lesser characters
    while ((read = read4(internalBuffer)) == 4 && (index < n-1)) {
      for (int i = 0; i < read && (index < n-1); i++) {
        buf[++index] = internalBuffer[i];
        System.out.println("Index : " + index);
      }
    }

    for (int i = 0; i < read && (index < n-1); i++) {
      buf[++index] = internalBuffer[i];
      System.out.println("Index : " + index);
    }

    System.out.println(new String(buf));

    return index+1;
  }
}
