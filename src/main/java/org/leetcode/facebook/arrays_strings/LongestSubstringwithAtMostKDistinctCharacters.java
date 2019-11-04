package org.leetcode.facebook.arrays_strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {

  public static void main(String[] args) {
    LongestSubstringwithAtMostKDistinctCharacters engine = new LongestSubstringwithAtMostKDistinctCharacters();

    System.out.println(engine.lengthOfLongestSubstringKDistinct("eceba", 2));


  }

  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> freqMap = new HashMap<>();
    int result = Integer.MIN_VALUE;
    int count = 0;

    if (s.length() == 0 || k == 0) {
      return 0;
    }

    int i = 0, j = 0;

    while (i < s.length() && j < s.length()) {
      char ch = s.charAt(j);
      //check already in Map

      if (freqMap.containsKey(ch)) {
        //good case
        int temp = freqMap.get(ch);
        freqMap.put(ch, temp + 1);

        ++j;
        if (result < (j - i)) {
          result = j - i;
        }
      }
      else {
        //good case - count < k
        if (count < k) {
          freqMap.put(ch, 1);
          count++;

          ++j;
          if (result < (j - i)) {
            result = j - i;
          }
        }
        else {
          //bad case - increment i
          char chTemp = s.charAt(i);
          Integer temp = freqMap.get(chTemp);

          if (temp == 1) {
            freqMap.remove(chTemp);
            count--;
          }
          else {
            freqMap.put(chTemp, temp - 1);
          }
          i++;
        }

      }
    }

    return result;
  }
}
