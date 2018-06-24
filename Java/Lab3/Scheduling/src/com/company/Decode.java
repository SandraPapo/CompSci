package com.company;

import java.util.Scanner;

/**
 * Created by sandrapapo on 2017-11-28.
 */
public class Decode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int encoded = Integer.parseInt(input);

        System.out.print(decodeCount(encoded, 1));

    }


    public static int decodeCount(int encoded, int count) {
        //System.out.print(encoded + " ");
        if (encoded == 0){
            return count;
        }
        if(encoded % 100 <= 26 && (encoded % 100) >= 10) {
            //System.out.print("hi " + (encoded % 100));
            return decodeCount((int)Math.floorDiv(encoded,10), (count + 1));
        }
        else
            return decodeCount((int)Math.floorDiv(encoded,10), count);
        //return -1;
    }
}
