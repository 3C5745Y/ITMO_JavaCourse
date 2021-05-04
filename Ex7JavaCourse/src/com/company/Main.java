package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1:");
        Van van = new Van(5000,"Gazel", "white", 70f, 4,6000);
        van.outPut();
        van.newWheels();

        System.out.println("Задание 2:");
        SubAddInteger number = new SubAddInteger();
        number.setNumber(4);
        number.printNumber();

        System.out.println("Задание 3:");
        SubUserAge name = new SubUserAge();
        name.getAge();

        System.out.println("Задание 4 и 5:");
        Airplane.Wing wing1 = new Airplane.Wing();
        wing1.setWeight(4566);
        wing1.printWing();

        Airplane.Wing wing2 = new Airplane.Wing();
        wing2.setWeight(2345);
        wing2.printWing();

    }
}
