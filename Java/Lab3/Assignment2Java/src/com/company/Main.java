

import java.io.*;
import java.util.*;

class StackX{
    private int maxSize; // size of stack array
    private String[] stackArray;
    private int top; // top of stack

    //--------------------------------------------------------------
    public StackX(int s){ // constructor
        maxSize = s; // set array size
        stackArray = new String[maxSize]; // create array
        top = -1; // no items yet
    }
    //--------------------------------------------------------------
    public void push(String j){ // put item on top of stack
        stackArray[++top] = j; // increment top, insert item
    }

    //--------------------------------------------------------------
    public String pop(){ // take item from top of stack
        return stackArray[top--]; // access item, decrement top
    }
    //--------------------------------------------------------------
    public String peek(){ // peek at top of stack
        return stackArray[top];
    }
    //--------------------------------------------------------------
    public boolean isEmpty() // true if stack is empty
    {
        return (top == -1);
    }
    //--------------------------------------------------------------
    public boolean isFull(){ // true if stack is full
        return (top == maxSize-1);
    }

    public int size(){ // return size
        return top+1;
    }

    //--------------------------------------------------------------
    public String peekN(int n){ // return item at index n
        return stackArray[n];
    }
    //--------------------------------------------------------------
    public void displayStack(String s){
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for(int j=0; j<size(); j++){
            System.out.print( peekN(j) );
            System.out.print(' ');
        }
        System.out.println("");
    }
//--------------------------------------------------------------
}

class InToPost{ // infix to postfix conversion
    private StackX theStack;
    private String input;
    private String output = "";
    //--------------------------------------------------------------
    public InToPost(String in){ // constructor
        input = in;
        int stackSize = input.length();
        theStack = new StackX(stackSize);
    }
    //--------------------------------------------------------------

    public String doTrans(){ // do translation to postfix
        String[] splitted = input.split(" ");
        System.out.println(Arrays.toString(splitted));
        for(int j=0; j<splitted.length; j++){
            theStack.displayStack("For "+splitted[j]+" "); // *diagnostic*
            System.out.println(splitted[j]);
            switch(splitted[j]){
                case "+": // it's + or -
                case "-":
                    gotOper(splitted[j], 1); // go pop operators
                    break; // (precedence 1)
                case "*": // it's * or /
                case "/":
                    gotOper(splitted[j], 2); // go pop operators
                    break; // (precedence 2)
                case "(": // it's a left paren
                    theStack.push(splitted[j]); // push it
                    break;
                case ")": // it's a right paren
                    gotParen(splitted[j]); // go pop operators
                    break;
                default: // must be an operand
                    output = output  + splitted[j]+ " "; // write it to output
                    break;
            } // end switch
        } // end for
        while( !theStack.isEmpty() ){ // pop remaining opers
            theStack.displayStack("While "); // *diagnostic*
            output = output + theStack.pop();; // write to output
        }
        theStack.displayStack("End "); // *diagnostic*
        return output; // return postfix
    } // end doTrans()
    //--------------------------------------------------------------
    public void gotOper(String opThis, int prec1){ // got operator from input
        while( !theStack.isEmpty() ){
            String opTop = theStack.pop();
            if( opTop == "(" ){ // if it's a '('
                theStack.push(opTop); // restore '('
                break;
            }
            else{ // it's an operator
                int prec2; // precedence of new op
                if(opTop=="+" || opTop=="-") // find new op prec
                    prec2 = 1;
                else
                    prec2 = 2;
                if(prec2 < prec1){ // if prec of new op less
                    // than prec of old
                    theStack.push(opTop); // save newly-popped op
                    break;
                }
                else // prec of new not less
                    output = output + opTop + " "; // than prec of old
            } // end else (it's an operator)
        } // end while
        theStack.push(opThis); // push new operator
    } // end gotOp()
    //--------------------------------------------------------------
    public void gotParen(String ch){ // got right paren from input
        while( !theStack.isEmpty() ){
            String chx = theStack.pop();
            if( chx == "(" ) // if popped '('
                break; // we're don
            else // if popped operator
                output = output + chx; // output it
        } // end while
    } // end popOps()
    //--------------------------------------------------------------
} // end class InToPost

class ParsePost{
    private StackX theStack;
    private String input;
    //--------------------------------------------------------------
    public ParsePost(String s){
        input = s;
    }
    //--------------------------------------------------------------
    public int doParse(){
        theStack = new StackX(20); // make new stack
        String ch;
        int j;
        int num1, num2, interAns;
        String[] splitted = input.split(" ");

        for(j=0; j<splitted.length; j++){ // for each char,
            ch = splitted[j]; // read from input
            theStack.displayStack(""+ch+" "); // *diagnostic*
            if(!(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/") || ch.equals("^") )) // if it's a number
                theStack.push( ch ); // push it
            else{ // it's an operator
                num2 = Integer.parseInt(theStack.pop()); // pop operands
                num1 = Integer.parseInt(theStack.pop());
                switch(ch){ // do arithmetic
                    case "+":
                        interAns = num1 + num2;
                        break;
                    case "-":
                        interAns = num1 - num2;
                        break;
                    case "*":
                        interAns = num1 * num2;
                        break;
                    case "/":
                        interAns = num1 / num2;
                        break;
                    case "^":
                        interAns = (int)Math.pow((double)num1, (double)num2);
                        break;
                    default:
                        interAns = 0;
                } // end switch
                theStack.push(Integer.toString(interAns)); // push result
            } // end else
        } // end for
        interAns = Integer.parseInt(theStack.pop()); // get answer
        return interAns;
    } // end doParse()
} // end class ParsePost


public class Ass2 {

    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static void main(String[] args) throws IOException{

        String input, output;
        int answer;
        while(true){
            System.out.print("Enter infix: ");
            System.out.flush();
            input = getString(); // read a string from kbd
            if( input.equals("") ) // quit if [Enter]
                break;
            // make a translator
            InToPost theTrans = new InToPost(input);
            output = theTrans.doTrans(); // do the translation
            System.out.println("Postfix is " + output + '\n');
            ParsePost myAnswer = new ParsePost(output);

            answer = myAnswer.doParse();



            System.out.println("The answer is " + answer + '\n');


        }
    }




import java.util.Scanner;

    public class Activity1{
        public static void main(String[] args){
            Scanner myScanner = new Scanner(System.in);

            String word = myScanner.nextLine();

            String wordReversed = "";

            for(int i = 0; i < word.length(); i++){
                wordReversed += word.charAt((word.length() - 1 ) - i);
            }

            System.out.println(wordReversed);

            if(word.equals(wordReversed))
                System.out.println("It is a palindrome");
            else
                System.out.println("It is not a palindrome");
        }
    }


    public static int[] matchCheck(int [] a, int [] b){
        int length = a.length;
        int[] add = new int[length];
        for(int i = 0; i < length; i++){
            add[i] = a[i] + b[i];
        }
        return add;
    }