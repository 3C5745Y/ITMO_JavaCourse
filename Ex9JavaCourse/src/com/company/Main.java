package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
//        SearchMaxValue search = new SearchMaxValue();
//        int[][] matrix = new int[4][100];
//        search.fillMatrix(matrix);
//        long start = System.currentTimeMillis();
//        int max = search.searchMaxValue(matrix, 4, 100);
//        long end = System.currentTimeMillis();
//        System.out.println("Max value is " + max);
//        System.out.println("Time for execution: " + (end - start));

        int [][] array1 = {{8, 13, 82, 38},
                        {56, 34, 55, 66},
                        {0, -12, 3000, 44},
                        {9999, 234, 55, 47}};

        for(int[] a:array1){
            System.out.println(Arrays.toString(a));
        }
        searchMaxValue(array1);
        checkSquareArrays(array1);
        searchMaxString(array1);
        randomCharFill(7,5);
    }

    public static void searchMaxValue(int[][] array1) throws ArrayIndexOutOfBoundsException{
        int maxVal = Integer.MIN_VALUE;
        for(int[] arr : array1){
            for(int i: arr){
                if (maxVal < i) {
                    maxVal=i;
                }
            }
        }
        System.out.println("Max value = " + maxVal);
    }

    public static void checkSquareArrays(int[][] array1) throws ArrayIndexOutOfBoundsException{
        boolean isSquare = true;
        for(int[] arr :array1){
            if(array1.length != arr.length){
                isSquare = false;
                System.out.println("Двумерный массив не является квадратным");
            }
        }System.out.println("Двумерный массив является квадратным");
    }

    public static void searchMaxString(int [][] array1) throws ArrayIndexOutOfBoundsException{
        int sum = 0;
        int stringArray = 0;
        for(int i=0; i<array1.length;i++){
            int total = 0;
            for(int j=0; j< array1[i].length; j++){
                total+= array1[i][j];
                if(total>sum){
                    sum=total;
                    stringArray=i+1;
                }
            }
        }
        System.out.printf("String with max sum: %d , sum = %d \n", stringArray, sum);
    }
    public static void randomCharFill(int a, int b){
        char[][] array1 = new char[a][b];
        for(int i=0; i<array1.length;i++){
            for(int j=0; j<array1[i].length;j++){
                array1[i][j] = (char)('A' + (Math.random()* 26));
            }
        }
        for(char[] arr:array1){
            System.out.println(Arrays.toString(arr));
        }
    }

}


