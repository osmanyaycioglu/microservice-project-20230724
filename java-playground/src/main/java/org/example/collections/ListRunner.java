package org.example.collections;

import java.util.ArrayList;
import java.util.List;

public class ListRunner {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("osman1");
        stringList.add("osman2");
        stringList.add("osman3");
        stringList.add("osman4");

        System.out.println(stringList.get(1));

        stringList.contains("osman4");


        System.out.println("------------------------");
        for (String s : stringList) {
            System.out.println(s);
        }

        stringList.remove(2);

    }
}
