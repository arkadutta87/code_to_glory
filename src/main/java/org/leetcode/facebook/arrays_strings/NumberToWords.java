package org.leetcode.facebook.arrays_strings;

import java.util.Comparator;

public class NumberToWords {

  public static void main(String[] args) {
//     ArrayList<String> strings = new ArrayList<String>();
//     strings.add("Hello, World!");
//     strings.add("Welcome to CoderPad.");
//     strings.add("This pad is running Java " + Runtime.version().feature());

//     for (String string : strings) {
//       System.out.println(string);
//     }

    NumberToWords engine = new NumberToWords();
    System.out.println(engine.numberToWords(12919));
    System.out.println(engine.numberToWords(12901));
    System.out.println(engine.numberToWords(1234567));
    System.out.println(engine.numberToWords(1234567891));
    System.out.println(engine.numberToWords(12345));
    System.out.println(engine.numberToWords(200));
    System.out.println(engine.numberToWords(20));

  }

  public String numberToWords(int num) {

    if(num == 0){
      return "Zero";
    }

    String result = "";

    int billion = num / 1000000000;
    int million = (num - ( billion *1000000000 )) / 1000000;
    int thousand = (num - ( billion *1000000000 ) - (million * 1000000 ) ) /1000;
    int hundredRem = num - ( billion *1000000000 ) - (million * 1000000 ) - (thousand * 1000);


    if(billion != 0){
      result = result + one(billion) + " Billion";
    }
    if(million != 0 ){
      if(!result.isEmpty()){
        result += " ";
      }
      result += three(million) + " Million";
    }
    if(thousand != 0 ){
      if(!result.isEmpty()){
        result += " ";
      }
      result += three(thousand) + " Thousand";
    }if(hundredRem != 0 ){
      if(!result.isEmpty()){
        result += " ";
      }
      result += three(hundredRem);
    }


    return result;
  }

  private String one(int no){

    switch(no){
      case 1: return "One";
      case 2 : return "Two";
      case 3 : return "Three";
      case 4 : return "Four";
      case 5 : return "Five";
      case 6 : return "Six";
      case 7 : return "Seven";
      case 8 : return "Eight";
      case 9 : return "Nine";
    }

    return "";

  }

  private String two(int no){
    String str = "";

    if(no < 10){
      str += one(no) ;
    }else if(no <= 19){
      str += lessThan20(no);
    }else{
      int ten = no / 10;
      int left = no - (ten*10);

      if(left == 0){
        str += tens(ten);
      }else{
        str += tens(ten) +" " +  one(left);
      }

    }

    return str;
  }

  private String tens(int no){
    switch(no){
      case 2 : return "Twenty";
      case 3 : return "Thirty";
      case 4 : return "Forty";
      case 5 : return "Fifty";
      case 6 : return "Sixty";
      case 7 : return "Seventy";
      case 8 : return "Eighty";
      case 9 : return "Ninety";
    }

    return "";
  }

  private String lessThan20(int no){

    switch(no){
      case 10 : return "Ten";
      case 11 : return "Eleven";
      case 12 : return "Twelve";
      case 13 : return "Thirteen";
      case 14 : return "Fourteen";
      case 15 : return "Fifteen";
      case 16 : return "Sixteen";
      case 17 : return "Seventeen";
      case 18 : return "Eighteen";
      case 19 : return "Nineteen";
    }

    return "";
  }

  private String three(int number){
    String str = "";

    int hundred = number /100;
    int rem = number - (hundred * 100);

    if((hundred * rem) != 0 ){
      str += one(hundred) + " Hundred " + two(rem);
    }else{
      if(hundred == 0){
        str += two(rem);
      }else{
        str += one(hundred)+ " Hundred";
      }
    }

    return str;
  }
}
