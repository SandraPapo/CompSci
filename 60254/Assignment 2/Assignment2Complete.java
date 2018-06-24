
/*
Name: Sandra Papo
SN: 104213584
Date: October 18th 2018

Code for assignment 2

*/

import java.io.*;
import java.util.*;

class StackX{
	private int maxSize; // size of stack array
	private String[] stackArray;
	private int top; // top of stack

	public StackX(int s){ // constructor
		maxSize = s; // set array size
		stackArray = new String[maxSize]; // create array
		top = -1; // no items yet
	}

	public void push(String j){ // put item on top of stack
		stackArray[++top] = j; // increment top, insert item
	}

	public String pop(){ // take item from top of stack
		return stackArray[top--]; // access item, decrement top
	}
	public String peek(){ // peek at top of stack
		return stackArray[top];
	}
	public boolean isEmpty(){ // true if stack is empt
		return (top == -1);
	}
	public boolean isFull(){ // true if stack is full
		return (top == maxSize-1);
	}

	public int size(){ // return size
		return top+1; 
	}

	public String peekN(int n){ // return item at index n
	 	return stackArray[n]; 
	}

	public void displayStack(String s){
		System.out.print(s);
		System.out.print("Stack (bottom-->top): ");
		for(int j=0; j<size(); j++){
			System.out.print( peekN(j) );
			System.out.print(' ');
		}
		System.out.println("");
	}
}



class InToPost{ // infix to postfix conversion
	private StackX theStack;
	private String input;
	private String output = "";

	public InToPost(String in){ // constructor
		input = in;
		int stackSize = input.length();
		theStack = new StackX(stackSize);
	}


	public boolean validateInfix(){
		String splitted[] = input.split("\\s+");
		int bracketCount = 0;
		int oldOperatorIndex = -1; 
		int newOperatorIndex = -1;

		for(int i=0; i<splitted.length; i++){
			if (splitted[i].equals("("))
				bracketCount++;
			if (splitted[i].equals(")"))
				bracketCount--;
			
			if (splitted[i].equals("+") || splitted[i].equals("-") || splitted[i].equals("*") || splitted[i].equals("/") || splitted[i].equals("^"))
			{
				oldOperatorIndex = newOperatorIndex;
				newOperatorIndex = i;
				if (Math.abs(oldOperatorIndex - newOperatorIndex) <=1){
					System.out.println("INVALID: operators next to each other\n");
					return false;
				}
			}
		}
		if(bracketCount == 0)
			return true;
		else{
			System.out.println("INVALID: brackets unequal\n");
			return false;
		}
	}

	public String doTrans(){ // do translation to postfix
			String splitted[] = input.split("\\s+");
			for(int j=0; j<splitted.length; j++){
				String ch = splitted[j];
				theStack.displayStack("For "+ch+" "); // *diagnostic*
				switch(ch.charAt(0)){
					case '+': // it's + or -
					case '-':
						if (ch.length() > 1){
							output = output + ch + " ";
							break;
						}
						gotOper(ch, 1); // go pop operators
						break; // (precedence 1)
					case '*': // it's * or /
					case '/':
						gotOper(ch, 2); // go pop operators
						break; // (precedence 2)
					case '^':
						gotOper(ch, 3); // go pop operators
						break; // (precedence 2)
					case '(': // it's a left paren
						theStack.push(ch); // push it
						break;
					case ')': // it's a right paren
						gotParen(ch); // go pop operators
						break;
					default: // must be an operand
						output = output + ch + " "; // write it to output
						break;
				} // end switch
			} // end for
			while( !theStack.isEmpty() ){ // pop remaining opers
				theStack.displayStack("While "); // *diagnostic*
				output = output + theStack.pop() + " "; // write to output
			}
			theStack.displayStack("End "); // *diagnostic*
			return output; // return postfix
		} // end doTrans()
		//--------------------------------------------------------------
		public void gotOper(String opThis, int prec1){ // got operator from input
			while( !theStack.isEmpty() ){
				String opTop = theStack.pop();
				if( opTop.charAt(0) == '(' ){ // if it's a '('
					theStack.push(opTop); // restore '('
					break;
				}
				else{ // it's an operator
					int prec2; // precedence of new op
					if(opTop.charAt(0)=='+' || opTop.charAt(0)=='-') // find new op prec
						prec2 = 1;
					else if (opTop.charAt(0)=='*' || opTop.charAt(0)=='/')
						prec2 = 2;
					else
						prec2 = 3;
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

		public void gotParen(String ch){ // got right paren from input
			while( !theStack.isEmpty() ){
				String chx = theStack.pop();
				if( chx.charAt(0) == '(' ) // if popped '('
					break; // we're done
				else // if popped operator
					output = output + chx + " "; // output it
			} // end while
		} // end popOps()
} // end class InToPost

class ParsePost{
	private StackX theStack;
	private String input;

	public ParsePost(String s){ 
			input = s; 
	}

	public int doParse(){
		theStack = new StackX(20); // make new stack
		String ch;
		int j;
		int num1, num2, interAns;
		String[] splitted = input.split("\\s+");

		for(j=0; j<splitted.length; j++){ // for each char,
			ch = splitted[j]; // read from input
			theStack.displayStack(""+ch+" "); // *diagnostic*
			if(!(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/") || ch.equals("^") )) // if it's a number
				theStack.push( ch ); // push it
			else{ // it's an operator
				num2 = Integer.parseInt(theStack.pop()); // pop operands
				num1 = Integer.parseInt(theStack.pop());
				switch(ch.charAt(0)){ // do arithmetic
					case '+':
						interAns = num1 + num2;
						break;
					case '-':
						interAns = num1 - num2;
						break;
					case '*':
						interAns = num1 * num2;
						break;
					case '/':
						interAns = num1 / num2;
						break;
					case '^':
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


public class Assignment2Complete {



	public static void main(String[] args) throws IOException{
		InputStream inputStream = new FileInputStream("/Users/sandrapapo/Desktop/file.txt");
		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(isr);


		String input = br.readLine(), output;
		int answer;
		while(input != null){
			System.out.println("Enter infix: " + input);
			System.out.flush();
			// make a translator
			InToPost theTrans = new InToPost(input);
			if (theTrans.validateInfix() == false){
				input = br.readLine();
				continue;
			}
			output = theTrans.doTrans(); // do the translation
			System.out.println("Postfix is " + output + '\n');
			ParsePost myAnswer = new ParsePost(output);
			try{  
				answer = myAnswer.doParse(); 
				System.out.println("The answer is " + answer + '\n');
			}catch(Exception e){
				System.out.println("Invalid entry, try again!\n");
			}  
			input = br.readLine();

		}
}




}