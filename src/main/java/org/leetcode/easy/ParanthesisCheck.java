package org.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ParanthesisCheck {

  public static void main(String[] args) {
    ParanthesisCheck checker = new ParanthesisCheck();
    System.out.println("Is Valid : " + checker.isValid("()"));
  }

  public boolean isValid(String s) {

    char[] parenthesisCharacters = s.toCharArray();

    Stack<Character> parathesisCheckStack = new Stack<>();
    Set<Character> reverseParanthesisSet = generateTheReverseCharacterSet();

    Map<Character, Character> paranthesisPairMap = generateTheParenthesisPairMap();

    for (char aParenthesis : parenthesisCharacters) {
      if (reverseParanthesisSet.contains(aParenthesis)) {
        if(parathesisCheckStack.isEmpty()){
          return false;
        }

        Character pop = parathesisCheckStack.pop();
        if ( paranthesisPairMap.get(pop).charValue() != aParenthesis) {
          return false;
        }
      }
      else {
        parathesisCheckStack.push(aParenthesis);
      }
    }

    return parathesisCheckStack.isEmpty();
  }

  private Set<Character> generateTheReverseCharacterSet() {
    Set<Character> reverseParanthesis = new HashSet<>();
    reverseParanthesis.add(')');
    reverseParanthesis.add('}');
    reverseParanthesis.add(']');

    return reverseParanthesis;
  }

  private Map<Character, Character> generateTheParenthesisPairMap() {
    Map<Character, Character> paranthesisPairMap = new HashMap<>();
    paranthesisPairMap.put('(', ')');
    paranthesisPairMap.put('{', '}');
    paranthesisPairMap.put('[', ']');

    return paranthesisPairMap;
  }
}
