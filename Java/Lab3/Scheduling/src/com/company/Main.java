package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] tvShowOverlaps = new int[100];
        Scanner sc = new Scanner(System.in);
        int numShows = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < numShows; i++) {
            String[] startAndEndTimes = sc.nextLine().replaceAll("\\s","").split(",");
            int startTime = Integer.parseInt(startAndEndTimes[0]);
            int endTime = Integer.parseInt(startAndEndTimes[1]);
            for (int time = startTime; time <= endTime; time++) {
                if (tvShowOverlaps[time] < 2)
                    tvShowOverlaps[time]++;
                else {
                    System.out.println("No");
                    return;
                }

            }
        }
        System.out.println("Yes");
    }


}


