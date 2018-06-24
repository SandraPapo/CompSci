
//Stack with array based implementation
class StackArray{
	int top, MaxStack;
	int[] elements;

	public StackArray(){
		MaxStack = 100;
		elements = new int[MaxStack];
	}
	public void initiateStack(){
		top = 0;
	}

	public void push(int element){
		elements[top] = element;
		top++;
	}
	public void pop(){
		top--;
	}

	public boolean isEmptyStack(){
		if(top == 0)
			return true;
		else 
			return false;
	}

	public void deleteStack(){
		top = 0;
	}

	public int stackSize(){
		return top;
	}

	public void traverse(){
		for(int i = top-1; i >= 0; i--){
			System.out.print(elements[i] + " ");
		}
		System.out.println("");
	}

	public boolean isFullStack(){
		if(top >= MaxStack)
			return true;
		else
			return false;
	}

	public static void main(String[] args){
		StackArray myStack = new StackArray();
		myStack.initiateStack();
		myStack.push(3);
		myStack.push(7);
		myStack.deleteStack();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
		myStack.push(6);
		System.out.println("Stack size is " + myStack.stackSize());
		myStack.traverse();

	}

}
































