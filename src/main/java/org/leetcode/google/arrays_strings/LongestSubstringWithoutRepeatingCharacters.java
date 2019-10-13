package org.leetcode.google.arrays_strings;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    String strTemp = "";
    System.out.println(strTemp.length());

  }

  public int lengthOfLongestSubstring(String s) {
    int ans = 0;

    if (Objects.nonNull(s)) {
      int i = 0, j = 0;
      int length = s.length();

      Set<Character> set = new HashSet<>();
      while (i < length && j < length) {
        if (!set.contains(s.charAt(j))) {
          ans = Math.max(ans, j - i + 1);
          set.add(s.charAt(j++));
        }
        else {
          set.remove(s.charAt(i++));
        }
      }
    }

    return ans;
  }
}
