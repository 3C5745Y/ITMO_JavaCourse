package com.company;

import java.util.Scanner;

public abstract class Person {
    public String name;
    public String lastname;

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }


    public abstract void printInfo();

   public Person(String n, String l){
        this.name = n;
        this.lastname = l;
   }

}
