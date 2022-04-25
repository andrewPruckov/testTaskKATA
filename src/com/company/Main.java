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
            String num2;
        }
    }
}
