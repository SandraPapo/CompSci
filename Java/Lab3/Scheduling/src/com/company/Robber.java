package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sandrapapo on 2017-11-29.
 */
public class Robber {

    public static void main(String[] args) {
         int[] houses = {30, 50, 40, 50};
         int[] ordered = new int[houses.length];
         ordered = order(houses.clone(), ordered, 0);
         System.out.println(robbed(houses, ordered, 0, 0));

    }

    public static ArrayList robbed(int[] houses, int[] ordered, int total, int startHouse) {
        ArrayList<Integer> rob = new ArrayList<>();
        rob.add(startHouse);
        total += houses[ordered[startHouse]];

        int[] indexOrdered = new int[houses.length];
        for (int i = 0; i < ordered.length; i++) {
            if (rob.contains(i) || rob.contains((ordered[i] + 1)% ordered.length) || rob.contains((ordered[i] - 1 + ordered.length)% ordered.length)) {
                continue;
            }
            else {
                total += houses[ordered[i]];
                rob.add(ordered[i]);
            }
        }
        return  robbed(houses, ordered,0, startHouse + 1);
        System.out.println(total);
        return rob;
    }

    public static int[] order(int[] houses,int[] ordered, int orderedIndex) {
        if (orderedIndex > houses.length -1)
            return ordered;
        else{
            int max = houses[0];
            int index = 0;
            for (int i = 0; i < houses.length; i++) {
                if (houses[i] > max) {
                    index = i;
                    max = houses[i];
                }
            }
            houses[index] = -1;
            ordered[orderedIndex] = index;
            return order(houses,ordered, orderedIndex + 1);
        }

    }

}
