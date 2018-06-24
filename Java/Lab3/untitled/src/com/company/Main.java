package com.company;

import java.util.Scanner;

public class Main {

    public static void printAnswer(int input){
        int maxIndex = 0;

        int weights[] = new int[21];
        int output[] = new int[21];
        for(int i = 0; i<= 20; i++){
            weights[i] = (int)Math.pow(3,i);
        }

        for(int i = 20; i >= 0; i--){
            if(i > maxIndex && weights[i]<= input ){
                maxIndex = i;
            }
            while(weights[i]<= input){
                output[i]++;
                input -= weights[i];
            }
        }

        for (int i = maxIndex ; i >= 0; i --)
            System.out.print(output[i]+" ");
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int numberInputs = Integer.parseInt(sc.nextLine());
        int allInputs[] = new int[10000];
        for (int i = 0; i < numberInputs; i++) {
            allInputs[i] = Integer.parseInt(sc.nextLine());
        }

        for (int i = 0; i < numberInputs; i++) {
            printAnswer(allInputs[i]);
            System.out.println();

        }
    }

}
