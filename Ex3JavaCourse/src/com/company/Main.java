package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] arr = { 0,1,2,3,4,5,6,7,8,9,10 };
        String str = isSorted(arr, arr.length) ? "Ok" : "Please, try again";
        System.out.println(str);

         createUserArray();

        int[] a = {1,5,7,4,2};
        System.out.println("Array1: "+Arrays.toString(a));
        swapFirstAndLast(a);
        System.out.println("Array2: "+Arrays.toString(a));

        int arr1[] = { 10, 4, 10, 3, 7, 4 };
        int n = arr1.length;
        System.out.println(firstUniqueElem(arr1, n));

        nFibonacciNum(4);

        Main app = new Main();
        int[] input = app.generateRandomNumbers(7);
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(app.mergeSort(input)));
    }

        public static boolean isSorted ( int[] a, int index){
            if (a == null || a.length <= 1 || index == 1) {
                return true;
            }

            if (a[index - 1] < a[index - 2]) {
                return false;
            }

            return isSorted(a, index - 1);
        }

        public static void createUserArray () {
            Scanner in = new Scanner(System.in);
            System.out.print("Array length: ");
            int num = in.nextInt();

            int[] userArr = new int[num];
            System.out.println("Numbers of array:");
            for (int i = 0; i < num; i++) {
                userArr[i] = in.nextInt();
            }
            in.close();

            System.out.println("Result: " + Arrays.toString(userArr));
        }

        public static void swapFirstAndLast ( int[] arr){
            if (arr != null || arr.length > 1) {
                int tmp = arr[0];
                arr[0] = arr[arr.length - 1];
                arr[arr.length - 1] = tmp;
            }
        }

        public static int firstUniqueElem ( int arr[], int n){
            for (int i = 0; i < n; i++) {
                int j;
                for (j = 0; j < n; j++)
                    if (i != j && arr[i] == arr[j])
                        break;
                if (j == n)
                    return arr[i];
            }
            return -1;
        }

        public static void nFibonacciNum (int n){
            int a = 0;
            int b = 1;
            for (int i = 2; i <= n; ++i) {
                int next = a + b;
                a = b;
                b = next;
            }
            System.out.println(b);
        }

    private int[] mergeSort(int[] input){

        if(input.length == 1){
            return input;
        }

        int middle = (int) Math.ceil((double)input.length / 2);
        int[] left = new int[middle];

        int rightLength;
        if(input.length % 2 == 0){
            rightLength = middle;
        }
        else{
            rightLength = middle - 1;
        }
        int[] right = new int[rightLength];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < input.length; i++) {
            if(i < middle){
                left[leftIndex] = input[i];
                leftIndex++;
            }
            else{
                right[rightIndex] = input[i];
                rightIndex++;
            }
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while(leftIndex < left.length || rightIndex < right.length){
            if(leftIndex < left.length && rightIndex < right.length){
                if(left[leftIndex] < right[rightIndex]){
                    result[resultIndex] = left[leftIndex];
                    leftIndex++;
                    resultIndex++;
                }
                else{
                    result[resultIndex] = right[rightIndex];
                    rightIndex++;
                    resultIndex++;
                }
            }
            else if(leftIndex < left.length){
                for (int i = resultIndex; i < result.length; i++) {
                    result[i] = left[leftIndex];
                    leftIndex++;
                }
            }
            else if(rightIndex < right.length){
                for (int i = resultIndex; i < result.length; i++) {
                    result[i] = right[rightIndex];
                    rightIndex++;
                }
            }
        }

        return result;
    }

   private int[] generateRandomNumbers(int n){

        int[] result = new int[n];
        Random random = new Random();

        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(n * 10);
        }

        return result;
    }

}



