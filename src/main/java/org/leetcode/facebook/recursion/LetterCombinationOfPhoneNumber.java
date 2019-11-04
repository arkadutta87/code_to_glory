package org.leetcode.facebook.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {

  Map<Integer, List<Character>> map = new HashMap<>();
  List<String> result = new ArrayList<>();

  public static void main(String[] args) {
    LetterCombinationOfPhoneNumber engine = new LetterCombinationOfPhoneNumber();
    List<String> strings = engine.letterCombinations("23");
    engine.print(strings);


  }

  private void print(List<String> strings){
    System.out.println("*******************");
    for(String aStr : strings){
      System.out.println(aStr);
    }
    System.out.println("*******************");
  }

  private void reset() {
    map.clear();
    map.put(2, Arrays.asList('a', 'b', 'c'));
    map.put(3, Arrays.asList('d', 'e', 'f'));
    map.put(4, Arrays.asList('g', 'h', 'i'));
    map.put(5, Arrays.asList('j', 'k', 'l'));
    map.put(6, Arrays.asList('m', 'n', 'o'));
    map.put(7, Arrays.asList('p', 'q', 'r', 's'));
    map.put(8, Arrays.asList('t', 'u', 'v'));
    map.put(9, Arrays.asList('w', 'x', 'y', 'z'));

    result.clear();

  }

//  public static void main(String[] args) {
//    ArrayList<String> strings = new ArrayList<String>();
//    strings.add("Hello, World!");
//    strings.add("Welcome to CoderPad.");
//    strings.add("This pad is running Java " + Runtime.version().feature());
//
//    for (String string : strings) {
//      System.out.println(string);
//    }
//  }

  public List<String> letterCombinations(String digits) {

    reset();
    if(digits.length() >= 1){
      String str = "";
      recurse(digits, 0, new StringBuilder());
    }

    return result;
  }

  private void recurse(String digits, int index, StringBuilder pStr) {
    if (isASolution(digits, index)) {
      result.add(pStr.toString());
    }
    else {
      int no = Integer.parseInt(digits.charAt(index) + "");
      List<Character> chars = map.getOrDefault(no, new ArrayList<Character>());

      int length = pStr.length();
      for (char ch : chars) {
        pStr.append(ch);
        recurse(digits, index + 1, pStr);
        pStr.deleteCharAt(length);
      }

    }


  }

  private boolean isASolution(String digits, int index) {
    if (index == digits.length()) {
      return true;
    }

    return false;
  }
}


