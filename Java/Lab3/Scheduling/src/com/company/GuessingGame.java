package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sandrapapo on 2017-11-28.
 *
 *
 *
 *
 Input: secret "5123", guess "1235"
 Output: 0A4B
 Input: secret "5891310", guess "5987117"
 Output: 2A3B
 */
public class GuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String[] input = sc.nextLine().split("\"");
        //int secret = Integer.parseInt(input[1]);
        //int guess = Integer.parseInt(input[3]);
        int secret = 5123;
        int guess = 1235;

        //int[] secret = {5,8,9,1,3,1,0};
        //int[] guess = {5,9,8,7,1,1,7};
        int[] guessNums = new int[10];
        int[] secretNums = new int[10];
        int aCount = 0;
        int bCount = 0;
        //int minLength = Math.min(secret.length,guess.length);
        while (secret!= 0 || guess!=0){
            int currentSecretNum = secret / (secret / 10);
            int currentGuessNum = guess / (guess / 10);

            if(currentGuessNum == currentSecretNum) {
                aCount++;
            }
            else {
                secretNums[currentSecretNum]++;
                guessNums[currentGuessNum]++;
            }
            secret = secret/10;
            guess = guess/10;


        }

       /*
        for (int i = 0; i < minLength; i++){
            if(secret[i] == guess[i]) {
                aCount++;
            }
            else {
                secretNums[secret[i]]++;
                guessNums[guess[i]]++;
            }
        }*/
       // System.out.println(Arrays.toString(guessNums)+Arrays.toString(secretNums));
        for (int i = 0 ; i < guessNums.length; i++) {
            if (guessNums[i] == 0 && secretNums[i] == 0){
                continue;
            }
            else if (guessNums[i] > secretNums[i]){
                bCount += secretNums[i];
            }
            else {
                bCount += guessNums[i];
            }
        }
        System.out.println(aCount + "A" + bCount + "B");
    }

}
