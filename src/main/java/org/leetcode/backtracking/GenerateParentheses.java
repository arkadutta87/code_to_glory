package org.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

  public static void main(String[] args) {
    GenerateParentheses parenthesesGenerator = new GenerateParentheses();
    List<String> parenthesisList = parenthesesGenerator.generateParenthesis(5);

    System.out.println("The generated parenthesis of 1 pair ===== ");
    for(String parentheses : parenthesisList){
      System.out.println(parentheses);
    }
  }

  public List<String> generateParenthesis(int n) {
    List<String> validCombinations = new ArrayList<>();

    char[] parentheses = new char[n * 2];
    generateParenthesesViaBacktracking(parentheses, -1, (n * 2) - 1, validCombinations);
    return validCombinations;
  }

  private void generateParenthesesViaBacktracking(char[] solution, int currentIteration, int endIteration, List<String> solutionList) {
    if (isPartSolutionInValid(solution, currentIteration, endIteration)) {
      return;
    }

    if (isASolution(solution, currentIteration, endIteration)) {
      processSolution(solution, solutionList);
    }
    else {
      currentIteration += 1;
      char[] candidates = generateCandidates();

      for (int i = 0; i < candidates.length; i++) {
        solution[currentIteration] = candidates[i];
        generateParenthesesViaBacktracking(solution, currentIteration, endIteration, solutionList);
      }
    }
  }

  private char[] generateCandidates() {
    return new char[]{'(', ')'};
  }

  private boolean isPartSolutionInValid(char[] solution, int currentIteration, int endIteration) {
    Stack<Character> stack = new Stack<>();

    if(currentIteration < 0 ){
      return false;
    }

    for (int i = 0; i <= currentIteration; i++) {
      char ch = solution[i];

      if (ch == '(') {
        stack.push(ch);
      }
      else {
        if (stack.isEmpty()) {
          return true;
        }
        char temp = stack.pop();
        if (temp != '(') {
          return true;
        }
      }
    }

    int remainingOpeningBrackets = stack.size();
    return !(remainingOpeningBrackets <= (endIteration - currentIteration));
  }

  private boolean isASolution(char[] solution, int currentIteration, int endIteration) {
    return currentIteration == endIteration;
  }

  private void processSolution(char[] solution, List<String> solutionList) {
    solutionList.add(new String(solution));
  }
}
