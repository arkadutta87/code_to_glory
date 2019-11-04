package org.leetcode.facebook.arrays_strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharactersV2 {

  public static void main(String[] args) {
    LongestSubstringWithAtMostKDistinctCharactersV2 engine = new LongestSubstringWithAtMostKDistinctCharactersV2();
    System.out.println(engine.lengthOfLongestSubstringKDistinct("aabbaacdddfe", 4));
    System.out.println(engine.lengthOfLongestSubstringKDistinct("", 4));
  }

  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int maxLength = Integer.MIN_VALUE;
    int i = 0, j = 0;

    LinkedHashMap<Character, Integer> charctersLastOccur = new LinkedHashMap<>();

    if(s.length() * k == 0 ){
      return 0;
    }

    int size = s.length();

    while(j < size){

      char ch = s.charAt(j);

      //If character occurs remove and insert it with new Index so that be the rightmost entry
      if(charctersLastOccur.containsKey(ch)){
        charctersLastOccur.remove(ch);

      }

      charctersLastOccur.put(ch, j++);

      //One more distinct character added - here is a problem - need to shift i
      if(charctersLastOccur.size() == k+1){
        Map.Entry<Character,Integer> entry = charctersLastOccur.entrySet().iterator().next();
        charctersLastOccur.remove(entry.getKey());

        i = entry.getValue() +1;

      }

      maxLength = Math.max(maxLength , (j-i));


    }

    return maxLength;
  }
}
