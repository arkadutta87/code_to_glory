package org.leetcode.facebook.arrays_strings;

import java.util.Map;

public class AddBinary {

  class AdditionResult {

    char value;
    char carry;
  }

  public static void main(String[] args) {

    AddBinary binaryAdd = new AddBinary();
    System.out.println(binaryAdd.addBinary("11" , "1"));
    System.out.println(binaryAdd.addBinary("1010" , "1011"));
    System.out.println(binaryAdd.addBinary("1" , "1"));

  }


  public String addBinary(String a, String b) {
    String result = "";

    int i = a.length() - 1;
    int j = b.length() - 1;

    char carryOver = '0';
    while ( i >= 0 && j >= 0 ){
      char chA = a.charAt(i);
      char chB = b.charAt(j);

      AdditionResult additionResult = binarySum(chA, chB, carryOver);
      result = additionResult.value + result;

      carryOver = additionResult.carry;
      i--;
      j--;
    }

    while(i >= 0 ){
      char chA = a.charAt(i);

      AdditionResult additionResult = binarySum(chA, '0', carryOver);
      result = additionResult.value + result;

      carryOver = additionResult.carry;
      i--;
    }

    while(j >= 0 ){
      char chB = b.charAt(j);

      AdditionResult additionResult = binarySum('0', chB, carryOver);
      result = additionResult.value + result;

      carryOver = additionResult.carry;
      j--;
    }

    if(carryOver == '1'){
      result = carryOver + result;
    }

    return result;
  }

  private AdditionResult binarySum(char a , char b, char carry){
    int intA = Integer.parseInt(a + "");
    int intB = Integer.parseInt(b + "");

    int carryOver = Integer.parseInt(carry + "");

    int value = intA + intB + carryOver;

    String binaryValue = convertIntToBinary(value);

    AdditionResult result = new AdditionResult();
    result.value = binaryValue.charAt(1);
    result.carry = binaryValue.charAt(0);

    return result;

  }

  private String convertIntToBinary(int value){
    String str = "";

    if(value == 0){
      str = "0";
    }

    while(value > 0 ){
      int charVal = value % 2;
      value = value / 2;

      str = charVal + str;
    }

    if(str.length() == 1){
      return "0" + str;
    }else{
      return str;
    }

  }
}
