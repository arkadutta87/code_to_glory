package org.leetcode.facebook.arrays_strings;

public class OneEditDistance {

  public static void main(String[] args) {
    OneEditDistance solution = new OneEditDistance();
//    System.out.println(solution.isOneEditDistance("ab", "acb"));
    System.out.println(solution.isOneEditDistance("ab", "ab"));

  }

  public boolean isOneEditDistance(String s, String t) {

    String base = s, convert = t;

    if (s.length() > t.length()) {
      convert = s;
      base = t;
    }

    return isOneEditDistanceLogic(base, convert);
  }

  private boolean isOneEditDistanceLogic(String base, String convert) {
    int i = base.length() - 1;
    int j = convert.length() - 1;

    int diff = convert.length() - base.length();

    while (j >= diff) {
      if (convert.charAt(j) == base.charAt(i)) {
        //good case : Try the next character
        j--;
        i--;
      }
      else {
        //Try the delete case
        String convertRemaining = convert.substring(0, j);
        String baseRemaining = base.substring(0,i + 1);

        boolean flag = convertRemaining.equals(baseRemaining);

        //Try the substitution case
        convertRemaining += base.charAt(i);
        flag = flag || convertRemaining.equals(baseRemaining);

        //Try the insertion case
        return flag;
      }
    }

    if(j == -1){
      return false;
    }

    if (j > 0) {
      return false;
    }
    else {
      //Only one deletion converts : convert to base
      return true;
    }

  }
}
