package org.leetcode.facebook.tree_graphs;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class ValidateBinarySearchTree {

  public boolean isValidBST(TreeNode root) {

    Map<BigInteger, Integer> maxMap = new HashMap<>();
    Map<BigInteger, Integer> minMap = new HashMap<>();

    return isValidBSTLogic(root, maxMap, minMap, new BigInteger("0"));

  }

  private boolean isValidBSTLogic(TreeNode node, Map<BigInteger, Integer> maxMap, Map<BigInteger, Integer> minMap, BigInteger index) {
    if (node == null) {
      return true;
    }

    BigInteger leftIndex = new BigInteger(index.toString());
    leftIndex.multiply(BigInteger.ONE.add(BigInteger.ONE)).add(BigInteger.ONE);

    BigInteger rightIndex = new BigInteger(index.toString());
    leftIndex.multiply(BigInteger.ONE.add(BigInteger.ONE)).add(BigInteger.ONE).add(BigInteger.ONE);

//    long leftIndex = (2 * index + 1);
//    long rightIndex = (2 * index + 2);
    int max = findMax(node.left, maxMap, leftIndex);
    int min = findMin(node.right, minMap, rightIndex);

    if (max < node.val && node.val < min) {
      return isValidBSTLogic(node.left, maxMap, minMap, leftIndex) && isValidBSTLogic(node.right, maxMap, minMap, rightIndex);
    }
    else {
      return false;
    }
  }

  private int findMax(TreeNode node, Map<BigInteger, Integer> maxMap, BigInteger index) {

    if (node == null) {
      return Integer.MIN_VALUE;
    }

    if (maxMap.get(index) == null) {
      BigInteger leftIndex = new BigInteger(index.toString());
      leftIndex.multiply(BigInteger.ONE.add(BigInteger.ONE)).add(BigInteger.ONE);

      BigInteger rightIndex = new BigInteger(index.toString());
      leftIndex.multiply(BigInteger.ONE.add(BigInteger.ONE)).add(BigInteger.ONE).add(BigInteger.ONE);


      int leftMax = findMax(node.left, maxMap, leftIndex);
      int rightMax = findMax(node.right, maxMap, rightIndex);

      int max = Math.max(Math.max(node.val, leftMax), rightMax);
      maxMap.put(index, max);

    }
    int number  = maxMap.get(index);
    System.out.println("Maximum at Index  ->  " + index + ": Value : "+ number);

    return number;
  }

  private int findMin(TreeNode node, Map<BigInteger, Integer> minMap, BigInteger index) {

    if (node == null) {
      return Integer.MAX_VALUE;
    }

    if (minMap.get(index) == null) {

      BigInteger leftIndex = new BigInteger(index.toString());
      leftIndex.multiply(BigInteger.ONE.add(BigInteger.ONE)).add(BigInteger.ONE);

      BigInteger rightIndex = new BigInteger(index.toString());
      leftIndex.multiply(BigInteger.ONE.add(BigInteger.ONE)).add(BigInteger.ONE).add(BigInteger.ONE);

      int leftMin = findMin(node.left, minMap, leftIndex);
      int rightMin = findMin(node.right, minMap, rightIndex);

      int min = Math.min(Math.min(node.val, leftMin), rightMin);
      minMap.put(index, min);

    }
    int number  = minMap.get(index);
    System.out.println("Minimum at Index  ->  " + index + ": Value : "+ number);

    return number;
  }
}
