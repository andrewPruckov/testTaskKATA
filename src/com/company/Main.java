package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expressions = scanner.nextLine();
        calc(expressions);
    }
    public static String calc(String input){
        HashMap<String, Integer> arabNum = new HashMap<>();
        HashMap<String, Integer> romNum = new HashMap<>();
        arabNum.put("0", 0);
        arabNum.put("1", 1);
        arabNum.put("2", 2);
        arabNum.put("3", 3);
        arabNum.put("4", 4);
        arabNum.put("5", 5);
        arabNum.put("6", 6);
        arabNum.put("7", 7);
        arabNum.put("8", 8);
        arabNum.put("9", 9);
        arabNum.put("10", 10);
        romNum.put("I", 1);
        romNum.put("II", 2);
        romNum.put("III", 3);
        romNum.put("IV", 4);
        romNum.put("V", 5);
        romNum.put("VI", 6);
        romNum.put("VII", 7);
        romNum.put("VIII", 8);
        romNum.put("IX", 9);
        romNum.put("X", 10);
        char[] inputC = input.toCharArray();
        int numOfSpaces = 0;
        int numOfArabN = 0;
        int numOfRomanN = 0;
        if (input.contains("+") == true){
            String num1 = input.substring(0,input.lastIndexOf("+"));
            String num2 = input.substring((input.lastIndexOf("+") + 1), input.length());
            if (arabNum.containsKey(num1) && arabNum.containsKey(num2)){
               int num1I = Integer.parseInt(num1);
               int num2I = Integer.parseInt(num2);
               System.out.println(num1I + num2I);
            }
            if (romNum.containsKey(num1) && romNum.containsKey(num2)){
                int num1I = romNum.get(num1);
                int num2I = romNum.get(num2);
                System.out.println(convertNumToRoman(num1I + num2I));
            }
        }
        if (input.contains("-") == true){
            String num1 = input.substring(0,input.lastIndexOf("-"));
            String num2 = input.substring((input.lastIndexOf("-") + 1), input.length());
            if (arabNum.containsKey(num1) && arabNum.containsKey(num2)){
                int num1I = Integer.parseInt(num1);
                int num2I = Integer.parseInt(num2);
                System.out.println(num1I - num2I);
            }
            if (romNum.containsKey(num1) && romNum.containsKey(num2)){
                int num1I = romNum.get(num1);
                int num2I = romNum.get(num2);
                if (num2I>num1I){
                    System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                }
                else {
                    System.out.println(convertNumToRoman(num1I - num2I));
                }
            }
        }
        if (input.contains("/") == true){
            String num1 = input.substring(0,input.lastIndexOf("/"));
            String num2 = input.substring((input.lastIndexOf("/") + 1), input.length());
            if (arabNum.containsKey(num1) && arabNum.containsKey(num2)){
                int num1I = Integer.parseInt(num1);
                int num2I = Integer.parseInt(num2);
                if (num2I == 0){
                    System.out.println("throws Exception //т.к. на ноль делить нельзя");
                }
                else {
                    System.out.println((num1I / num2I));
                }
            }
            if (romNum.containsKey(num1) && romNum.containsKey(num2)){
                int num1I = romNum.get(num1);
                int num2I = romNum.get(num2);
                if (num2I == 0){
                    System.out.println("throws Exception //т.к. на ноль делить нельзя");
                }
                else {
                    System.out.println(convertNumToRoman(num1I / num2I));
                }
            }

        }
        if (input.contains("*") == true){
            String num1 = input.substring(0,input.lastIndexOf("*"));
            String num2 = input.substring((input.lastIndexOf("*") + 1), input.length());
            if (arabNum.containsKey(num1) && arabNum.containsKey(num2)){
                int num1I = Integer.parseInt(num1);
                int num2I = Integer.parseInt(num2);
                System.out.println(num1I * num2I);
            }
            if (romNum.containsKey(num1) && romNum.containsKey(num2)){
                int num1I = romNum.get(num1);
                int num2I = romNum.get(num2);
                if (num1I < 0 || num2I < 0){
                    System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                }
                else {
                    System.out.println(convertNumToRoman(num1I * num2I));
                }
            }
        }
        return null;
    }
    public static String convertNumToRoman (int numArab) {
        String[] roman = {"null", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII",
                "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII",
                "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI",
                "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String s = roman[numArab];
        return s;
    }
}
