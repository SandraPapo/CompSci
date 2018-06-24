package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sandrapapo on 2017-11-28.
 */
public class Hindex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        String[] input = inputString.replaceAll("\\s","").split(",");
        int[] citations = new int[input.length];
        for(int i = 0; i < citations.length; i++) {
            citations[i] = Integer.parseInt(input[i]);
        }



        int h_index = findIndex(citations,citations.length);
        System.out.println(h_index);



    }
    public static int findIndex(int[] citations, int h_index) {

        int overCount = 0;
        int underCount = 0;

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= h_index)//3
                ++overCount;
            if (citations[i] < h_index)//0
                ++underCount;
        }
        if(overCount >= h_index && underCount <= (citations.length - h_index))
            return h_index;
        else
            return findIndex(citations,h_index - 1);

    }
}
