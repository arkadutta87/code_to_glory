package org.codechef.august_challenge;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SmallestKMP {

  public static void main(String[] args) throws java.lang.Exception{

    Scanner scanner = new Scanner(System.in);
    int testCases = Integer.parseInt(scanner.nextLine());

    for(int i = 0 ; i < testCases ; i++){
      String mainString = scanner.nextLine();
      String pattern = scanner.nextLine();

      //First form the frequency TreeMap
      TreeMap<Character, Integer> frequencyMap = computeFrequencyMap(mainString);

      //Remove from the frequency map the character occurences in pattern
      String finalString = pattern;
      updateFrequencyMap(pattern, frequencyMap);

      finalString = generateTheSmallestLexAnagram(frequencyMap, finalString);

      if(i != testCases-1){
      System.out.println(finalString);
      }else {
        System.out.print(finalString);
      }
    }

  }

  private static String generateTheSmallestLexAnagram(TreeMap<Character, Integer> frequencyMap, String finalString) {
    for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
      char currentAlphabet = entry.getKey();
      int val = entry.getValue();

      while(val > 0 ){
        if(currentAlphabet <= finalString.charAt(0)){
          finalString = currentAlphabet + finalString;
        }else {
          finalString += currentAlphabet;
        }
        --val;
      }
    }
    return finalString;
  }

  private static void updateFrequencyMap(String pattern, TreeMap<Character, Integer> frequencyMap) {
    for(int k = 0; k < pattern.length() ; k++){
      char ch = pattern.charAt(k);
      frequencyMap.computeIfPresent(ch, (key,val) -> val -1);
    }
  }

  private static TreeMap<Character, Integer> computeFrequencyMap(String mainString) {
    TreeMap<Character,Integer> frequencyMap = new TreeMap<>();
    for(int k = 0; k < mainString.length() ; k++){
      char ch = mainString.charAt(k);
      frequencyMap.computeIfPresent(ch, (key, value ) -> value +1);
      frequencyMap.putIfAbsent(ch, 1);
    }
    return frequencyMap;
  }
}
