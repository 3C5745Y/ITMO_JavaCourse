package com.company;

import java.util.*;

public class SecondTask {
    public void collectNoDublicates(){
        Set<String> set= new HashSet<>();
        set.add("dddddddd");
        set.add("ttttttt");
        set.add("aaaaaaaa");
        set.add("aaaaaaaa");
        set.add("dddddddd");

        removeDuplicates(set);
        System.out.println(set);
    }

    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        return new HashSet<>(collection);
    }
}
