package com.company;

public class Van extends Car{
    public int wheels;
    public int maxWeight;

    public void newWheels(){
        System.out.println("Количество колес:" + wheels);
    }

    public Van(int w, String m, String c, float s, int wheels, int maxWeight){
    super(w,m,c,s);
    this.wheels = wheels;
    this.maxWeight = maxWeight;
    }
}
