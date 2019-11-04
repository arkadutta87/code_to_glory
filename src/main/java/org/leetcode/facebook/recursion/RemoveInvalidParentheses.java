package org.leetcode.facebook.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {

  Set<String> result = new HashSet<>();
  int minRemoval;

  public static void main(String[] args) {
    RemoveInvalidParentheses engine = new RemoveInvalidParentheses();
    List<String> strings = engine.removeInvalidParentheses("()())()");
    engine.print(strings);


    strings = engine.removeInvalidParentheses("(a)())()");
    engine.print(strings);


    strings = engine.removeInvalidParentheses(")(");
    engine.print(strings);


    strings = engine.removeInvalidParentheses("(abc)d))");
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
    this.result.clear();
    minRemoval = Integer.MAX_VALUE;
  }

  public List<String> removeInvalidParentheses(String s) {
    reset();

    recurse(s, 0, 0, 0, new StringBuilder(), 0);
    return new ArrayList<>(result);
  }

  private void recurse(String s, int index, int leftCount, int rightCount, StringBuilder strBldr, int removed) {

    //terminating condition
    if (index == s.length()) {
      //valid case
      if (leftCount == rightCount) {
        //removed <= globalMinimum
        if (removed <= this.minRemoval) {

          String str = strBldr.toString();

          //update the globalMin if a new value has come and also reset the set
          if (removed < minRemoval) {
            minRemoval = removed;
            result.clear();

          }

          result.add(str);
        }
      }
    }
    else {

      char ch = s.charAt(index);
//      System.out.println("********");
//      System.out.println("Index : "+index + "; StringBuilder : "+strBldr);

      int length = strBldr.length();
      //not '(' neither ')'
      if (ch != '(' && ch != ')') {
        //add the character and recurse
        strBldr.append(ch);
        recurse(s, index + 1, leftCount, rightCount, strBldr, removed);
        strBldr.deleteCharAt(length);
      }
      else {
        if (ch == '(') {
          // add - dont add and recurse
          strBldr.append(ch);
          recurse(s, index + 1, leftCount + 1, rightCount, strBldr, removed);
          strBldr.deleteCharAt(length);
          recurse(s, index + 1, leftCount, rightCount, strBldr, removed + 1);
        }
        else {

          if (rightCount < leftCount) {
            strBldr.append(ch);
            recurse(s, index + 1, leftCount, rightCount + 1, strBldr, removed);
            strBldr.deleteCharAt(length);
            recurse(s, index + 1, leftCount, rightCount, strBldr, removed + 1);
          }
          else {
            recurse(s, index + 1, leftCount, rightCount, strBldr, removed + 1);
          }
        }
      }
    }
  }

}
