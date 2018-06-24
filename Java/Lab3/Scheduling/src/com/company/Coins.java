package com.company;


public class Coins {

    public static void main(String[] args) {
        int[] coins = {1, 2, 10, 25};
        int total = 100;
        int[] numEachCoin = new int[coins.length];
        int currentTotal = 0;
       numEachCoin = getCoins(numEachCoin,coins,total, currentTotal, coins.length -1);
        if (numEachCoin[0] == -1){
            System.out.println("-1");
            return;
        }
        int totalCoins = 0;
        for (int i = 0; i < numEachCoin.length; i++)
            totalCoins += numEachCoin[i];
        System.out.print(totalCoins + " : ");
        for (int i = 0; i < coins.length; i++) {
            while (numEachCoin[i] > 0){
                System.out.print(coins[i] + ",");
                numEachCoin[i]--;
            }

        }


    }

    public static int[] getCoins(int[] numEachCoin, int[] coins, int total, int currentTotal, int currentCoin) {

        if(currentTotal == total || currentCoin < 0){
            if(total != currentTotal){
                numEachCoin[0] = -1;
                return numEachCoin;
            }
            return numEachCoin;
        }


        for (int i = 0; i < 3; i++) {
            if ((total-currentTotal) < coins[currentCoin])
                break;
            numEachCoin[currentCoin]++;
            currentTotal+= coins[currentCoin];

        }

        return getCoins(numEachCoin, coins, total, currentTotal, currentCoin-1);

    }

}

