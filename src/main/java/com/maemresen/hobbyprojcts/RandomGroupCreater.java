package com.maemresen.hobbyprojcts;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomGroupCreater {

    public static void main(String[] args) {

        Map<String, Boolean> people = new HashMap<String, Boolean>();

        String[] ourClass = {
                "Brian Sanderson"
                , "Luci Pickett"
                , "Kadeem Byrd"
                , "Rodrigo Mcclure"
                , "Dawood Daniel"
                , "Abubakr Harrison"
                , "Henrietta Kelley"
                , "Aaliyah Savage"
                , "Ernest Reeves"
                , "Bruno Galvan"
        };
        for (int i = 0; i < ourClass.length; i++) {
            people.put(ourClass[i], false);
        }

        String[] four = new String[4];
        String[] three = new String[3];
        String[] three2 = new String[3];
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            int r = rand.nextInt(ourClass.length);

            while (people.get(ourClass[r])) {
                r = rand.nextInt(ourClass.length);
            }
            people.put(ourClass[r], true);
            four[i] = ourClass[r];
        }

        for (int i = 0; i < 3; i++) {
            int r = rand.nextInt(ourClass.length);

            while (people.get(ourClass[r])) {
                r = rand.nextInt(ourClass.length);
            }
            people.put(ourClass[r], true);
            three[i] = ourClass[r];
        }

        for (int i = 0; i < 3; i++) {
            int r = rand.nextInt(ourClass.length);

            while (people.get(ourClass[r])) {
                r = rand.nextInt(ourClass.length);
            }
            people.put(ourClass[r], true);
            three2[i] = ourClass[r];
        }

        System.out.println("First Group");
        System.out.println("-------------------");
        for (int i = 0; i < 4; i++) {
            System.out.println(four[i]);
        }
        System.out.println("");
        System.out.println("Second Group");
        System.out.println("-------------------");
        for (int i = 0; i < 3; i++) {
            System.out.println(three[i]);
        }
        System.out.println("");
        System.out.println("Third Group");
        System.out.println("-------------------");
        for (int i = 0; i < 3; i++) {
            System.out.println(three2[i]);
        }
    }

}
