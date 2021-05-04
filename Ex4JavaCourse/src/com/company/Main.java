package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        firstTask();
        secondTask();
        thirdTask();
        fourthTask();
        fifthTask();

    }

    public static void firstTask(){
        String [] words = { "The", "early", "bird", "catches", "the", "worm" };
         String longestString = findLongestString(words);

         for(int i=0; i<words.length;i++){
             System.out.println(words[i]);
        }
        System.out.format("Longest string: '%s'\n", longestString);
    }

    public static String findLongestString(String[] array) {
        int size = 0;
        String longestString = null;
        for (String s : array) {
            if (s.length() > size) {
                size = s.length();
                longestString = s;
            }
        }
        return longestString;
    }
    public static void secondTask(){
        System.out.print("Enter any word: ");
        Scanner in = new Scanner(System.in);
        String userWord = in.nextLine();
        String reverseWord = new StringBuilder(userWord).reverse().toString();

        if (userWord.equals(reverseWord)) {
            System.out.println("Word is a palindrome.");
        }
        else {
            System.out.println("Word is not a palindrome.");
        }
    }
    public static void thirdTask(){
        StringBuilder sb = new StringBuilder("Это какая-то бяка и там лежит бяка");
        System.out.println("Original string: "+sb);
        System.out.println(replaceAll(sb, "бяка", "[вырезано цензурой]"));


    }
    public static StringBuilder replaceAll(StringBuilder sb, String find, String replace){
        return new StringBuilder(Pattern.compile(find).matcher(sb).replaceAll(replace));
    }

    public static void fourthTask(){
        String str = "dd name is Olga bla bla bla name is name!";
        String strSearch = "name is";
        int count = str.split(strSearch, -1).length - 1;
        //int count2 = (str.length() - str.replace(strSearch, "").length()) / strSearch.length();

        System.out.println(count);
        //System.out.println(count2);
    }

    public static void fifthTask(){
        String input = "Home sweet home";
        StringBuilder input1 = new StringBuilder();
        input1.append(input);
        input1.reverse();
        System.out.println(input1.toString());
    }
}
