package com.company;

public class Car {
    public int weight;
    public String model;
    public String color;
    public float speed;

    public void outPut () {
        System.out.println("Вес " + model + " составляет " + weight + "кг.");
        System.out.println("Цвет машины - " + color + " и её скорость - " + speed);
    }

    public Car (int w, String m, String c, float s) {
        weight = w;
        model = m;
        color = c;
        speed = s;
    }

    public Car () {}

}
