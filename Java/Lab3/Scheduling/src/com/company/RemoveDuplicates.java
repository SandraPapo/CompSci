package com.company;

import java.util.Scanner;

/**
 * Created by sandrapapo on 2017-11-28.
 */
public class RemoveDuplicates {
    int[] array;
    int size;
    public RemoveDuplicates(int[] inputArray) {
        size = inputArray.length;
        array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = inputArray[i];
        }
    }

    public void removeAllDuplicatesSorted() {
        int cycles = size;
        for (int i = 0; i < cycles - 2; i++) {
            if (array[i] == array[i+2])
                removeElement(i);
        }
        System.out.println(cycles);
    }



    public void removeElement(int index){
        if (index == size - 1){
            size--;
            return;
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size = size - 1;
    }

    public void printArray () {
        for (int i = 0; i < size; i++)
            System.out.print(array[i] + " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        String[] input = inputString.replaceAll("\\s","").split(",");
        int[] inputArray = new int[input.length];
        for(int i = 0; i < inputArray.length; i++) {
            inputArray[i] = Integer.parseInt(input[i]);
        }
        RemoveDuplicates myArray = new RemoveDuplicates(inputArray);
        myArray.removeAllDuplicatesSorted();
        myArray.printArray();
    }
}
