package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String expressions = scanner.nextLine();
        calc(expressions);
    }
    public static String calc(String input) throws Exception{
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
        int addOperation1 = input.indexOf("+");
        int addOperation2 = input.lastIndexOf("+");
        int subOperation1 = input.indexOf("-");
        int subOperation2 = input.lastIndexOf("-");
        int divOperation1 = input.indexOf("/");
        int divOperation2 = input.lastIndexOf("/");
        int mulOperation1 = input.indexOf("*");
        int mulOperation2 = input.lastIndexOf("*");
        System.out.println(addOperation1);
        System.out.println(addOperation2);
        System.out.println(subOperation1);
        System.out.println(subOperation2);
        System.out.println(divOperation1);
        System.out.println(divOperation2);
        System.out.println(mulOperation1);
        System.out.println(mulOperation2);
        if (addOperation1 == -1 && subOperation1 == -1 && divOperation1 == -1 && mulOperation1 == -1){
            throw new Exception("throws Exception //т.к. строка не является математической операцией1");
        }
        if (addOperation1 != addOperation2 || subOperation1 != subOperation2 || divOperation1 != divOperation2 || mulOperation1 != mulOperation2){
            throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)1");
        }
        if ( addOperation1 > 0 && addOperation1 == addOperation2 && (subOperation1 > 0 || divOperation1 > 0 || mulOperation1 > 0)){
            throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)2");
        }
        if (subOperation1 > 0 && subOperation1 == subOperation2 && (addOperation1 > 0 || divOperation1 > 0 || mulOperation1 > 0)){
            throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)3");
        }
        if (divOperation1 > 0 && divOperation1 == divOperation2 && (addOperation1 > 0 || subOperation1 > 0 || mulOperation1 > 0)){
            throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)4");
        }
        if (mulOperation1 > 0 && mulOperation1 == mulOperation2 && (addOperation1 > 0 || subOperation1 > 0 || divOperation1 > 0)){
            throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)5");
        }
        if (input.contains("+") == true){
            String num1 = input.substring(0,input.lastIndexOf("+"));
            String num2 = input.substring((input.lastIndexOf("+") + 1), input.length());
            if (arabNum.containsKey(num1) && romNum.containsKey(num2) || romNum.containsKey(num1) && arabNum.containsKey(num2)){
                throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления1");
            }
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
            if (arabNum.containsKey(num1) && romNum.containsKey(num2) || romNum.containsKey(num1) && arabNum.containsKey(num2)){
                throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
            }
            if (arabNum.containsKey(num1) && arabNum.containsKey(num2)){
                int num1I = Integer.parseInt(num1);
                int num2I = Integer.parseInt(num2);
                System.out.println(num1I - num2I);
            }
            if (romNum.containsKey(num1) && romNum.containsKey(num2)){
                int num1I = romNum.get(num1);
                int num2I = romNum.get(num2);
                if (num2I>num1I){
                    throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");
                }
                else {
                    System.out.println(convertNumToRoman(num1I - num2I));
                }
            }
        }
        if (input.contains("/") == true){
            String num1 = input.substring(0,input.lastIndexOf("/"));
            String num2 = input.substring((input.lastIndexOf("/") + 1), input.length());
            if (arabNum.containsKey(num1) && romNum.containsKey(num2) || romNum.containsKey(num1) && arabNum.containsKey(num2)){
                throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
            }
            if (arabNum.containsKey(num1) && arabNum.containsKey(num2)){
                int num1I = Integer.parseInt(num1);
                int num2I = Integer.parseInt(num2);
                if (num2I == 0){
                    throw new Exception("throws Exception //т.к. на ноль делить нельзя");
                }
                else {
                    System.out.println((num1I / num2I));
                }
            }
            if (romNum.containsKey(num1) && romNum.containsKey(num2)){
                int num1I = romNum.get(num1);
                int num2I = romNum.get(num2);
                if (num2I == 0){
                    throw new Exception("throws Exception //т.к. на ноль делить нельзя");
                }
                else {
                    System.out.println(convertNumToRoman(num1I / num2I));
                }
            }

        }
        if (input.contains("*") == true){
            String num1 = input.substring(0,input.lastIndexOf("*"));
            String num2 = input.substring((input.lastIndexOf("*") + 1), input.length());
            if (arabNum.containsKey(num1) && romNum.containsKey(num2) || romNum.containsKey(num1) && arabNum.containsKey(num2)){
                throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
            }
            if (arabNum.containsKey(num1) && arabNum.containsKey(num2)){
                int num1I = Integer.parseInt(num1);
                int num2I = Integer.parseInt(num2);
                System.out.println(num1I * num2I);
            }
            if (romNum.containsKey(num1) && romNum.containsKey(num2)){
                int num1I = romNum.get(num1);
                int num2I = romNum.get(num2);
                if (num1I < 0 || num2I < 0){
                    throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");
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
