package com.company;

import java.util.Scanner;

public class UserAge {
    Scanner in = new Scanner(System.in);

    public void getAge(){
        System.out.println("Сколько Вам лет?");
        int age = in.nextInt();
        System.out.println("Ваш возраст: "+age);
    }
}
