package com.company;

public class Airplane {

    public static class Wing{
        private int weight;

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public double getWeight() {
            return weight;
        }

        public void printWing(){
            System.out.println("Вес крыла: "+getWeight());
        }
    }
}
