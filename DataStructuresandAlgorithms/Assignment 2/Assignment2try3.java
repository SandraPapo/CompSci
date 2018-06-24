// stack.java
// demonstrates stacks
// to run this program: C>java StackApp
////////////////////////////////////////////////////////////////

import java.io.*;

class StackX{
	private int maxSize; // size of stack array
	private char[] stackArray;
	private int top; // top of stack
	//--------------------------------------------------------------
	public StackX(int s){ // constructor
		maxSize = s; // set array size
		stackArray = new char[maxSize]; // create array
		top = -1; // no items yet
	}
	//--------------------------------------------------------------
	public void push(char j){ // put item on top of stack
		stackArray[++top] = j; // increment top, insert item
	}

	//--------------------------------------------------------------
	public char pop(){ // take item from top of stack
		return stackArray[top--]; // access item, decrement top
	}
	//--------------------------------------------------------------
	public char peek(){ // peek at top of stack
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
	public char peekN(int n){ // return item at index n
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
} // end class StackX
////////////////////////////////////////////////////////////////


class StackInt
{
private int maxSize;
private int[] stackArray;
private int top;
//--------------------------------------------------------------
public StackInt(int size) // constructor Stack<Integer>
{
maxSize = size;
stackArray = new int[maxSize];
top = -1;
}
//--------------------------------------------------------------
public void push(int j) // put item on top of stack
{ stackArray[++top] = j; }
//--------------------------------------------------------------
public int pop() // take item from top of stack
{ return stackArray[top--]; }
//--------------------------------------------------------------
public int peek() // peek at top of stack
{ return stackArray[top]; }
//--------------------------------------------------------------
public boolean isEmpty() // true if stack is empty
{ return (top == -1); }
//--------------------------------------------------------------
public boolean isFull() // true if stack is full
{ return (top == maxSize-1); }
//--------------------------------------------------------------
public int size() // return size
{ return top+1; }
//--------------------------------------------------------------
public int peekN(int n) // peek at index n
{ return stackArray[n]; }
//--------------------------------------------------------------
public void displayStack(String s)
{
System.out.print(s);
System.out.print("Stack (bottom-->top): ");
for(int j=0; j<size(); j++)
{
System.out.print( peekN(j) );
System.out.print(' ');
}
System.out.println("");
}
//--------------------------------------------------------------
} // end class StackX
////////////////////////////////////////////////////////////////


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
		for(int j=0; j<input.length(); j++){
			char ch = input.charAt(j);
			theStack.displayStack("For "+ch+" "); // *diagnostic*
			switch(ch){
				case '+': // it's + or -
				case '-':
					gotOper(ch, 1); // go pop operators
					break; // (precedence 1)
				case '*': // it's * or /
				case '/':
					gotOper(ch, 2); // go pop operators
					break; // (precedence 2)
				case '^': 
					gotOper(ch, 3);
					break;
				case '(': // it's a left paren
					theStack.push(ch); // push it
					break;
				case ')': // it's a right paren
					gotParen(ch); // go pop operators
					break;
				default: // must be an operand
					output = output + ch; // write it to output
					break;
			} // end switch
		} // end for
		while( !theStack.isEmpty() ){ // pop remaining opers
			theStack.displayStack("While "); // *diagnostic*
			output = output + theStack.pop(); // write to output
		}
		theStack.displayStack("End "); // *diagnostic*
		return output; // return postfix
	} // end doTrans()
	//--------------------------------------------------------------
	public void gotOper(char opThis, int prec1){ // got operator from input
		while( !theStack.isEmpty() ){
			char opTop = theStack.pop();
			if( opTop == '(' ){ // if it's a '('
				theStack.push(opTop); // restore '('
				break;
			}
			else{ // it's an operator
				int prec2; // precedence of new op
				if(opTop=='+' || opTop=='-') // find new op prec
					prec2 = 1;
				else
					prec2 = 2;
				if(prec2 < prec1){ // if prec of new op less
					 // than prec of old
					theStack.push(opTop); // save newly-popped op
					break;
				}
				else // prec of new not less
					output = output + opTop; // than prec of old
			} // end else (it's an operator)
		} // end while
		theStack.push(opThis); // push new operator
	} // end gotOp()
	//--------------------------------------------------------------
	public void gotParen(char ch){ // got right paren from input
		while( !theStack.isEmpty() ){
			char chx = theStack.pop();
			if( chx == '(' ) // if popped '('
				break; // we're done
			else // if popped operator
				output = output + chx; // output it
		} // end while
	} // end popOps()
	//--------------------------------------------------------------
} // end class InToPost
	////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////

class ParsePost{
	private StackInt theStack;
	private String input;
	//--------------------------------------------------------------
	public ParsePost(String s){ 
			input = s; 
	}
	//--------------------------------------------------------------
	public int doParse(){
		theStack = new StackInt(20); // make new stack
		char ch;
		int j;
		int num1, num2, interAns;
		for(j=0; j<input.length(); j++){ // for each char,
			ch = input.charAt(j); // read from input
			theStack.displayStack(""+ch+" "); // *diagnostic*
			if(ch >= '0' && ch <= '9') // if it's a number
				theStack.push( (int)(ch-'0') ); // push it
			else{ // it's an operator
				num2 = theStack.pop(); // pop operands
				num1 = theStack.pop();
				switch(ch){ // do arithmetic
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
						default:
						interAns = 0;
			} // end switch
			theStack.push(interAns); // push result
			} // end else
		} // end for
		interAns = theStack.pop(); // get answer
		return interAns;
	} // end doParse()
} // end class ParsePost



class Assignment2try3{
	
	public static String getString() throws IOException{
		InputStream inputStream = new FileInputStream("/Users/sandrapapo/Desktop/bullshit.txt");
		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();

		System.out.print(s);
		return s;
	}

	public static void main(String[] args) throws IOException{

		String input, output;
		int answer;
		
		InputStream inputStream = new FileInputStream("/Users/sandrapapo/Desktop/bullshit.txt");
		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(isr);
		

		while((input = br.readLine().replaceAll(" ","")) != null){
			System.out.print("Enter infix: ");
			System.out.flush();

			//input = getString().replaceAll(" ",""); // read a string from kbd
			if( input.equals("") ) // quit if [Enter]
				break;
			// make a translator
			InToPost theTrans = new InToPost(input);
			output = theTrans.doTrans(); // do the translation
			System.out.println("Postfix is " + output + '\n');
			ParsePost myAnswer = new ParsePost(output);
			

			try {
				answer = myAnswer.doParse();
    		}catch(Exception e){
    			System.out.println("Invalid Entry, Try again.");
    			break;
    		}

			System.out.println("The answer is " + answer + '\n');




		} // end while
	} // end main()
//--------------------------------------------------------------


} // end class StackApp
////////////////////////////////////////////////////////////////