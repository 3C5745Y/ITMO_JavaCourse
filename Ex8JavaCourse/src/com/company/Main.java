package com.company;

public class Main {

    public static void main(String[] args) {
        Client client = new Client("Sberbank", "Anna", "Dovydova");
        client.printInfo();
        client.printState(1);

        BankEmployee emp = new BankEmployee("Uralsib", "Ivan", "Ivanov");
        emp.printInfo();
        emp.printState(0);
    }
}
