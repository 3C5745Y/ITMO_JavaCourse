package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        oddNumbers();
        divided();
        sumOfTwoIsThird();
        compareUserNumbers();
        checkFirstLastAreThird();
        hasOneOrThree();
    }

    public static void oddNumbers(){
        for (int i = 1; i <= 99; i++) {
            if (i % 2 != 0)
                System.out.println(i);
        }
    }

    public static void divided(){
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        for (int j = 1; j <= 100;j++) {
            if (j % 3 == 0){
                list1.add(Integer.toString(j));
            }
            if (j % 5 == 0) {
                list2.add(Integer.toString(j));
            }
            if (j % 3 == 0 && j % 5 == 0) {
                list3.add(Integer.toString(j));
            }
        }

        System.out.print("\nДелится на 3: " + String.join(", ", list1));
        System.out.print("\nДелится на 5: " + String.join(", ", list2));
        System.out.print("\nДелится на 3 и на 5: " + String.join(", ", list3));
        System.out.println("\n");
    }

    public static void sumOfTwoIsThird(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое число:");
        int x = sc.nextInt();
        System.out.print("Введите второе число:");
        int y = sc.nextInt();
        System.out.print("Введите третье число:");
        int z = sc.nextInt();

        System.out.print("Результат: "+sum(x, y, z));
        System.out.print("\n");
    }

    public static void compareUserNumbers(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите первое число : ");
        int a = in.nextInt();
        System.out.print("Введите второе число: ");
        int b = in.nextInt();
        System.out.print("Введите третье число : ");
        int c = in.nextInt();
        System.out.print("Результат: "+compare(a, b, c,true));
        System.out.print("\n");
    }

    public static boolean sum (int p, int q, int r)
    {
        return ((p + q) == r || (q + r) == p || (r + p) == q);
    }

    public static boolean compare(int p, int q, int r, boolean abc)
    {
        if(abc)
            return (r > q);
        return (q > p && r > q);
    }

    public static void checkFirstLastAreThird(){
        Scanner in = new Scanner(System.in);
        int array[] = new int[10];
        System.out.println("Введите десять чисел: ");
        for(int i = 0; i < array.length; i++){
            array[i] = in.nextInt();
        }

        if(array[0]==3 || array[array.length-1] == 3){
            System.out.println("true");
        }
        else
            System.out.println("false");
    }

    public static void hasOneOrThree(){
        Scanner in = new Scanner(System.in);
        int array[] = new int[8];
        System.out.println("Введите восемь чисел для массива: ");
        for(int i = 0; i < array.length; i++){
            array[i] = in.nextInt();
        }
        if(contains(array, 1) || contains(array, 3) ) {
            System.out.println("Массив содержит число 1 или 3");
        }
        else{
            System.out.println("Массив не содержит число 1 или 3");
        }
    }
    public static boolean contains(int[] arr, int item) {
        for (int n : arr) {
            if (item == n) {
                return true;
            }
        }
        return false;
    }
}
