/*
Sandra Papo
Microwave.java

October 15, 2017

Assignment 2
This is the answer to the second question.
*/


public class Microwave {

    private int time;
    private int level;


    public Microwave(){ 
        //initializing all variables
        time = 0;
        level = 1;//default level
    }

    public void start(){
        //button 1
        System.out.println("Cooking for "+ time + " seconds at level " + level);
        reset();
    }

    public void reset(){
        //button 2
        time = 0;
        level = 1;//default
    }

    public void increaseTime30secs(){
        //button 3
        time += 30;
    }

    public void switchPowerLevel(){
        //button 4
        if (level == 1) level = 2;
        else level = 1;
    }

    public static void main(String[] args){

        Microwave myMicrowave = new Microwave();

        System.out.println("Expected: Cooking for 90 seconds at level 2");
        System.out.print("Actual: ");
        myMicrowave.increaseTime30secs();
        myMicrowave.increaseTime30secs();
        myMicrowave.increaseTime30secs();
        myMicrowave.switchPowerLevel();
        myMicrowave.start();

        System.out.println("Expected: Cooking for 0 seconds at level 1");
        System.out.print("Actual: ");
        myMicrowave.start();


        System.out.println("Expected: Cooking for 120 seconds at level 1");
        System.out.print("Actual: ");
        myMicrowave.increaseTime30secs();
        myMicrowave.reset(); 
        myMicrowave.increaseTime30secs();       
        myMicrowave.increaseTime30secs();
        myMicrowave.increaseTime30secs();
        myMicrowave.increaseTime30secs();
        myMicrowave.switchPowerLevel();
        myMicrowave.switchPowerLevel();
        myMicrowave.start();
    }
}
