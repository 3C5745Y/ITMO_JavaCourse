package com.company;

public class SubUserAge extends UserAge {
    @Override
    public void getAge(){
        System.out.println("Как Вас зовут?");
        String name = in.nextLine();
        System.out.println("Ваше имя: "+ name);
    }
}
