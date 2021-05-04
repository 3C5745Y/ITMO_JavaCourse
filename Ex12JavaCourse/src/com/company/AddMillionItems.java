package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AddMillionItems {

    int numberOfElements=100000;
    ArrayList intListAr = new ArrayList();
    List intlistLL = new LinkedList();
    void addAR() {

        for (int i = 0; i < 1000000; i++)
            intListAr.add(intListAr.size(), 100000);
        Collections.shuffle(intListAr);
        if (intListAr.size() > numberOfElements) {
            intListAr.subList(intListAr.size() - numberOfElements, intListAr.size());
        }

    }
    void addLL() {

        for (int i = 0; i < 1000000; i++)
            intlistLL.add(intlistLL.size(), 100000);
        Collections.shuffle(intlistLL);
        if (intlistLL.size() > numberOfElements) {
            intlistLL.subList(intListAr.size() - numberOfElements, intlistLL.size());
        }
    }
    void info() {
        System.out.println(intListAr.size() + " " + intlistLL.size());
    }

}
