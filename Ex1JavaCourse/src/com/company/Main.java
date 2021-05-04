package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // задание 1
        System.out.println("Я");
        System.out.println("хорошо");
        System.out.println("знаю");
        System.out.println("Java");

        // задание 2
        double result = (46 + 10) * (10 / 3);
        System.out.print(result);

        double result1 = (29) * (4) * (-15);
        System.out.print(result1);

        // задание 3
        int number = 10500;
        int result = (number / 10) / 10;
        System.out.print(result);

        // задание 4
        double a = 3.6;
        double b = 4.1;
        double c = 5.9;
        double result = a*b*c;
        System.out.print(result);

        // задание 5
        System.out.print("Введите первое число: ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        System.out.print("Введите второе число: ");
        Scanner input1 = new Scanner(System.in);
        int num1 = input1.nextInt();

        System.out.print("Введите третье число: ");
        Scanner input2 = new Scanner(System.in);
        int num2 = input2.nextInt();

        System.out.println(num);
        System.out.println(num1);
        System.out.println(num2);

        // задание 6
        System.out.print("Введите любое целое число от 1 до 100: ");
        Scanner input = new Scanner(System.in);
        int b = input.nextInt();
        if (b % 2 != 0) {
            System.out.println("Число нечетное");
        } else if (b % 2 == 0 && b > 100) {
            System.out.println("Выход за пределы диапазона");
        } else {
            System.out.println("Число четное");
        }
    }
}
