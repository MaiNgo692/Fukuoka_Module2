package com.ra;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Nam");
        names.add("Nam");
        for (String item:names) {
            System.out.println(item);
        }
        Set<String> distinctNames = new HashSet<>();
        distinctNames.add("Mai");
        distinctNames.add("Mai");
        distinctNames.forEach(item -> System.out.println(item));

        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("A", 5);
        stringIntegerMap.put("A", 7);
        stringIntegerMap.put("B", 17);
        stringIntegerMap.keySet().forEach(key -> System.out.println("key: "+ stringIntegerMap.get(key)) );

        swap(5,7);
        GenericService<String> genericService = new GenericService<>();


    }

    public static <E> void swap(E a, E b){
        E temp = a;
        a = b;
        b = temp;
    }
}
