/*
Sandra Papo
Cashier.java

October 15, 2017

Assignment 2
This is the answer to the fourth question.
*/



public class Cashier {
    int amountDue;
    int amountRecieved;

    public Cashier(){
        amountDue = 0;
        amountRecieved = 0;
    }

    public void setAmounts(int amountDue, int amountRecieved){
        this.amountDue = amountDue;
        this.amountRecieved = amountRecieved;

    }

    public void printChange(){
        int change = amountRecieved - amountDue;
        int dollarCount = 0, quarterCount = 0, dimeCount = 0 , nickelCount = 0, pennyCount = 0;
        
        while(change >= 100){
            change -= 100;
            dollarCount++;
        }
        
        while(change >= 25){
            change -= 25;
            quarterCount++;
        }
        
        while(change >= 10){
            change -= 10;
            dimeCount++;
        }

        while(change >= 5){
            change -= 5;
            nickelCount++;
        }

        while(change >= 1){
            change -= 1;
            pennyCount++;
        }

        System.out.println("The change is " + dollarCount + " dollars " + quarterCount + " quarters "+ dimeCount + " dimes " + nickelCount + " nickles and " +pennyCount +" pennys");
    }

    

    public static void main(String[] args){

        Cashier myChange = new Cashier();
        //test 1
        System.out.println("Expected:\n The change is 2 dollars 3 quarters 0 dimes 0 nickles an 1 pennys");
        myChange.setAmounts(100,376);
        System.out.println("Actual:");
        myChange.printChange();
        //test 2
        System.out.println("Expected:\n The change is 6 dollars 0 quarters 0 dimes 1 nickles an 0 pennys");
        myChange.setAmounts(150,755);
        System.out.println("Actual:");
        myChange.printChange();
        //test 3
        System.out.println("Expected:\n The change is 910 dollars 1 quarters 1 dimes 1 nickles an 1 pennys");
        myChange.setAmounts(9000,100041);
        System.out.println("Actual:");
        myChange.printChange();

    }
}
