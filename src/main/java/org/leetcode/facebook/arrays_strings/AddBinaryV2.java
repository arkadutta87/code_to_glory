package org.leetcode.facebook.arrays_strings;

public class AddBinaryV2 {

  public String addBinary(String a, String b) {
    int carry = 0;
    String result = "";

    int i = a.length() - 1;
    int j = b.length() - 1;

    while (i >= 0 || j >= 0 || carry != 0) {
      carry += i >= 0 ? a.charAt(i) - '0' : 0;
      carry += j >= 0 ? b.charAt(j) - '0' : 0;

      result = (char) (carry % 2 + '0') + result;
      carry = carry / 2;

      i--;
      j--;
    }

    return result;
  }

  public static void main(String[] args) {
    AddBinaryV2 binaryAdd = new AddBinaryV2();
    System.out.println(binaryAdd.addBinary("11" , "1"));
    System.out.println(binaryAdd.addBinary("1010" , "1011"));
    System.out.println(binaryAdd.addBinary("1" , "1"));
    System.out.println(binaryAdd.addBinary("0" , "0"));


  }
}
