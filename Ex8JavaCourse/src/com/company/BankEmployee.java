package com.company;

public class BankEmployee extends Person implements Stateable{
    public String bankName;

    @Override
    public void printInfo(){
        System.out.printf("Employee Name: %s \t Employee Lastname: %s \t Bank: %s \n", super.getName(),super.getLastname(), bankName);
    }
    BankEmployee(String b, String n, String l){
        super(n,l );
        this.bankName = b;
    }

    public void printState(int n){
        if(n==ACTIVE)
            System.out.println("Active");
        else if(n==NOTACTIVE)
            System.out.println("Not active");
        else
            System.out.println("State is invalid");
    }
}
